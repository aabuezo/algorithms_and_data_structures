package com.example.divideandconquer;

public class QuickSort  {
    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};
//        print("array", array, 0, array.length);
        quickSort(array, 0, array.length);
        print("(sorted) array", array, 0, array.length);
        System.out.println();

        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
//        print("array2", array2, 0, array2.length);
        quickSort(array2, 0, array2.length);
        print("(sorted) array2", array2, 0, array2.length);
    }

    private static void quickSort(int[] inputArray, int begin, int end) {

        if (end <= begin) {  // one element array
            return;
        }
        int i = begin;
        int j = end;
        int pivot = inputArray[begin];

        // for debugging purpose
        System.out.printf("begin: %d, end: %d\n", begin, end);
        System.out.println("pivot: " + pivot);
        print("inputArray", inputArray, begin, end);
        System.out.println();

        while (i < j) {
            // do nothing till it finds a lower value
            while (j > i && inputArray[--j] > pivot);
            // move left
            inputArray[i] = inputArray[j];

            // do nothing till it finds a greater value
            while (i < j && inputArray[++i] < pivot);
            // move right
            inputArray[j] = inputArray[i];
        }
        inputArray[i] = pivot;
        quickSort(inputArray, begin, i);     // left inputArray
        quickSort(inputArray, i + 1, end);      // right inputArray
    }

    static void print(String lr, int[] array, int begin, int end) {
        System.out.printf("%s[]: [", lr);
        for (int i = begin; i < end; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.println("]");
    }
}
