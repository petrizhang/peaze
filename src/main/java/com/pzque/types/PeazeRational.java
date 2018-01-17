package com.pzque.types;

import com.pzque.Utils;

public class PeazeRational extends PeazeNumber {
    private int intpart;
    private int numerator;
    private int denominator;

    public int getIntpart() {
        return intpart;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public PeazeRational(int intpart, int numerator, int denominator) {
        this.intpart = intpart;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public PeazeRational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        int gcd = Utils.gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        this.intpart = this.numerator / denominator;
        this.numerator = this.numerator % denominator;
    }

    @Override
    PeazeNumber add(PeazeNumber rhs) {
        return rhs.acceptAdd(this);
    }

    @Override
    PeazeNumber acceptAdd(PeazeInteger lhs) {
        return new PeazeRational(lhs.getValue() + this.intpart, this.numerator, this.denominator);
    }

    @Override
    PeazeNumber acceptAdd(PeazeRational lhs) {
        int nume = lhs.denominator * this.numerator + this.denominator * lhs.numerator;
        int deno = lhs.denominator * this.denominator;
        return new PeazeRational(nume, deno);
    }

    @Override
    PeazeNumber acceptAdd(PeazeReal lhs) {
        return lhs.acceptAdd(this);
    }

//
//    @Override
//    public PeazeRational sub(PeazeRational rhs) {
//        int nume = this.numerator * rhs.denominator - rhs.numerator * this.denominator;
//        int deno = this.denominator * rhs.denominator;
//        return new PeazeRational(nume, deno);
//    }
//
//    @Override
//    public PeazeRational mul(PeazeRational rhs) {
//        int nume = this.numerator * rhs.denominator * rhs.numerator * this.denominator;
//        int deno = this.denominator * rhs.denominator;
//        return new PeazeRational(nume, deno);
//    }
//
//    @Override
//    public PeazeRational div(PeazeRational rhs) {
//        int nume = this.numerator * rhs.denominator / rhs.numerator * this.denominator;
//        int deno = this.denominator * rhs.denominator;
//        return new PeazeRational(nume, deno);
//    }
//

    @Override
    public Double asJavaDouble() {
        return this.intpart + this.numerator / (double) this.denominator;
    }

    @Override
    public Integer asJavaInt() {
        return this.intpart + this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        if (this.intpart == 0) {
            return String.format("%s/%s", this.numerator, this.denominator);
        }
        return String.format("%s+%s/%s", this.intpart, this.numerator, this.denominator);
    }

}
