package com.tlr.sorts;

import java.util.ArrayList;
import java.util.Collections;

public class ShellSort {
    public static int[] shellsort(int[] arr, int[] gaps) {
        for (int gap : gaps) {
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > key) {
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = key;
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] getGapsShell(int[] gaps) {
        int n = gaps.length;
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = n / 2; i > 0; i /= 2) {
            newArray.add(i);
        }
        Integer[] tempArr = newArray.toArray(new Integer[0]);

        int[] arr = new int[tempArr.length];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i];
        }
        return arr;
    }

    public static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
    

    public static int[] getGapsHibbard(int[] arr) {
        int n = arr.length;
        int length = 0;

        for (int i = 1; Math.pow(2, i) - 1 < n; i++) {
            length++;
        }
        int[] newArr = new int[length];
 
        for (int i = 0; i < length; i++) {
            newArr[i] = (int) (Math.pow(2, (i + 1)) - 1);
        }

        reverseArray(newArr);
        return newArr;
    }

    public static int[] getGapsPratt(int[] arr){
        ArrayList<Integer> gaps = new ArrayList<>();
        
        int n = arr.length;

        for (int i = 1; i <= n; i *= 2) { 
            for (int j = i; j <= n; j *= 3) {
                gaps.add(j);
            }
        }

        Collections.sort(gaps);

        int[] result = new int[gaps.size()];
        for (int i = 0; i < gaps.size(); i++) {
            result[i] = gaps.get(i);
        }
        reverseArray(result);
        return result;

    }
    public static void main(String[] args) {
        int[] arr = SortComplexityTest.generateSortedRandomArray(600000);
        printArray(arr);
        int[] gaps = getGapsPratt(arr);
        shellsort(arr, gaps);
    }
}
