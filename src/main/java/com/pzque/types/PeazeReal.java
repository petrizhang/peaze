package com.pzque.types;

public class PeazeReal extends PeazeNumber {

    private double value;

    public double getValue() {
        return value;
    }

    public PeazeReal(double value) {
        this.value = value;
    }

    public static PeazeReal fromString(String s) {
        double value = Double.parseDouble(s);
        return new PeazeReal(value);
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
    PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    @Override
    PeazeNumber acceptAdd(PeazeInteger lhs) {
        return new PeazeReal(lhs.getValue() + this.value);
    }

    @Override
    PeazeNumber acceptAdd(PeazeRational lhs) {
        return new PeazeReal(lhs.asJavaDouble() + this.value);
    }

    @Override
    PeazeNumber acceptAdd(PeazeReal lhs) {
        return new PeazeReal(lhs.value + this.value);
    }
}
