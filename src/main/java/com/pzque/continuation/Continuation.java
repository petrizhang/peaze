package com.pzque.continuation;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Continuation<T> {

    abstract boolean isDone();

    public T get() {
        return null;
    }

    public Continuation<T> run() {
        return null;
    }

    public T execute() {
        Continuation<? extends Object> continuation = this;

        while (!continuation.isDone()) {
            continuation = continuation.run();
        }

        return (T) continuation.get();
    }

    public <R> Continuation<R> then(Supplier<Continuation<R>> function) {
        return new More<R>(function);
    }

}


class Done<T> extends Continuation<T> {
    private T value;

    public Done(T value) {
        this.value = value;
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public T get() {
        return this.value;
    }
}


class More<R> extends Continuation<R> {
    private Supplier<Continuation<R>> function;

    public More(Supplier<Continuation<R>> function) {
        this.function = function;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Continuation<R> run() {
        return function.get();
    }
}

//class FlatMap<T, R> extends Continuation<R> {
//    Continuation<T> parent;
//    Function<T, Continuation<R>> next;
//
//    @Override
//    public Continuation<R> run() {
//
//    }
//
//    FlatMap(Continuation<T> parent, Function<T, Continuation<R>> next) {
//        this.parent = parent;
//        this.next = next;
//    }
//
//    @Override
//    boolean isDone() {
//        return false;
//    }
//

//}