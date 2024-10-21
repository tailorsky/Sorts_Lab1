package com.tlr.sorts;

public class SelectionSort {

    public static void swap (int[] arr, int indx1, int indx2){
        int tmp;
        tmp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = tmp;
    }

    public static int[] sel_sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            int min_index = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            if (min_index!= i) swap(arr, i, min_index);
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = new int[] {9, 3, 2, 2, 6, 2};
        sel_sort(arr);
        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
