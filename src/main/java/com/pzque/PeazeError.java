package com.pzque;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class PeazeError {

    public static void notApplicable(ParserRuleContext ctx) {
        Token start = ctx.getStart();
        Token end = ctx.getStop();

        String pos = Utils.getPosString(ctx);

        String msg = String.format("Runtime error in %s: '%s' is not applicable.",
                pos, ctx.getText());

        throw new PeazeException(msg);
    }
}

class PeazeException extends RuntimeException {
    public PeazeException() {
        super();
    }

    public PeazeException(String message) {
        super(message);
    }

    public PeazeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PeazeException(Throwable cause) {
        super(cause);
    }

    protected PeazeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}