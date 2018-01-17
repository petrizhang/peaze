package com.pzque.types;

import com.pzque.core.PeazeObject;

abstract public class PeazeNumber extends PeazeObject {
    @Override
    public boolean isNumber() {
        return true;
    }

    abstract PeazeNumber add(PeazeNumber rhs);

    abstract PeazeNumber acceptAdd(PeazeInteger lhs);

    abstract PeazeNumber acceptAdd(PeazeRational lhs);

    abstract PeazeNumber acceptAdd(PeazeReal lhs);
}
