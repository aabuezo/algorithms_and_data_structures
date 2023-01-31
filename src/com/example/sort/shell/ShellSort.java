package com.example.sort.shell;

import com.example.sort.insertion.InsertionSort;

public class ShellSort {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        int[] array1 = {20, 35, -15, 7, 55, 1, -22};
        print(array1);
        shellSort(array1);
        print(array1);

        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
        print(array2);
        shellSort(array2);
        print(array2);
        long end = System.currentTimeMillis();

        System.out.printf("Time elapsed: %d ms.\n", end - init);
    }

    static void shellSort(int[] array) {

        // Shell sort is similar to Insertion sort but uses a gap to
        // do some preorder
        int gap = array.length / 2;
        while (gap > 0)  {

            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];

                int j = i;

                // When gap == 1 it is similar to Insertion sort
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = newElement;
            }

            // Shorten the gap up to one
            gap /= 2;
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
