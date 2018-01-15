package com.pzque;

enum PeazeType {
    BOOLEAN,
    CHARACTER,
    INTEGER,
    FLOAT,
    DOUBLE,
    STRING,
    LIST,
    BUILTIN_OP,
    FUNCTION,
    NULL,
    UNDEFINED;

    boolean isApplicable(){
        return this == PeazeType.BUILTIN_OP
                || this == PeazeType.FUNCTION;
    }
}