package com.pzque.continuation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


public class Factorial {
    public static Continuation<BigInteger> gCont;

    public static Continuation<BigInteger> factorial(final int n, final BigInteger sum) {
        if (n <= 1) {
            return new Done<>(sum);
        } else {
            return new More<BigInteger>(() -> factorial(n - 1, sum.multiply(BigInteger.valueOf(n))));
        }
    }

    public static void main(String[] args) {
        Continuation<BigInteger> result = factorial(1000000, BigInteger.ONE);
        result.execute();

        Continuation<Integer> cont = new Done<>(1);
        Function<Integer, Continuation<Integer>> f = x -> new Done<>((Integer) x);

        for (int i = 0; i < 100000000; i++) {
            int j = i;
            cont = new More<>(() -> f.apply(j));
        }

        cont.execute();
    }

}