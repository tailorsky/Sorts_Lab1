package com.tlr.sorts;

import java.util.Random;

public class CheckSorts {
    public static int[] generateRandomArray(int size) {
            Random random = new Random();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(10000);
            }
        return array;
    }

    public static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            if (arr[i] > arr[i+1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10000);
        int[] gaps = ShellSort.getGapsHibbard(arr);
        //QuickSort.quickSort(arr, 0, arr.length-1);
        ShellSort.shellsort(arr, gaps);

        if(isSorted(arr))
            ShellSort.printArray(arr);
    }

}
