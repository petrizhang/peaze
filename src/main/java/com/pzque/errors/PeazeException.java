package com.pzque.errors;

public class PeazeException extends RuntimeException {
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
