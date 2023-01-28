package com.example.arrays.myimpl.mysynchronized;

import com.example.arrays.myimpl.interfaces.IMyStackArray;
import com.example.arrays.myimpl.myarray.MyArray;

public class MySynchronizedArray<T> implements IMyStackArray<T> {

    private MyArray<T> array;
    MySynchronizedArray() {
        this.array = new MyArray<>();
    }

    MySynchronizedArray(int capacity) {
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
