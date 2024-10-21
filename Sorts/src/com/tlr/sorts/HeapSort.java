package com.tlr.sorts;

public class HeapSort {

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;

        int l_child = 2 * i + 1;

        int r_child = 2 * i + 2;

        if (l_child < n && arr[l_child] > arr[largest]) {
            largest = l_child;
        }
        if (r_child < n && arr[r_child] > arr[largest]) {
            largest = r_child;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void print(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
    }
}
