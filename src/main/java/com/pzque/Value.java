package com.pzque;

enum Type {
    BOOLEAN,
    CHAR,
    INTEGER,
    FLOAT,
    DOUBLE,
    STRING
}

class Value {
    Object value = null;

    static final Value NULL = new Value();
}
