package com.example.arrays.myimpl.myarray;

import com.example.arrays.myimpl.interfaces.IMyArray;
import com.example.arrays.myimpl.interfaces.IMyStackArray;

public class MyArrayTest {
    public static void main(String[] args) {

        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        IMyArray<Integer> myNumbers = new MyArray<>(numbers);
        System.out.println("myNumbers.isEmpty(): " + myNumbers.isEmpty());
        System.out.println("myNumbers.capacity(): " + myNumbers.capacity());
        System.out.println("myNumbers.length(): " + myNumbers.length());
        System.out.println("myNumbers.indexOf(10): " + myNumbers.indexOf(10));
        System.out.println(myNumbers);
        myNumbers.add(15, 16);
        System.out.println("myNumbers.capacity(): " + myNumbers.capacity());
        System.out.println("myNumbers.length(): " + myNumbers.length());
        System.out.println();

        IMyArray<Integer> array = new MyArray<>();
        System.out.println("array.capacity(): " + array.capacity());
        System.out.println("array.isEmpty(): " + array.isEmpty());
        array.add(0, 1);
        array.add(1, 2);
        array.add(2, 3);
        System.out.println("array[]: " + array);
        System.out.println("array.get(2): " + array.get(2));
        try {
            System.out.println("array.get(3): " + array.get(3));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds.");
        }
        System.out.println();

        IMyStackArray<String> myStack = new MyArray<>(3);
        // capacity() is not part of IMyStackArray interface
//        System.out.println("myStack capacity: " + myStack.capacity());
        System.out.println("myStack.isEmpty(): " + myStack.isEmpty());
        myStack.push("Juan");
        myStack.push("Pedro");
        myStack.push("Camila");
        myStack.push("Vanesa");
        myStack.push("Sandra");
        myStack.push("Joaquin");
        myStack.push("Pepe");
        System.out.println("myStack[]: " + myStack);
        myStack.pop();
        myStack.pop();
        System.out.println("myStack[]: " + myStack);

    }
}
