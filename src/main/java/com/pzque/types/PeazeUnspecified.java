package com.pzque.types;

import com.pzque.core.PeazeObject;

public class PeazeUnspecified extends PeazeObject {
    @Override
    public String getTypeString() {
        return "void";
    }

    @Override
    public boolean isUnSpecified() {
        return true;
    }

    private PeazeUnspecified() {
    }

    private static final PeazeUnspecified UNSPECIFIED = new PeazeUnspecified();

    public static PeazeUnspecified getInstance() {
        return UNSPECIFIED;
    }
}
