package com.example.arrays.myimpl.interfaces;

public interface IMyStackArray<T> {
    void push(T value);
    T pop();
    boolean isEmpty();
}
