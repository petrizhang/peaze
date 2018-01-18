package com.pzque.types;

public class PeazeNumberReal extends PeazeNumber {

    private double value;

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
    public String getTypeString() {
        return "real";
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
    public void setNegative() {
        this.value = -this.value;
    }

    @Override
    public PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    @Override
    public PeazeNumber acceptAdd(PeazeNumberInteger lhs) {
        return new PeazeNumberReal(lhs.getValue() + this.value);
    }

    @Override
    public PeazeNumber acceptAdd(PeazeNumberRational lhs) {
        return new PeazeNumberReal(lhs.asJavaDouble() + this.value);
    }

    @Override
    public PeazeNumber acceptAdd(PeazeNumberReal lhs) {
        return new PeazeNumberReal(lhs.value + this.value);
    }

    @Override
    public PeazeNumber sub(PeazeNumber rhs) {
        return rhs.acceptSub(this);
    }

    @Override
    public PeazeNumber acceptSub(PeazeNumberInteger lhs) {
        return new PeazeNumberReal(lhs.getValue() - this.value);
    }

    @Override
    public PeazeNumber acceptSub(PeazeNumberRational lhs) {
        return new PeazeNumberReal(lhs.asJavaDouble() - this.value);
    }

    @Override
    public PeazeNumber acceptSub(PeazeNumberReal lhs) {
        return new PeazeNumberReal(lhs.value - this.value);
    }
}
