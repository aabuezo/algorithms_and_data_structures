package com.example.arrays.myimpl.myarray;

import com.example.arrays.myimpl.interfaces.IMyArray;
import com.example.arrays.myimpl.interfaces.IMyStackArray;

public class MyArray<T> implements IMyArray<T>, IMyStackArray<T> {

    T[] array;                 // array of Ts

    private int capacity = 2;  // array capacity - should always be >= length - set to 2 for testing purposes

    private int length = 0;     // represents next index and also how many elements are there in the array

    public MyArray() {          // Default constructor
        this.array = createArray(this.capacity);
    }

    public MyArray(int capacity) {      // One param constructor
        this.array = createArray(capacity);
    }

    public MyArray(T[] array) {         // Copy constructor
        this.array = array;
        this.length = this.capacity = array.length;
    }

    private T[] createArray(int capacity) {     // for internal use only
        this.capacity = capacity;
        return (T[]) new Object[capacity];
    }

    private void extendCapacity() {             // for internal use only
        if (this.array == null) {
            return;
        }
        T[] origin = this.array;
        // creates a new array with double capacity
        this.capacity *= 2;
        T[] dest = createArray(this.capacity);
        // copy origin to dest
        int i = 0;
        while (i < origin.length) {
            dest[i] = origin[i];
            i++;
        }
        // move reference
        this.array = dest;
        // set new length
        this.length = i;
        System.out.println("Array capacity extended to: " + this.capacity);
        System.out.println("New length: " + this.length);
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    // Returns the length
    @Override
    public int length() {
        return this.length;
    }

    @Override
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        } else {
            return this.array[index];
        }
    }

    // returns the index of the first ocurrence of value in array,
    // returns -1 if value is not present
    @Override
    public int indexOf(T value) {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int index, T value) {
        if (this.length == this.capacity) {
            extendCapacity();
        }
        if (index >= 0 || index < this.length) {
            this.array[index] = value;
            if (index == this.length) {
                    this.length++;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.length == 0);
    }

    @Override
    public void push(T value) {
        if (this.length == this.capacity) {
            extendCapacity();
        }
        this.array[this.length++] = value;
    }

    @Override
    public T pop() {
        if (this.length > 0) {
            this.length--;
            return this.array[length];
        }
        return null;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.length; i++) {
            sb.append(this.array[i]);
            if (i <= this.length-2) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
