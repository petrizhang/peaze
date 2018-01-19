package com.pzque.interpreter;

import com.pzque.core.PeazeEnv;
import com.pzque.core.PeazeObject;
import com.pzque.parser.PeazeBaseVisitor;
import com.pzque.parser.PeazeParser;
import com.pzque.types.*;
import com.pzque.util.Utils;
import com.pzque.errors.RuntimeChecker;
import com.pzque.errors.SyntaxChecker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;


import java.util.ArrayList;
import java.util.List;

public class PeazeInterpreter extends PeazeBaseVisitor<PeazeObject> {
    private PeazeEnv curEnv;

    public PeazeInterpreter() {
        this.curEnv = new PeazeEnv(null);
    }

    public PeazeEnv getCurEnv() {
        return this.curEnv;
    }

    public PeazeObject eval(ParseTree ast) {
        return ast.accept(this);
    }

    @Override
    public PeazeObject visitProgram(PeazeParser.ProgramContext ctx) {
        PeazeObject value = PeazeUnspecified.getInstance();
        for (PeazeParser.TopunitContext unit : ctx.topunit()) {
            value = this.eval(unit);
        }
        return value;
    }

    @Override
    public PeazeObject visitDefineTopunit(PeazeParser.DefineTopunitContext ctx) {
        return this.eval(ctx.define());
    }

    @Override
    public PeazeObject visitApplyTopunit(PeazeParser.ApplyTopunitContext ctx) {
        return this.eval(ctx.apply());
    }

    @Override
    public PeazeObject visitProcDefine(PeazeParser.ProcDefineContext ctx) {
        String procName = ctx.ID().getText();
        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
        PeazeParser.SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        PeazeObject procValue = this.newProcedureValue(paramList, body);
        this.binds(ctx, procName, procValue);
        return PeazeUnspecified.getInstance();
    }

    @Override
    public PeazeObject visitLambdaDefine(PeazeParser.LambdaDefineContext ctx) {
        String procName = ctx.ID().getText();
        List<String> paramList = Utils.toStringList(ctx.lambda().paramList().ID());
        PeazeParser.SequenceContext body = ctx.lambda().sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        PeazeObject procValue = this.newProcedureValue(paramList, body);
        this.binds(ctx, procName, procValue);
        return PeazeUnspecified.getInstance();
    }

    @Override
    public PeazeObject visitVarDefine(PeazeParser.VarDefineContext ctx) {
        String name = ctx.ID().getText();
        // eval the bound expression
        PeazeObject value = this.eval(ctx.expr());
        this.binds(ctx, name, value);
        return PeazeUnspecified.getInstance();
    }

    @Override
    public PeazeObject visitApply(PeazeParser.ApplyContext ctx) {
        // fetch the invoked expression
        PeazeParser.ExprContext procedureCtx = ctx.procedure().expr();
        // eval the expression to fetch applicable PeazeProcedure value
        PeazeObject procValue = this.eval(procedureCtx);
        // check if the expression is applicable
        RuntimeChecker.CheckNotApplicable(procedureCtx, procValue);

        // eval expressions to get parameters' values
        List<PeazeParser.ExprContext> paramExprList = ctx.expr();
        ArrayList<PeazeObject> arguments = new ArrayList<>();
        for (PeazeParser.ExprContext exprCtx : paramExprList) {
            PeazeObject value = this.eval(exprCtx);
            arguments.add(value);
        }

        // execute procedure body
        return this.invoke(procedureCtx, procValue, arguments);
    }

    @Override
    public PeazeObject visitLiteralExpr(PeazeParser.LiteralExprContext ctx) {
        return this.eval(ctx.literal());
    }

    @Override
    public PeazeObject visitVarRefExpr(PeazeParser.VarRefExprContext ctx) {
        return this.eval(ctx.varRef());
    }

    @Override
    public PeazeObject visitLambdaExpr(PeazeParser.LambdaExprContext ctx) {
        return this.eval(ctx.lambda());
    }

    @Override
    public PeazeObject visitApplyExpr(PeazeParser.ApplyExprContext ctx) {
        return this.eval(ctx.apply());
    }

