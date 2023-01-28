package com.example.arrays.myimpl.interfaces;

public interface IMyArray<T> {
    void add(int index, T value);
    T get(int index);
    int firstIndexOf(T value);
    boolean isEmpty();
    void copy(T[] array);
    int capacity();
    int length();
}
