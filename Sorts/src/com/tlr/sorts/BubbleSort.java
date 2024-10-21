package com.tlr.sorts;

public class BubbleSort {
    public static int[] bublsort(int arr[]){
        boolean swaped = false;
        for(int i=0;i<arr.length-1;i++){
            swaped = false;
            for(int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swaped = true;
                }
            }
            if (!swaped) break;
        }
        return arr;
    }


    public static void print(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int [] arr = {3, 45, 65, 2};
        bublsort(arr);
        print(arr);
    }
}
