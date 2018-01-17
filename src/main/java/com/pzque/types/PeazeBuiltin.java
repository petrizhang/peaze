package com.pzque.types;

import com.pzque.RuntimeChecker;
import com.pzque.Utils;
import com.pzque.core.PeazeObject;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class PeazeBuiltin extends PeazeObject {
    public PeazeBuiltin(String opString) {
        assert buitinMap.containsKey(opString);
        this.op = buitinMap.get(opString);
    }

    @Override
    public boolean isApplicable() {
        return true;
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }

    public PeazeObject apply(ParserRuleContext ctx, List<PeazeObject> arguments) {
        return this.op.apply(ctx, arguments);
    }

    private BiFunction<ParserRuleContext, List<PeazeObject>, PeazeObject> op;

    /* static methods */

    static PeazeObject add(ParserRuleContext ctx, List<PeazeObject> values) {
        PeazeNumber sum = new PeazeInteger(0);
        PeazeObject v;
        for (int i = 0; i < values.size(); i++) {
            v = values.get(i);
            RuntimeChecker.AssertIsNumber("+", i + 1, ctx, v);
            sum = sum.add((PeazeNumber) v);
        }
        return sum;
    }

    static PeazeObject display(ParserRuleContext ctx, List<PeazeObject> values) {
        RuntimeChecker.CheckParamNotMatch(ctx, values.size(), 1);
        PeazeObject value = values.get(0);
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
    public static final HashMap<String, BiFunction<ParserRuleContext, List<PeazeObject>, PeazeObject>>
            buitinMap = new HashMap<String, BiFunction<ParserRuleContext, List<PeazeObject>, PeazeObject>>() {
        {
            put("+", PeazeBuiltin::add);
            put("display", PeazeBuiltin::display);
        }
    };
}
