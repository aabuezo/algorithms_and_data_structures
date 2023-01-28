package com.example.arrays.myimpl.interfaces;

public interface IMyArray<T> {
    void add(int index, T value);
    T get(int index);
    int indexOf(T value);
    boolean isEmpty();
    int capacity();
    int length();
}
