package com.pzque.continuation;

import java.util.function.Function;

public abstract class Continuation<T> {

    abstract boolean isDone();

    public T get() {
        return null;
    }

    public Continuation<? extends Object> run() {
        return null;
    }

    public T execute() {
        Continuation<? extends Object> continuation = this;

        while (!continuation.isDone()) {
            continuation = continuation.run();
        }

        return (T) continuation.get();
    }

    public <R> Continuation<R> then(Function<Object, Continuation<R>> function) {
        return new More<R>(this, function);
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
    private Function<Object, Continuation<R>> function;
    private Continuation<? extends Object> parent;

    public More(Continuation<? extends Object> parent) {
        this.parent = parent;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Continuation<R> run() {
        return parent;
    }
}