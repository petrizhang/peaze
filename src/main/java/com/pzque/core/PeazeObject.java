package com.pzque.core;

import com.pzque.util.Utils;

public abstract class PeazeObject {
    public PeazeObject() {
    }

    public abstract String getTypeString();

    public boolean isUnSpecified() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isApplicable() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isInteger() {
        return false;
    }

    public boolean isDouble() {
        return false;
    }

    public boolean isProcedure() {
        return false;
    }

    public boolean isBuiltin() {
        return false;
    }

    public Boolean asJavaBoolean() {
        throw Utils.WrongBranch;
    }

    public Double asJavaDouble() {
        throw Utils.WrongBranch;
    }

    public Integer asJavaInt() {
        throw Utils.WrongBranch;
    }
}