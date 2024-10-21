package com.tlr.sorts;

import java.util.Arrays;
import java.util.Random;
import java.io.PrintWriter;
import java.io.IOException;


public class SortComplexityTest {
    public static long SortTime(int[] arr, String sortType) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();

        switch (sortType) {
            case "quicksort":
                QuickSort.quickSort(copy, 0, copy.length - 1);
                break;
            case "mergesort":
                MergeSort.mergeSort(copy, 0, copy.length-1);
                break;
            case "insertionsort":
                InsertionSort.insert_sort(copy);
                break;
            case "selectionsort":
                SelectionSort.sel_sort(copy);
                break;
            case "bogosort":
                BogoSort.bogo_sort(copy);
                break;
            case "shellsortS":
                ShellSort.shellsort(copy, ShellSort.getGapsShell(copy));
                break;
            case "shellsortH":
                ShellSort.shellsort(copy, ShellSort.getGapsHibbard(copy));
                break;
            case "shellsortP":
                ShellSort.shellsort(copy, ShellSort.getGapsPratt(copy));
                break;
            case "bubblesort":
                BubbleSort.bublsort(copy);
                break;
            case "heapsort":
                HeapSort.heapSort(copy);
                break;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static double averageTime(int[] arr, String sortType, int runs) {
        long totalTime = 0;
        for (int i = 0; i < runs; i++) {
            totalTime += SortTime(arr, sortType);
        }
        return (totalTime / (double) runs) / 1000000000.0;
    }

    public static int[] generateRandomArray(int size) {
        long seed = 12345L;
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    public static int[] generateFullSortedArray(int size) {
        long seed = 12345L;
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }

        Arrays.sort(array);

        return array;
    }

    public static int[] generateSortedRandomArray(int size) {
        long seed = 12345L;
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }

        Arrays.sort(array);
        ShellSort.reverseArray(array);

        return array;
    }

    public static int[] generatePartiallySortedArray(int size) {
        long seed = 12345L;
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }

        int sortedSize = (int) (size * 0.9);
        Arrays.sort(array, 0, sortedSize);

        int randomStart = sortedSize;
        for (int i = randomStart; i < size; i++) {
            array[i] = random.nextInt(10000);
        }

        return array;
    }

    public static void writeToFileRandom(int[] sizes, String sortType, int runs){
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Vadim\\Documents\\MATLAB\\sort_data.csv")) {
            writer.println("ArraySize, AvgTimeSeconds");

            for (int size : sizes) {
                int[] arr = generateRandomArray(size);
                double avgTimeInSeconds = averageTime(arr, sortType, runs);

                writer.println(size + "," + avgTimeInSeconds);
            }
            System.out.println("Результаты успешно записаны в файл sort_data.csv.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void writeToFileFullSorted(int[] sizes, String sortType, int runs){
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Vadim\\Documents\\MATLAB\\sort_data_sorted.csv")) {
            writer.println("ArraySize, AvgTimeSeconds");

            for (int size : sizes) {
                int[] arr = generateFullSortedArray(size);
                double avgTimeInSeconds = averageTime(arr, sortType, runs);

                writer.println(size + "," + avgTimeInSeconds);
            }
            System.out.println("Результаты успешно записаны в файл sort_data_sorted.csv.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void writeToFileSorted(int[] sizes, String sortType, int runs){
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Vadim\\Documents\\MATLAB\\sort_data_revsorted.csv")) {
            writer.println("ArraySize, AvgTimeSeconds");

            for (int size : sizes) {
                int[] arr_2 = generateSortedRandomArray(size);
                double avgTimeInSeconds = averageTime(arr_2, sortType, runs);

                writer.println(size + "," + avgTimeInSeconds);
            }
            System.out.println("Результаты успешно записаны в файл sort_data_revsorted.csv.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void writeToFilePartiallySorted(int[] sizes, String sortType, int runs){
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Vadim\\Documents\\MATLAB\\sort_data_partial.csv")) {
            writer.println("ArraySize, AvgTimeSeconds");

            for (int size : sizes) {
                int[] arr_3 = generatePartiallySortedArray(size);
                double avgTimeInSeconds = averageTime(arr_3, sortType, runs);

                writer.println(size + "," + avgTimeInSeconds);
            }
            System.out.println("Результаты успешно записаны в файл sort_data_partial.csv.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static int[] generateSizesArray(int gap, int quantity){
        int[] sizes = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            sizes[i] = gap * i;
        }
        return sizes;
    }

    public static int[] generateExponentialSizesArray(int gap, int quantity){
        int[] sizes = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            sizes[i] = (int) Math.pow(gap, i);
        }
        return sizes;
    }


    public static void main(String[] args) {
        int[] sizesQ = generateExponentialSizesArray(2, 20);
        int[] sizes = generateSizesArray(10000, 11);
        String sortType = "shellsortH";
        int runs = 20;
        writeToFileRandom(sizesQ, sortType, runs);
        writeToFileFullSorted(sizesQ, sortType, runs);
        writeToFileSorted(sizesQ, sortType, runs);
        writeToFilePartiallySorted(sizesQ, sortType, runs);
    }
}
