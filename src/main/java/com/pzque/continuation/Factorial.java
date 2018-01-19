package com.pzque.continuation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


public class Factorial {
//    public static Continuation<BigInteger> factorial(final int n, final BigInteger sum) {
//        if (n <= 1) {
//            return new Done<>(sum);
//        } else {
//            return new More<BigInteger>(() -> factorial(n - 1, sum.multiply(BigInteger.valueOf(n))));
//        }
//    }

    public static void main(String[] args) {
//        Continuation<BigInteger> result = factorial(5, BigInteger.ONE).then(
//                x -> {
//                    System.out.println(x);
//                    return new Done<>(null);
//                }
//        ).then(x -> new Done<>(null));
//        result.execute();

        Continuation<Integer> cont = new Done<>(1);
        Function<Object, Continuation<Integer>> f = x -> new Done<>((Integer) x);

        for (int i = 0; i < 1000000; i++) {
            cont = cont.then(f);
        }

        cont.execute();
    }

}