package com.example.arrays;

public class Arrays {
    public static void main(String[] args) {

        int[] intArray = new int[10];

        intArray[0] = 32;
        intArray[1] = -32;
        intArray[2] = 0;
        intArray[3] = 1508;
        intArray[4] = 311;
        intArray[5] = 311;
        intArray[6] = 2188;
        intArray[7] = -147;
        intArray[8] = -2;
        intArray[9] = 6323;


        // if we know the index, time complexity is constant O(1)
        System.out.println(intArray[8]);


        // to find an element we must go through each element in the array
        // if we don't know the index, time complexity is linear O(n)
        int index = -1;
        int number = 3110;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == number) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.printf("Number %d is not in the array.\n", number);
        } else {
            System.out.printf("Number %d is at array index: %d", number, index);
        }
    }
}