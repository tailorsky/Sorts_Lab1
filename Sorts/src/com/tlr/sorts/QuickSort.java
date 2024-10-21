package com.tlr.sorts;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {  
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int elements : arr)
        {
            System.out.print(elements + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {1, 45, 5, 6, 7 ,8};
        System.out.println("Unsorted array: ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
