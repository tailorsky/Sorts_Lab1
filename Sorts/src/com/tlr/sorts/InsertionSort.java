package com.tlr.sorts;
public class InsertionSort {

    public static int[] insert_sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    public static void main(String[] args){
        int arr[] = new int[] {1, 8, 3, 6, 7, 0};
        arr = insert_sort(arr);
        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
