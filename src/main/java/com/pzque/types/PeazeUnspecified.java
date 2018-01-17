package com.pzque.types;

import com.pzque.core.PeazeObject;

public class PeazeUnspecified extends PeazeObject {
    @Override
    public boolean isUnSpecified() {
        return true;
    }

    private PeazeUnspecified() {
    }

    private static final PeazeUnspecified unspecified = new PeazeUnspecified();

    //静态工厂方法
    public static PeazeUnspecified getInstance() {
        return unspecified;
    }
}
