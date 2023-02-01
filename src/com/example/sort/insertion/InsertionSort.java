package com.example.sort.insertion;

/*
 * Alejandro
 * 01/29/2023
 * Insertion sort: O(n²)
 * In-place algorithm
 * Stable algorithm
 */
public class InsertionSort {

    public static void main(String[] args) {

        long init = System.currentTimeMillis();

        int[] array = {20, 35, -15, 7, 55, 1, -22};
        print(array);
        insertionSort1(array);
        print(array);

        int[] array0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
        print(array0);
        insertionSort1(array0);
        print(array0);

        int[] array1 = {20, 35, -15, 7, 55, 1, -22};
        print(array1);
        insertionSort2(array1);
        print(array1);

        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
        print(array2);
        insertionSort2(array2);
        print(array2);

        int[] array3 = {20, 35, -15, 7, 55, 1, -22};
        print(array3);
        insertionSortRecursive(array3, 1);
        print(array3);

        int[] array4 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -10, -20, -30, -40, -50};
        print(array4);
        insertionSortRecursive(array4, 1);
        print(array4);

        long end = System.currentTimeMillis();
        System.out.printf("Time elapsed: %d ms.\n", end - init);
    }

    public static void insertionSort1(int[] array) {

        // Sorted partition is on the left (first element already ordered)
        // so we traverse from index 1 to the end
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            // we compare the first element in the unsorted partition
            // with each of the elements in the sorted partition from right to left
            for (int sortedIdx = firstUnsortedIndex - 1; sortedIdx >= 0; sortedIdx--) {
                if (array[sortedIdx] >= newElement) {
                    // copy previous element to the right
                    array[sortedIdx + 1] = array[sortedIdx];
                    if (sortedIdx == 0) {
                        // lowest element
                        array[sortedIdx] = newElement;
                    }
                } else {
                    // insert element
                    array[sortedIdx + 1] = newElement;
                    break;
                }
            }
        }
    }

    public static void insertionSort2(int[] array) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];

            int i;
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
    }

    public static void insertionSortRecursive(int[] array, int firstUnsortedIndex) {

        if (firstUnsortedIndex > array.length - 1) {    // breaking condition
            return;
        }

        int newElement = array[firstUnsortedIndex];
        int i;
        for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
            array[i] = array[i - 1];
        }
        array[i] = newElement;

        insertionSortRecursive(array, firstUnsortedIndex + 1);
    }

    static void print(int[] array) {
        System.out.print("array[]: [");
        for (int elem: array) {
            System.out.printf("%d, ", elem);
        }
        System.out.println("]");
    }
}
