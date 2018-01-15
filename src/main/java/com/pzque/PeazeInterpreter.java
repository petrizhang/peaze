package com.pzque;

import com.pzque.PeazeParser.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PeazeInterpreter {
    private PeazeEnv GlobalEnv;
    private Stack<PeazeEnv> envStack;

    private PeazeEnv getCurEnv() {
        return envStack.lastElement();
    }

    public PeazeInterpreter() {
        this.GlobalEnv = new PeazeEnv(null);
        this.envStack = new Stack<>();
        envStack.push(GlobalEnv);
    }

    public PeazeValue eval(ParseTree ast) {
        return PeazeValue.UNDEFINED;
    }

    /* ---------------eval function call --------------- */
    public PeazeValue evalExprApply(ExprApplyContext ctx) {
        ExprContext functionCtx = ctx.expr(0);
        PeazeValue functionValue = this.eval(functionCtx);

        // check if the expression is applicable
        if (!functionValue.getType().isApplicable()) {
            PeazeError.NotApplicable(functionCtx);
        }

        PeazeFunction function = functionValue.asFunction();

        return PeazeValue.UNDEFINED;
    }

    public PeazeValue evalBuiltinApply(BuiltinApplyContext ctx) {
        return PeazeValue.UNDEFINED;
    }

    public PeazeValue evalLambdaApply(LambdaApplyContext ctx) {
        return PeazeValue.UNDEFINED;
    }


    /* --------------- eval definition --------------- */
    public PeazeValue evalLambdaDefine(LambdaDefineContext ctx) {
        String funcName = ctx.symbol().getText();
        List<SymbolContext> paramSymbolContextList = ctx.lambda().symbol();
        SequenceContext body = ctx.lambda().sequence();
        return this.funcDefHelp(funcName, paramSymbolContextList, body);
    }

    public PeazeValue evalFuncDefine(FuncDefineContext ctx) {
        List<SymbolContext> symbolContextList = ctx.symbol();
        SequenceContext body = ctx.sequence();
        String funcName = symbolContextList.remove(0).getText();
        return this.funcDefHelp(funcName, symbolContextList, body);
    }

    private PeazeValue funcDefHelp(String funcName,
                                   List<SymbolContext> paramSymbolContextList,
                                   SequenceContext body) {
        // create environment for function
        PeazeEnv env = new PeazeEnv(this.getCurEnv());
        // fetch param names from paramSymbolContextList
        List<String> nameList = new ArrayList<>();
        for (SymbolContext symbolContext : paramSymbolContextList)
            nameList.add(symbolContext.getText());
        // create a PeazeFunction from environment, params and function body
        PeazeFunction function = new PeazeFunction(env, nameList, body);
        // wrap the function in a PeazeValue
        PeazeValue value = new PeazeValue(function);
        // insert new symbol(the function) to current environment
        this.getCurEnv().insert(funcName, value);
        return PeazeValue.UNDEFINED;
    }

    public PeazeValue evalVarDefine(VarDefineContext ctx) {
        String name = ctx.symbol().getText();
        PeazeValue value = this.eval(ctx.expr());
        this.getCurEnv().insert(name, value);
        return PeazeValue.UNDEFINED;
    }

    /* --------------- eval literal --------------- */
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
