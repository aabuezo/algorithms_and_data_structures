package com.example.divideandconquer;

public class MergeSort {
    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};
        print("array: ", array);
        mergeSort(array, 0, array.length);
        print("array: ", array);

        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
        print("array2: ", array2);
        mergeSort(array2, 0, array2.length);
        print("array2: ", array2);
    }

    static void mergeSort(int[] array, int begin, int end) {

        // base case when array.length == 1
        if (end - begin < 2) {
            return;
        }

        // make partition
        int mid = (begin + end) / 2;
        mergeSort(array, begin, mid);
        mergeSort(array, mid, end);
        merge(array, begin, mid, end);
    }

    static void merge(int[] array, int begin, int mid, int end) {

        // left is ordered, right is ordered so if the rightmost element in the left partition
        // is lower than the leftmost element in the right partition, we must do nothing
        if (array[mid - 1] == array[mid]) {
            return;
        }

        int i = begin;
        int j = mid;
        int idx = 0;

        int[] temp = new int[end - begin];
        while (i < mid && j < end) {
            // copy left and right into temp in order
            temp[idx++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        // copy remaining elements into temp
        System.arraycopy(array, i, array, begin + idx, mid - i);
        System.arraycopy(temp, 0, array, begin, idx);
    }

    static void print(String lr, int[] array) {
        System.out.printf("%s[]: [", lr);
        for (int elem: array) {
            System.out.printf("%d, ", elem);
        }
        System.out.println("]");
    }
}
