package com.pzque.core;

public class Rational {
    private int intpart;
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        int gcd = Rational.gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;

        this.intpart = this.numerator / denominator;
        this.numerator = this.numerator % denominator;
    }

    public Rational add(Rational rhs) {
        int nume = this.numerator * rhs.denominator + rhs.numerator * this.denominator;
        int deno = this.denominator * rhs.denominator;
        return new Rational(nume, deno);
    }

    public Rational sub(Rational rhs) {
        int nume = this.numerator * rhs.denominator - rhs.numerator * this.denominator;
        int deno = this.denominator * rhs.denominator;
        return new Rational(nume, deno);
    }

    public Rational mul(Rational rhs) {
        int nume = this.numerator * rhs.denominator * rhs.numerator * this.denominator;
        int deno = this.denominator * rhs.denominator;
        return new Rational(nume, deno);
    }

    public Rational div(Rational rhs) {
        int nume = this.numerator * rhs.denominator / rhs.numerator * this.denominator;
        int deno = this.denominator * rhs.denominator;
        return new Rational(nume, deno);
    }


    int toInt() {
        return numerator / denominator;
    }

    double toDouble() {
        return numerator / (double) denominator;
    }

    @Override
    public String toString() {
        if (this.intpart == 0) {
            return String.format("%s/%s", this.numerator, this.denominator);
        }
        return String.format("%s+%s/%s", this.intpart, this.numerator, this.denominator);
    }

    // greatest common divisor;
    public static int gcd(int a, int b) {
        int remainder;

        do {
            remainder = a % b;
            a = b;
            b = remainder;
        } while (remainder != 0);

        return a;
    }

    // least common multiple
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
