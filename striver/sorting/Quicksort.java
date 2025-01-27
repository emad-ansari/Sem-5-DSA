package striver.sorting;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        quickSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort (int[] arr , int low, int high) {
        if (low < high ) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    static int partition(int[] arr, int low, int high) {
        // your code here
        int pivot = arr[high]; // Pivot is the last element
        int i = low - 1; // `i` starts before the first element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // Move `i` forward
                swap(arr, i, j); // Swap smaller element to the correct position
            }
        }

        // Place the pivot in its correct position
        swap(arr, i + 1, high);

        return i + 1; // Return the pivot's position
    }
    static void swap (int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
