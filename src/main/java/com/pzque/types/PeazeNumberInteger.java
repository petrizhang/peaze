package com.pzque.types;

public class PeazeNumberInteger extends PeazeNumber {
    private Integer value;

    public PeazeNumberInteger(int value) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }

    @Override
    public String getTypeString() {
        return "integer";
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
    public Double asJavaDouble() {
        return (double) this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public void setNegative() {
        this.value = -this.value;
    }

    @Override
    public PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    // integer + integer
    @Override
    public PeazeNumber acceptAdd(PeazeNumberInteger lhs) {
        return new PeazeNumberInteger(lhs.value + this.value);
    }

    // rational + integer
    @Override
    public PeazeNumber acceptAdd(PeazeNumberRational lhs) {
        return lhs.acceptAdd(this);
    }

    // real + integer
    @Override
    public PeazeNumber acceptAdd(PeazeNumberReal lhs) {
        return lhs.acceptAdd(this);
    }

    @Override
    public PeazeNumber sub(PeazeNumber rhs) {
        return rhs.acceptSub(this);
    }

    // integer - integer
    @Override
    public PeazeNumber acceptSub(PeazeNumberInteger lhs) {
        return new PeazeNumberInteger(lhs.value - this.value);
    }

    // rational + integer
    @Override
    public PeazeNumber acceptSub(PeazeNumberRational lhs) {
        return lhs.acceptSub(this);
    }

    // real + integer
    @Override
    public PeazeNumber acceptSub(PeazeNumberReal lhs) {
        return lhs.acceptSub(this);
    }
}
