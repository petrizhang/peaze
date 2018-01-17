package com.pzque;

import com.pzque.core.PeazeEnv;
import com.pzque.core.PeazeObject;
import com.pzque.types.PeazeBuiltin;
import com.pzque.types.PeazeProcedure;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public class RuntimeChecker {
    public static void CheckNotApplicable(ParserRuleContext ctx, PeazeObject value) {
        if (!value.isApplicable()) {
            PeazeError.runtimeError("not a procedure",
                    "expected a procedure that can be applied to arguments",
                    ctx);
        }
    }

    public static void CheckUndefined(ParserRuleContext ctx, PeazeEnv env, String varName) {
        if (!env.contains(varName) && !PeazeBuiltin.buitinMap.containsKey(varName)) {
            PeazeError.runtimeError("undefined",
                    String.format(" cannot reference the identifier '%s' before its definition", varName),
                    ctx);
        }

    }

    public static void CheckVariableReDefine(ParserRuleContext ctx, PeazeEnv env, String varName) {
        if (env.contains(varName)) {
            PeazeError.runtimeError("variable re-define",
                    String.format("variable '%s' already exists, cannot re-define a variable", varName),
                    ctx);
        }
    }

    public static void CheckParamNotMatch(ParserRuleContext ctx, PeazeProcedure procedure, List<PeazeObject> paramValues) {
        int expected = procedure.getParamCount();
        int given = paramValues.size();
        if (expected != given) {
            PeazeError.runtimeError("contract violation",
                    String.format(" the expected number of arguments does not match the given number\nexpected: %s\ngiven: %s",
                            expected, given),
                    ctx);
        }
    }

    public static void CheckParamNotMatch(ParserRuleContext ctx, int expected, int given) {
        if (expected != given) {
            PeazeError.runtimeError("contract violation",
                    String.format(" the expected number of arguments does not match the given number\nexpected: %s\ngiven: %s",
                            expected, given),
                    ctx);
        }
    }

    static public void AssertIsNumber(String op, int pos, ParserRuleContext ctx, PeazeObject value) {
        if (!value.isNumber()) {
            PeazeError.runtimeError("%s: contract violation",
                    String.format("expected: number?, given: %s, argument position: %s", op, value, pos),
                    ctx);
        }
    }
}
