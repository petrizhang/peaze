package com.pzque.types;

import com.pzque.RuntimeChecker;
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
        int given = values.size();

        if (given == 0) {
            return new PeazeNumberInteger(0);
        }

        if (given == 1) {
            PeazeObject v = values.get(0);
            RuntimeChecker.AssertNumberParam("+", 1, ctx, v);
            return v;
        }

        PeazeNumber sum = new PeazeNumberInteger(0);
        PeazeObject v;
        for (int i = 0; i < values.size(); i++) {
            v = values.get(i);
            RuntimeChecker.AssertNumberParam("+", i + 1, ctx, v);
            sum = sum.add((PeazeNumber) v);
        }
        return sum;
    }

    static PeazeObject sub(ParserRuleContext ctx, List<PeazeObject> values) {
        int given = values.size();
        if (given < 1) {
            RuntimeChecker.raiseContractViolation(ctx, "at least one", Integer.toString(given));
        }
        PeazeObject firstObject = values.get(0);
        RuntimeChecker.AssertNumberParam("-", 1, ctx, firstObject);
        PeazeNumber firstNumber = (PeazeNumber) firstObject;

        if (given == 1) {
            firstNumber.setNegative();
            return firstNumber;
        }

        PeazeObject v;
        for (int i = 1; i < values.size(); i++) {
            v = values.get(i);
            RuntimeChecker.AssertNumberParam("-", i + 1, ctx, v);
            firstNumber = firstNumber.sub((PeazeNumber) v);
        }
        return firstNumber;
    }

    static PeazeObject display(ParserRuleContext ctx, List<PeazeObject> values) {
        int given = values.size();
        if (given < 1 || given > 2) {
            RuntimeChecker.raiseContractViolation(ctx, "1-2", Integer.toString(given));
        }

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
            put("-", PeazeBuiltin::sub);
            put("display", PeazeBuiltin::display);
        }
    };
}
