package com.pzque.core;

import com.pzque.RuntimeChecker;
import com.pzque.Utils;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class Builtin {
    public Builtin(String opString) {
        assert buitinMap.containsKey(opString);
        this.op = buitinMap.get(opString);
    }

    public PeazeValue apply(ParserRuleContext ctx, List<PeazeValue> arguments) {
        return this.op.apply(ctx, arguments);
    }

    private BiFunction<ParserRuleContext, List<PeazeValue>, PeazeValue> op;

    /* static methods */

    static PeazeValue add(ParserRuleContext ctx, List<PeazeValue> values) {
        RuntimeChecker.CheckADD(ctx, values);
        double doubleSum = 0.0;
        int intSum = 0;
        boolean hasDouble = false;
        for (PeazeValue v : values) {
            if (v.isInteger()) {
                intSum += v.asInteger();
            } else if (v.isDouble()) {
                hasDouble = true;
                doubleSum += v.asDouble();
            } else {
                throw Utils.WrongBranch;
            }
        }

        if (hasDouble) {
            return new PeazeValue(doubleSum + intSum);
        }

        return new PeazeValue(intSum);
    }

    static PeazeValue display(ParserRuleContext ctx, List<PeazeValue> values) {
        RuntimeChecker.CheckParamNotMatch(ctx, values.size(), 1);
        PeazeValue value = values.get(0);
        System.out.println(value);
        return value;
    }

    //    static PeazeValue sub() {
//
//    }
//
//    static PeazeValue mul() {
//
//    }
//
//    static PeazeValue div() {
//
//    }
////
//    static PeazeValue and() {
//
//    }
//
//    static PeazeValue or() {
//
//    }
    public static final HashMap<String, BiFunction<ParserRuleContext, List<PeazeValue>, PeazeValue>>
            buitinMap = new HashMap<String, BiFunction<ParserRuleContext, List<PeazeValue>, PeazeValue>>() {
        {
            put("+", Builtin::add);
            put("display", Builtin::display);
        }
    };
}
