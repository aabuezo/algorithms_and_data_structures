package com.example.arrays.myimpl.mythreadsafe;

import com.example.arrays.myimpl.interfaces.IMyStackArray;
import com.example.arrays.myimpl.myarray.MyArray;

public class MyThreadSafeStackArray<T> implements IMyStackArray<T> {

    private MyArray<T> array;
    MyThreadSafeStackArray() {
        this.array = new MyArray<>();
    }

    MyThreadSafeStackArray(int capacity) {
        this.array = new MyArray<>(capacity);
    }

    @Override
    public synchronized void push(T value) {
        array.push(value);
        notifyAll();
    }

    @Override
    public synchronized T pop() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return array.pop();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int lenght() {
        return array.length();
    }
}
