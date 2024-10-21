package com.tlr.sorts;
import java.util.Random;

public class BogoSort {
    public static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++){
            int randInt = rand.nextInt(arr.length);
            int tmp = arr[i];
            arr[i] = arr[randInt];
            arr[randInt] = tmp;
        }
    }

    public static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            if (arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    public static void bogo_sort(int[] arr){
        while(!isSorted(arr)){
            shuffle(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main (String[] args){
        int[] arr = new int[] {1, 2, 65, 6, -3, 4, 74, 34, 67, 8};
        bogo_sort(arr);
        printArray(arr);
    }
}
