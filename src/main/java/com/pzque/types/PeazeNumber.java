package com.pzque.types;

import com.pzque.core.PeazeObject;

abstract public class PeazeNumber extends PeazeObject {
    @Override
    public boolean isNumber() {
        return true;
    }

    abstract void setNegative();

    abstract PeazeNumber add(PeazeNumber rhs);

    abstract PeazeNumber acceptAdd(PeazeNumberInteger lhs);

    abstract PeazeNumber acceptAdd(PeazeNumberRational lhs);

    abstract PeazeNumber acceptAdd(PeazeNumberReal lhs);

    abstract PeazeNumber sub(PeazeNumber rhs);

    abstract PeazeNumber acceptSub(PeazeNumberInteger lhs);

    abstract PeazeNumber acceptSub(PeazeNumberRational lhs);

    abstract PeazeNumber acceptSub(PeazeNumberReal lhs);
}
