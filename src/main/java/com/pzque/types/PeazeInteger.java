package com.pzque.types;

public class PeazeInteger extends PeazeNumber {
    private Integer value;

    public PeazeInteger(int value) {
        this.value = value;
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
    PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    // integer + integer
    @Override
    PeazeNumber acceptAdd(PeazeInteger lhs) {
        return new PeazeInteger(lhs.value + this.value);
    }

    // rational + integer
    @Override
    PeazeNumber acceptAdd(PeazeRational lhs) {
        return lhs.acceptAdd(this);
    }

    // real + integer
    @Override
    PeazeNumber acceptAdd(PeazeReal lhs) {
        return lhs.acceptAdd(this);
    }
}
