package com.example.sort.selection;

/*
 * Alejandro
 * 01/29/2023
 * Selection sort: O(n²)
 * In-place algorithm
 * Unstable algorithm
 */
public class SelectionSort {

    public static void main(String[] args) {

        long init = System.currentTimeMillis();
        int[] array1 = {20, 35, -15, 7, 55, 1, -22};
        print(array1);
        selectionSort(array1);
        print(array1);

        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
        print(array2);
        selectionSort(array2);
        print(array2);
        long end = System.currentTimeMillis();

        System.out.printf("Time elapsed: %d ms.\n", end - init);
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectionSort(int[] array) {

        // at first, the whole array is de unsorted partition
        for (int idxUnsorted = array.length - 1; idxUnsorted > 0; idxUnsorted--) {
            int maxIndex = 0;
            // the highest value is pushed to the right
            // and that becomes the sorted partition
            for (int i = 1; i <= idxUnsorted; i++) {
                // this is an unstable algorithm
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            // now we can swap values
            swap(array, maxIndex, idxUnsorted);
            // now we can decrement the index of the unsorted partition
            // in the next iteration
        }
    }

    static void print(int[] array) {
        System.out.print("array[]: [");
        for (int elem: array) {
            System.out.printf("%d, ", elem);
        }
        System.out.println("]");
    }
}
