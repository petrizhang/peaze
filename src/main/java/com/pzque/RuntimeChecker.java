package com.pzque;

import org.antlr.v4.runtime.ParserRuleContext;

public class RuntimeChecker {
    public static void CheckNotApplicable(ParserRuleContext ctx, PeazeValue value) {
        if (!value.getType().isApplicable()) {
            PeazeError.runtimeError("NotApplicable",
                    "the expressiong invoked must be applicable",
                    ctx);
        }
    }
}
