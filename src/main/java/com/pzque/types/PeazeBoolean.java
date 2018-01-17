package com.pzque.types;

import com.pzque.core.PeazeObject;

public class PeazeBoolean extends PeazeObject {
    private Boolean value;

    @Override
    public String getTypeString() {
        return "boolean";
    }

    private PeazeBoolean(boolean value) {
        this.value = value;
    }

    private static final PeazeBoolean True = new PeazeBoolean(true);
    private static final PeazeBoolean False = new PeazeBoolean(false);

    public static PeazeBoolean fromString(String s) {
        return s.equals("#t") ? True : False;
    }

    public static PeazeBoolean getTrue() {
        return True;
    }

    public static PeazeBoolean getFalse() {
        return False;
    }

    @Override
    public boolean isBoolean() {
        return true;
    }

    @Override
    public Boolean asJavaBoolean() {
        return this.value;
    }
}
