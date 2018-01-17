package com.pzque.types;

public class PeazeNumberReal extends PeazeNumber {

    private double value;

    @Override
    public String getTypeString() {
        return "real";
    }

    public double getValue() {
        return value;
    }

    public PeazeNumberReal(double value) {
        this.value = value;
    }

    public static PeazeNumberReal fromString(String s) {
        double value = Double.parseDouble(s);
        return new PeazeNumberReal(value);
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public Double asJavaDouble() {
        return value;
    }

    @Override
    void setNegative() {
        this.value = -this.value;
    }

    @Override
    PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    @Override
    PeazeNumber acceptAdd(PeazeNumberInteger lhs) {
        return new PeazeNumberReal(lhs.getValue() + this.value);
    }

    @Override
    PeazeNumber acceptAdd(PeazeNumberRational lhs) {
        return new PeazeNumberReal(lhs.asJavaDouble() + this.value);
    }

    @Override
    PeazeNumber acceptAdd(PeazeNumberReal lhs) {
        return new PeazeNumberReal(lhs.value + this.value);
    }

    @Override
    PeazeNumber sub(PeazeNumber rhs) {
        return rhs.acceptSub(this);
    }

    @Override
    PeazeNumber acceptSub(PeazeNumberInteger lhs) {
        return new PeazeNumberReal(lhs.getValue() - this.value);
    }

    @Override
    PeazeNumber acceptSub(PeazeNumberRational lhs) {
        return new PeazeNumberReal(lhs.asJavaDouble() - this.value);
    }

    @Override
    PeazeNumber acceptSub(PeazeNumberReal lhs) {
        return new PeazeNumberReal(lhs.value - this.value);
    }
}
