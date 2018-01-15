package com.pzque;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public class RuntimeChecker {
    public static void CheckNotApplicable(ParserRuleContext ctx, PeazeValue value) {
        if (!value.getType().isApplicable()) {
            PeazeError.runtimeError("NotApplicable",
                    "the expression in list head is not applicable",
                    ctx);
        }
    }

    public static void CheckVariableReDefine(ParserRuleContext ctx, PeazeEnv env, String varName) {
        if (env.contains(varName)) {
            PeazeError.runtimeError("VariableReDefine",
                    String.format("variable '%s' already exists, cannot re-define a variable", varName),
                    ctx);
        }
    }

    public static void CheckParamNotMatch(ParserRuleContext ctx, PeazeFunction function, List<PeazeValue> paramValues) {
        int expected = function.getParamCount();
        int given = paramValues.size();
        if (expected != given) {
            PeazeError.runtimeError("ParamNotMatch",
                    String.format(" the expected number of arguments does not match the given number\nexpected: %s\ngiven: %s",
                            expected, given),
                    ctx);
        }
    }
}
