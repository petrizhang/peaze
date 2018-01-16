package com.pzque;

import org.antlr.v4.runtime.ParserRuleContext;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Peaze interpreter.
 */
public class PeazeInterpreter extends PeazeBaseVisitor<PeazeValue> {
    private PeazeEnv curEnv;

    /**
     * Instantiates a new Peaze interpreter.
     */
    public PeazeInterpreter() {
        this.curEnv = new PeazeEnv(null);
    }

    /**
     * Gets cur env.
     *
     * @return the cur env
     */
    public PeazeEnv getCurEnv() {
        return this.curEnv;
    }

    /**
     * Eval peaze value.
     *
     * @param ctx the ctx
     * @return the peaze value
     */
    public PeazeValue eval(ParserRuleContext ctx) {
        return ctx.accept(this);
    }

    @Override
    public PeazeValue visitProgram(PeazeParser.ProgramContext ctx) {
        PeazeValue value = PeazeValue.UNDEFINED;
        for (PeazeParser.TopunitContext unit : ctx.topunit()) {
            value = this.eval(unit);
        }
        return value;
    }

    @Override
    public PeazeValue visitDefineTopunit(PeazeParser.DefineTopunitContext ctx) {
        return this.eval(ctx.define());
    }

    @Override
    public PeazeValue visitApplyTopunit(PeazeParser.ApplyTopunitContext ctx) {
        return this.eval(ctx.apply());
    }

    @Override
    public PeazeValue visitFuncDefine(PeazeParser.FuncDefineContext ctx) {
        String funcName = ctx.ID().getText();
        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
        PeazeParser.SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        PeazeValue funcValue = new PeazeValue(new PeazeFunction(paramList, body));
        this.binds(ctx, funcName, funcValue);
        return PeazeValue.UNDEFINED;
    }

    @Override
    public PeazeValue visitLambdaDefine(PeazeParser.LambdaDefineContext ctx) {
        String funcName = ctx.ID().getText();
        List<String> paramList = Utils.toStringList(ctx.lambda().paramList().ID());
        PeazeParser.SequenceContext body = ctx.lambda().sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        PeazeValue funcValue = new PeazeValue(new PeazeFunction(paramList, body));
        this.binds(ctx, funcName, funcValue);
        return PeazeValue.UNDEFINED;
    }

    @Override
    public PeazeValue visitVarDefine(PeazeParser.VarDefineContext ctx) {
        String name = ctx.ID().getText();
        // eval the bound expression
        PeazeValue value = this.eval(ctx.expr());
        this.binds(ctx, name, value);
        return PeazeValue.UNDEFINED;
    }

    @Override
    public PeazeValue visitApply(PeazeParser.ApplyContext ctx) {
        // fetch the invoked expression
        PeazeParser.ExprContext functionCtx = ctx.procedure().expr();
        // eval the expression to fetch applicable PeazeFunction value
        PeazeValue funcValue = this.eval(functionCtx);
        // check if the expression is applicable
        RuntimeChecker.CheckNotApplicable(functionCtx, funcValue);

        // eval expressions to get parameters' values
        List<PeazeParser.ExprContext> paramExprList = ctx.expr();
        ArrayList<PeazeValue> paramValues = new ArrayList<>();
        for (PeazeParser.ExprContext exprCtx : paramExprList) {
            PeazeValue value = this.eval(exprCtx);
            paramValues.add(value);
        }

        // execute function body
        PeazeFunction function = funcValue.asFunction();
        return this.invoke(functionCtx, function, paramValues);
    }

    @Override
    public PeazeValue visitLiteralExpr(PeazeParser.LiteralExprContext ctx) {
        return this.eval(ctx.literal());
    }

    @Override
    public PeazeValue visitVarRefExpr(PeazeParser.VarRefExprContext ctx) {
        return this.eval(ctx.varRef());
    }

    @Override
    public PeazeValue visitLambdaExpr(PeazeParser.LambdaExprContext ctx) {
        return this.eval(ctx.lambda());
    }

    @Override
    public PeazeValue visitApplyExpr(PeazeParser.ApplyExprContext ctx) {
        return this.eval(ctx.apply());
    }

    @Override
    public PeazeValue visitLambda(PeazeParser.LambdaContext ctx) {
        PeazeParser.SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(ctx);
        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
        return new PeazeValue(new PeazeFunction(paramList, body));
    }

    @Override
    public PeazeValue visitVarRef(PeazeParser.VarRefContext ctx) {
        // TODO check if the variable exists
        String varName = ctx.getText();
        return this.curEnv.lookup(varName);
    }

    @Override
    public PeazeValue visitIntegerLiteral(PeazeParser.IntegerLiteralContext ctx) {
        String text = ctx.getText();
        Integer value = Integer.parseInt(text, 10);
        return new PeazeValue(value);
    }

    @Override
    public PeazeValue visitBooleanLiteral(PeazeParser.BooleanLiteralContext ctx) {
        String text = ctx.getText();
        boolean value;
        value = text.equals("#t");
        return new PeazeValue(value);
    }

    @Override
    public PeazeValue visitDecimalLiteral(PeazeParser.DecimalLiteralContext ctx) {
        String text = ctx.getText();
        Double value = Double.parseDouble(text);
        return new PeazeValue(value);
    }

    /**
     * Binds.
     *
     * @param ctx   the ctx
     * @param name  the name
     * @param value the value
     */
    void binds(ParserRuleContext ctx, String name, PeazeValue value) {
        // check if the variable is re-defined
        RuntimeChecker.CheckVariableReDefine(ctx, this.curEnv, name);
        this.curEnv.insert(name, value);
    }

    /**
     * Invoke peaze value.
     *
     * @param ctx         the ctx
     * @param function    the function
     * @param paramValues the param values
     * @return the peaze value
     */
    PeazeValue invoke(ParserRuleContext ctx, PeazeFunction function, List<PeazeValue> paramValues) {
        // check if the param number matches expected
        RuntimeChecker.CheckParamNotMatch(ctx, function, paramValues);

        // init a new Env object and set it to curEnv
        PeazeEnv env = new PeazeEnv(this.curEnv);
        this.curEnv = env;

        // insert parameters' values to the associated function environment
        List<String> params = function.getParams();
        int paramCount = function.getParamCount();
        for (int i = 0; i < paramCount; i++) {
            env.insert(params.get(i), paramValues.get(i));
        }

        // execute function body
        PeazeValue ret = this.evalSequence(function.getBody());

        // after execution, reset curEnv to previous level
        this.curEnv = env.getParent();

        return ret;
    }

    /**
     * Evaluating a sequence of define/expression, return the last expression's evaluation result
     *
     * @param ctx the sequence syntax tree
     * @return the last expression's evaluation result
     */
    PeazeValue evalSequence(PeazeParser.SequenceContext ctx) {
        PeazeValue value = PeazeValue.UNDEFINED;
        List<PeazeParser.ExprContext> exprList = ctx.expr();
        assert !exprList.isEmpty();
        for (PeazeParser.ExprContext expr : ctx.expr()) {
            value = this.eval(expr);
        }
        return value;
    }
}