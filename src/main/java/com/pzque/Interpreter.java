package com.pzque;

import java.util.function.Function;

import org.antlr.v4.runtime.ParserRuleContext;
import com.pzque.PeazeParser.*;

public class Interpreter {

    public Value eval(ProgramContext ctx) {
        return this.dispatch(ctx, x -> Value.NULL);
    }

    private Value dispatch(ParserRuleContext ctx, Function<ParserRuleContext, Value> cont) {
        if (ctx instanceof ProgramContext) {
            return this.evalProgram((ProgramContext) ctx, cont);
        } else if (ctx instanceof ApplyContext) {
            return this.evalApply((ApplyContext) ctx, cont);
        }
        return Value.NULL;
    }


    private Value evalProgram(ProgramContext ctx, Function<ParserRuleContext, Value> cont) {
        return Value.NULL;
    }

    private Value evalApply(ApplyContext ctx, Function<ParserRuleContext, Value> cont) {
        return Value.NULL;
    }
}
