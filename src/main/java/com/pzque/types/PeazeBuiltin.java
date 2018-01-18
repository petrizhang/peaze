package com.pzque.types;

import com.pzque.RuntimeChecker;
import com.pzque.Utils;
import com.pzque.core.PeazeObject;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class PeazeBuiltin extends PeazeObject {
    public PeazeBuiltin(String opString) {
        assert buitinMap.containsKey(opString);
        this.op = buitinMap.get(opString);
    }

    public PeazeObject apply(ParserRuleContext ctx, List<PeazeObject> arguments) {
        return this.op.apply(ctx, arguments);
    }


    public static PeazeNumber add(ParserRuleContext ctx, List<PeazeObject> values) {
        int given = values.size();

        if (given == 0) {
            return new PeazeNumberInteger(0);
        }

        if (given == 1) {
            PeazeObject v = values.get(0);
            RuntimeChecker.AssertNumberParam("+", 1, ctx, v);
            return (PeazeNumber) v;
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

    public static PeazeNumber sub(ParserRuleContext ctx, List<PeazeObject> values) {
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

    public static PeazeBoolean eq(ParserRuleContext ctx, List<PeazeObject> values) {
        return sequenceCompare(CompareOp.EQ, ctx, values);
    }

    public static PeazeBoolean le(ParserRuleContext ctx, List<PeazeObject> values) {
        return sequenceCompare(CompareOp.LE, ctx, values);
    }

    public static PeazeBoolean ge(ParserRuleContext ctx, List<PeazeObject> values) {
        return sequenceCompare(CompareOp.GE, ctx, values);
    }

    public static PeazeBoolean lt(ParserRuleContext ctx, List<PeazeObject> values) {
        return sequenceCompare(CompareOp.LT, ctx, values);
    }

    public static PeazeBoolean gt(ParserRuleContext ctx, List<PeazeObject> values) {
        return sequenceCompare(CompareOp.GT, ctx, values);
    }

    private static PeazeBoolean sequenceCompare(CompareOp op, ParserRuleContext ctx, List<PeazeObject> values) {
        int given = values.size();

        if (given < 2) {
            RuntimeChecker.raiseContractViolation(ctx, "at least 2", Integer.toString(given));
        }

        PeazeObject prev, current;
        PeazeNumber prevNum, currentNum;
        prev = values.get(0);
        RuntimeChecker.AssertNumberParam("+", 1, ctx, prev);
        prevNum = (PeazeNumber) prev;
        boolean tmp;
        for (int i = 1; i < values.size(); i++) {
            current = values.get(i);
            RuntimeChecker.AssertNumberParam(op.toString(), i + 1, ctx, current);
            currentNum = (PeazeNumber) current;
            switch (op) {
                case EQ:
                    tmp = currentNum.eq(prevNum);
                    break;
                case LE:
                    tmp = currentNum.le(prevNum);
                    break;
                case GE:
                    tmp = currentNum.ge(prevNum);
                    break;
                case LT:
                    tmp = currentNum.lt(prevNum);
                    break;
                case GT:
                    tmp = currentNum.gt(prevNum);
                    break;
                default:
                    throw Utils.WrongBranch;
            }
            if (!tmp) {
                return PeazeBoolean.getFalse();
            }
            prevNum = currentNum;
        }

        return PeazeBoolean.getTrue();
    }

    private enum CompareOp {
        EQ, LE, GE, LT, GT;

        @Override
        public String toString() {
            switch (this) {
                case EQ:
                    return "=";
                case LE:
                    return "<=";
                case GE:
                    return ">=";
                case LT:
                    return "<";
                case GT:
                    return ">";
                default:
                    throw Utils.WrongBranch;
            }
        }
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


    @Override
    public String getTypeString() {
        return "builtin-procedure";
    }

    @Override
    public boolean isApplicable() {
        return true;
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }

    public static final HashMap<String, BiFunction<ParserRuleContext, List<PeazeObject>, PeazeObject>>
            buitinMap = new HashMap<String, BiFunction<ParserRuleContext, List<PeazeObject>, PeazeObject>>() {
        {
            put("+", PeazeBuiltin::add);
            put("-", PeazeBuiltin::sub);
            put("=", PeazeBuiltin::eq);
            put("<=", PeazeBuiltin::le);
            put(">=", PeazeBuiltin::ge);
            put("<", PeazeBuiltin::lt);
            put(">", PeazeBuiltin::gt);
            put("display", PeazeBuiltin::display);
        }
    };
    private BiFunction<ParserRuleContext, List<PeazeObject>, PeazeObject> op;
}
