package com.pzque;

import com.pzque.core.PeazeBuiltin;
import com.pzque.core.PeazeEnv;
import com.pzque.core.PeazeProcedure;
import com.pzque.core.PeazeValue;
import com.pzque.parser.PeazeBaseVisitor;
import com.pzque.parser.PeazeParser;
import org.antlr.v4.runtime.ParserRuleContext;


import java.util.ArrayList;
import java.util.List;

public class PeazeInterpreter extends PeazeBaseVisitor<PeazeValue> {
    private PeazeEnv curEnv;

    public PeazeInterpreter() {
        this.curEnv = new PeazeEnv(null);
    }

    public PeazeEnv getCurEnv() {
        return this.curEnv;
    }

    public PeazeValue eval(ParserRuleContext ctx) {
        return ctx.accept(this);
    }

    @Override
    public PeazeValue visitProgram(PeazeParser.ProgramContext ctx) {
        PeazeValue value = PeazeValue.UNSPECIFIED;
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
    public PeazeValue visitProcDefine(PeazeParser.ProcDefineContext ctx) {
        String procName = ctx.ID().getText();
        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
        PeazeParser.SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        PeazeValue procValue = this.newProcedureValue(paramList, body);
        this.binds(ctx, procName, procValue);
        return PeazeValue.UNSPECIFIED;
    }

    @Override
    public PeazeValue visitLambdaDefine(PeazeParser.LambdaDefineContext ctx) {
        String procName = ctx.ID().getText();
        List<String> paramList = Utils.toStringList(ctx.lambda().paramList().ID());
        PeazeParser.SequenceContext body = ctx.lambda().sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        PeazeValue procValue = this.newProcedureValue(paramList, body);
        this.binds(ctx, procName, procValue);
        return PeazeValue.UNSPECIFIED;
    }

    @Override
    public PeazeValue visitVarDefine(PeazeParser.VarDefineContext ctx) {
        String name = ctx.ID().getText();
        // eval the bound expression
        PeazeValue value = this.eval(ctx.expr());
        this.binds(ctx, name, value);
        return PeazeValue.UNSPECIFIED;
    }

    @Override
    public PeazeValue visitApply(PeazeParser.ApplyContext ctx) {
        // fetch the invoked expression
        PeazeParser.ExprContext procedureCtx = ctx.procedure().expr();
        // eval the expression to fetch applicable PeazeProcedure value
        PeazeValue procValue = this.eval(procedureCtx);
        // check if the expression is applicable
        RuntimeChecker.CheckNotApplicable(procedureCtx, procValue);

        // eval expressions to get parameters' values
        List<PeazeParser.ExprContext> paramExprList = ctx.expr();
        ArrayList<PeazeValue> arguments = new ArrayList<>();
        for (PeazeParser.ExprContext exprCtx : paramExprList) {
            PeazeValue value = this.eval(exprCtx);
            arguments.add(value);
        }

        // execute procedure body
        return this.invoke(procedureCtx, procValue, arguments);
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
        SyntaxChecker.CheckInvalidSequence(body);
        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
        return this.newProcedureValue(paramList, body);
    }

    @Override
    public PeazeValue visitVarRef(PeazeParser.VarRefContext ctx) {
        String varName = ctx.getText();
        RuntimeChecker.CheckUndefined(ctx, this.curEnv, varName);
        PeazeValue value = this.curEnv.lookup(varName);
        if (value == null) {
            value = new PeazeValue(new PeazeBuiltin(varName));
        }
        return value;
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

    void binds(ParserRuleContext ctx, String name, PeazeValue value) {
        // check if the variable is re-defined
        RuntimeChecker.CheckVariableReDefine(ctx, this.curEnv, name);
        this.curEnv.insert(name, value);
    }

    PeazeValue invoke(ParserRuleContext ctx, PeazeValue procValue, List<PeazeValue> arguments) {
        if (procValue.isBuiltin()) {
            return procValue.asBuiltin().apply(ctx, arguments);
        }

        PeazeValue ret = PeazeValue.UNSPECIFIED;
        PeazeProcedure procedure = procValue.asProcedure();

        // init a new Env object and set it to curEnv
        PeazeEnv previousEnv = this.curEnv;
        PeazeEnv newEnv = new PeazeEnv(procedure.getEnv().getParent());
        procedure.setEnv(newEnv);
        this.curEnv = newEnv;

        // check if the param number matches expected
        RuntimeChecker.CheckParamNotMatch(ctx, procedure, arguments);

        // insert parameters' values to the associated procedure environment
        List<String> params = procedure.getParams();
        int paramCount = procedure.getParamCount();
        for (int i = 0; i < paramCount; i++) {
            this.curEnv.insert(params.get(i), arguments.get(i));
        }

        // execute procedure body
        ret = this.evalSequence(procedure.getBody());
        // after procedure execution, reset curEnv to previous level
        this.curEnv = previousEnv;
        return ret;
    }

    PeazeValue newProcedureValue(List<String> params, PeazeParser.SequenceContext body) {
        PeazeEnv env = new PeazeEnv(this.curEnv);
        return new PeazeValue(new PeazeProcedure(env, params, body));
    }

    PeazeValue evalSequence(PeazeParser.SequenceContext ctx) {
        PeazeValue value = PeazeValue.UNSPECIFIED;
        List<PeazeParser.ExprContext> exprList = ctx.expr();
        assert !exprList.isEmpty();
        for (PeazeParser.ExprContext expr : ctx.expr()) {
            value = this.eval(expr);
        }
        return value;
    }
}
