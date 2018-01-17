package com.pzque.types;

import com.pzque.core.PeazeObject;

public class PeazeVoid extends PeazeObject {
    @Override
    public String getTypeString() {
        return "void";
    }

    @Override
    public boolean isUnSpecified() {
        return true;
    }

    private PeazeVoid() {
    }

    private static final PeazeVoid void_ = new PeazeVoid();

    //静态工厂方法
    public static PeazeVoid getInstance() {
        return void_;
    }
}