    @Override
    public PeazeObject visitIfExpr(PeazeParser.IfExprContext ctx) {
        return this.eval(ctx.if_());
    }

    @Override
    public PeazeObject visitFullIf(PeazeParser.FullIfContext ctx) {
        PeazeParser.ExprContext cond = ctx.cond().expr();
        PeazeParser.ExprContext body = ctx.expr();
        PeazeParser.ExprContext else_body = ctx.else_body().expr();

        PeazeObject condV = this.eval(cond);
        RuntimeChecker.CheckIfCond(ctx, condV);

        if (condV.asJavaBoolean()) {
            return this.eval(body);
        }
        return this.eval(else_body);
    }

    @Override
    public PeazeObject visitPartialIf(PeazeParser.PartialIfContext ctx) {
        PeazeParser.ExprContext cond = ctx.cond().expr();
        PeazeParser.ExprContext body = ctx.expr();

        PeazeObject condV = this.eval(cond);
        RuntimeChecker.CheckIfCond(ctx, condV);

        if (condV.asJavaBoolean()) {
            return this.eval(body);
        }
        return PeazeUnspecified.getInstance();
    }

    @Override
    public PeazeObject visitLambda(PeazeParser.LambdaContext ctx) {
        PeazeParser.SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
        return this.newProcedureValue(paramList, body);
    }

    @Override
    public PeazeObject visitVarRef(PeazeParser.VarRefContext ctx) {
        String varName = ctx.getText();
        RuntimeChecker.CheckUndefined(ctx, this.curEnv, varName);
        PeazeObject value = this.curEnv.lookup(varName);
        if (value == null) {
            value = new PeazeBuiltin(varName);
        }
        return value;
    }

    @Override
    public PeazeObject visitIntegerLiteral(PeazeParser.IntegerLiteralContext ctx) {
        String text = ctx.getText();
        Integer value = Integer.parseInt(text, 10);
        return new PeazeNumberInteger(value);
    }

    @Override
    public PeazeObject visitBooleanLiteral(PeazeParser.BooleanLiteralContext ctx) {
        String text = ctx.getText();
        return PeazeBoolean.fromString(text);
    }

    @Override
    public PeazeObject visitDecimalLiteral(PeazeParser.DecimalLiteralContext ctx) {
        String text = ctx.getText();
        return PeazeNumberReal.fromString(text);
    }

    void binds(ParserRuleContext ctx, String name, PeazeObject value) {
        // check if the variable is re-defined
        RuntimeChecker.CheckVariableReDefine(ctx, this.curEnv, name);
        this.curEnv.insert(name, value);
    }

    PeazeObject invoke(ParserRuleContext ctx, PeazeObject procValue, List<PeazeObject> arguments) {
        if (procValue.isBuiltin()) {
            return ((PeazeBuiltin) procValue).apply(ctx, arguments);
        }

        PeazeObject ret = PeazeUnspecified.getInstance();
        PeazeProcedure procedure = (PeazeProcedure) procValue;

        // init a new Env object and set it to curEnv
        PeazeEnv previousEnv = this.curEnv;
        PeazeEnv newEnv = new PeazeEnv(procedure.getEnv().getParent());
        procedure.setEnv(newEnv);
        this.curEnv = newEnv;

        // check if the param number matches expected
        RuntimeChecker.CheckContractViolation(ctx, procedure, arguments);

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

    PeazeObject newProcedureValue(List<String> params, PeazeParser.SequenceContext body) {
        PeazeEnv env = new PeazeEnv(this.curEnv);
        return new PeazeProcedure(env, params, body);
    }

    PeazeObject evalSequence(PeazeParser.SequenceContext ctx) {
        PeazeObject value = PeazeUnspecified.getInstance();
        List<PeazeParser.ExprContext> exprList = ctx.expr();
        assert !exprList.isEmpty();

        List<ParseTree> children = ctx.children;
        for (ParseTree ast : children) {
            value = this.eval(ast);
        }
        return value;
    }
}
