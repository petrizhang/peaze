package com.pzque;

import com.pzque.PeazeParser.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PeazeInterpreter {
    private PeazeEnv GlobalEnv;
    private Stack<PeazeEnv> envStack;
    private SyntaxChecker checker;

    public PeazeEnv getCurEnv() {
        return envStack.lastElement();
    }

    public PeazeInterpreter() {
        this.GlobalEnv = new PeazeEnv(null);
        this.envStack = new Stack<>();
        this.checker = new SyntaxChecker();
        envStack.push(GlobalEnv);
    }

    /* --------------- eval definition --------------- */
    public PeazeValue evalLambdaDefine(LambdaDefineContext ctx) {
        String funcName = ctx.symbol().getText();
        List<SymbolContext> paramSymbolContextList = ctx.lambda().symbol();
        SequenceContext body = ctx.lambda().sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        return this.funcDefHelp(funcName, paramSymbolContextList, body);
    }

    public PeazeValue evalFuncDefine(FuncDefineContext ctx) {
        List<SymbolContext> symbolContextList = ctx.symbol();
        SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(body);
        String funcName = symbolContextList.remove(0).getText();
        return this.funcDefHelp(funcName, symbolContextList, body);
    }

    private PeazeValue funcDefHelp(String funcName,
                                   List<SymbolContext> paramSymbolContextList,
                                   SequenceContext body) {
        PeazeValue value = this.newFunctionValue(paramSymbolContextList, body);
        // insert new symbol(the function) to current environment
        this.getCurEnv().insert(funcName, value);
        return PeazeValue.UNDEFINED;
    }

    private PeazeValue newFunctionValue(List<SymbolContext> paramSymbolContextList, SequenceContext body) {
        // create environment for function
        PeazeEnv env = new PeazeEnv(this.getCurEnv());
        List<String> nameList = new ArrayList<>();
        for (SymbolContext symbolContext : paramSymbolContextList)
            nameList.add(symbolContext.getText());
        // create a PeazeFunction from environment, params and function body
        PeazeFunction function = new PeazeFunction(env, nameList, body);
        // wrap the function in a PeazeValue
        return new PeazeValue(function);
    }

    public PeazeValue evalVarDefine(VarDefineContext ctx) {
        PeazeEnv env = this.getCurEnv();
        String name = ctx.symbol().getText();
        // check if the variable is re-defined
        RuntimeChecker.CheckVariableReDefine(ctx, env, name);
        PeazeValue value = this.evalExpr(ctx.expr());
        env.insert(name, value);
        return PeazeValue.UNDEFINED;
    }

    /* --------------- eval expr --------------- */
    public PeazeValue evalExpr(ExprContext ctx) {
        if (ctx instanceof LiteralExprContext) {
            return this.evalLiteralExpr((LiteralExprContext) ctx);
        } else if (ctx instanceof SymbolExprContext) {
            return this.evalSymbolExpr((SymbolExprContext) ctx);
        } else if (ctx instanceof LambdaExprContext) {
            return this.evalLambdaExpr((LambdaExprContext) ctx);
        } else if (ctx instanceof ApplyExprContext) {
            return this.evalApplyExpr((ApplyExprContext) ctx);
        }

        throw Utils.WrongBranch;
    }

    public PeazeValue evalLiteralExpr(LiteralExprContext ctx) {
        return this.evalLiteral(ctx.literal());
    }

    public PeazeValue evalSymbolExpr(SymbolExprContext ctx) {
        return this.evalSymbolReference(ctx.symbol());
    }

    public PeazeValue evalLambdaExpr(LambdaExprContext ctx) {
        return this.evalLambda(ctx.lambda());
    }

    public PeazeValue evalLambda(LambdaContext ctx) {
        SequenceContext body = ctx.sequence();
        // check if the sequence ends with a expression
        SyntaxChecker.CheckInvalidSequence(ctx);
        List<SymbolContext> paramSymbolContextList = ctx.symbol();
        return this.newFunctionValue(paramSymbolContextList, body);
    }

    public PeazeValue evalApplyExpr(ApplyExprContext ctx) {
        return this.evalApply(ctx.apply());
    }

    /* ---------------eval function call --------------- */
    public PeazeValue evalApply(ApplyContext ctx) {
        if (ctx instanceof ExprApplyContext) {
            return this.evalExprApply((ExprApplyContext) ctx);
        } else if (ctx instanceof BuiltinApplyContext) {
            return this.evalBuiltinApply((BuiltinApplyContext) ctx);
        } else if (ctx instanceof LambdaApplyContext) {
            return this.evalLambdaApply((LambdaApplyContext) ctx);
        }
        throw Utils.WrongBranch;
    }

    public PeazeValue evalExprApply(ExprApplyContext ctx) {
        // TODO push a env to envStack
        List<ExprContext> exprList = ctx.expr();

        ExprContext functionCtx = exprList.remove(0);
        PeazeValue functionValue = this.evalExpr(functionCtx);

        // check if the expression is applicable
        RuntimeChecker.CheckNotApplicable(functionCtx, functionValue);

        PeazeFunction function = functionValue.asFunction();
        ArrayList<PeazeValue> paramValues = new ArrayList<>();

        for (ExprContext exprCtx : exprList) {
            PeazeValue value = this.evalExpr(exprCtx);
            paramValues.add(value);
        }

        // check if the param number matches expected
        RuntimeChecker.CheckParamNotMatch(ctx, function, paramValues);
        List<String> params = function.getParams();
        SequenceContext body = function.getBody();
        PeazeEnv env = function.getEnv();

        int paramCount = function.getParamCount();
        for (int i = 0; i < paramCount; i++) {
            env.insert(params.get(i), paramValues.get(i));
        }
        // TODO eval function body
        return PeazeValue.UNDEFINED;
    }

    public PeazeValue evalBuiltinApply(BuiltinApplyContext ctx) {
        return PeazeValue.UNDEFINED;
    }

    public PeazeValue evalLambdaApply(LambdaApplyContext ctx) {
        return PeazeValue.UNDEFINED;
    }


    /* --------------- eval symbol reference --------------- */
    public PeazeValue evalSymbolReference(SymbolContext ctx) {
        // TODO check if the variable exists
        String varName = ctx.getText();
        return this.getCurEnv().lookup(varName);
    }

    /* --------------- eval literal --------------- */
    public PeazeValue evalLiteral(LiteralContext ctx) {
        if (ctx instanceof IntegerLiteralContext) {
            return this.evalIntegerLiteral((IntegerLiteralContext) ctx);
        } else if (ctx instanceof BooleanLiteralContext) {
            return this.evalBooleanLiteral((BooleanLiteralContext) ctx);
        } else if (ctx instanceof DecimalLiteralContext) {
            return this.evalDecimalLiteral((DecimalLiteralContext) ctx);
        }

        throw Utils.WrongBranch;
    }

    public PeazeValue evalIntegerLiteral(IntegerLiteralContext ctx) {
        String text = ctx.getText();
        Integer value = Integer.parseInt(text, 10);
        return new PeazeValue(value);
    }

    public PeazeValue evalBooleanLiteral(BooleanLiteralContext ctx) {
        String text = ctx.getText();
        Boolean value = Boolean.parseBoolean(text);
        return new PeazeValue(value);
    }

    public PeazeValue evalDecimalLiteral(DecimalLiteralContext ctx) {
        String text = ctx.getText();
        Double value = Double.parseDouble(text);
        return new PeazeValue(value);
    }
}
