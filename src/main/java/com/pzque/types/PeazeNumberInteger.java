package com.pzque.types;

public class PeazeNumberInteger extends PeazeNumber {
    private Integer value;

    public PeazeNumberInteger(int value) {
        this.value = value;
    }

    @Override
    public String getTypeString() {
        return "integer";
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer asJavaInt() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    void setNegative() {
        this.value = -this.value;
    }

    @Override
    PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    // integer + integer
    @Override
    PeazeNumber acceptAdd(PeazeNumberInteger lhs) {
        return new PeazeNumberInteger(lhs.value + this.value);
    }

    // rational + integer
    @Override
    PeazeNumber acceptAdd(PeazeNumberRational lhs) {
        return lhs.acceptAdd(this);
    }

    // real + integer
    @Override
    PeazeNumber acceptAdd(PeazeNumberReal lhs) {
        return lhs.acceptAdd(this);
    }

    @Override
    PeazeNumber sub(PeazeNumber rhs) {
        return rhs.acceptSub(this);
    }

    // integer - integer
    @Override
    PeazeNumber acceptSub(PeazeNumberInteger lhs) {
        return new PeazeNumberInteger(lhs.value - this.value);
    }

    // rational + integer
    @Override
    PeazeNumber acceptSub(PeazeNumberRational lhs) {
        return lhs.acceptSub(this);
    }

    // real + integer
    @Override
    PeazeNumber acceptSub(PeazeNumberReal lhs) {
        return lhs.acceptSub(this);
    }
}
