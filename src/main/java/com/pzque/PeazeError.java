package com.pzque;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * The type Peaze error.
 */
public class PeazeError {

    /**
     * Not applicable error.
     *
     * @param ctx the syntax tree of the expression
     */
    public static void NotApplicable(ParserRuleContext ctx) {
        String msg = String.format("the expression is not applicable");
        PeazeError.runtimeError("NotApplicable", msg, ctx);
    }

    public static void InvalidSequence(PeazeParser.SequenceContext ctx) {
        String msg = "a sequence must be end with a expression";
        PeazeError.syntaxError("InvalidSequence", msg, ctx);
    }

    private static void runtimeError(String errName, String msg, ParserRuleContext ctx) {
        PeazeError.error("Runtime Error", errName, msg, ctx);
        throw new PeazeException(msg);
    }

    private static void syntaxError(String errName, String msg, ParserRuleContext ctx) {
        PeazeError.error("Syntax Error", errName, msg, ctx);
        throw new PeazeException(msg);
    }

    private static void error(String kind, String errName, String msg, ParserRuleContext ctx) {
        String pos = Utils.getPosString(ctx);
        String sourceCode = Utils.getOriginalText(ctx);
        msg = String.format("%s in %s: %s: %s:\n%s\n",
                kind, pos, errName, msg, sourceCode);
        throw new PeazeException(msg);
    }
}

/**
 * The type Peaze exception.
 */
class PeazeException extends RuntimeException {
    /**
     * Instantiates a new Peaze exception.
     */
    public PeazeException() {
        super();
    }

    /**
     * Instantiates a new Peaze exception.
     *
     * @param message the message
     */
    public PeazeException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Peaze exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public PeazeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Peaze exception.
     *
     * @param cause the cause
     */
    public PeazeException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Peaze exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected PeazeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}