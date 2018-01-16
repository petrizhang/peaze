package com.pzque.core;

public enum PeazeType {
    BOOLEAN,
    CHARACTER,
    INTEGER,
    FLOAT,
    DOUBLE,
    STRING,
    LIST,
    BUILTIN_OP,
    PROCEDURE,
    NULL,
    UNDEFINED;

    public boolean isApplicable(){
        return this == PeazeType.BUILTIN_OP
                || this == PeazeType.PROCEDURE;
    }
}