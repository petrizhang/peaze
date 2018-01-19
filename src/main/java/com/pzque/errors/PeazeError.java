package com.pzque.errors;

import com.pzque.util.Utils;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * The type Peaze error.
 */
public class PeazeError {
    public static void runtimeError(String errName, String msg, ParserRuleContext ctx) {
        PeazeError.error("Runtime Error", errName, msg, ctx);
        throw new PeazeException(msg);
    }

    public static void syntaxError(String errName, String msg, ParserRuleContext ctx) {
        PeazeError.error("Syntax Error", errName, msg, ctx);
        throw new PeazeException(msg);
    }

    public static void error(String kind, String errName, String msg, ParserRuleContext ctx) {
        String pos = Utils.getPosString(ctx);
        String sourceCode = Utils.getOriginalText(ctx);
        msg = String.format("%s in %s: %s: %s:\n%s\n",
                kind, pos, errName, msg, sourceCode);
        throw new PeazeException(msg);
    }
}

