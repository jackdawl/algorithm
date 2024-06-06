package com.jackdawl.sort;

import java.util.Arrays;
import java.util.Random;

public class SwapPositionSort {

    /**
     * Different from inserting sorts, each time find the index of the smallest element of unsorted segment
     * and swap the left-end element of unsorted segment with it.
     *
     * @param arr Integer arrays
     */
    public static void selectSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }


    /**
     * Bubbling sort will only manipulate two adjacent elements. Each bubbling sort compares two adjacent elements to see
     * if the size relationship is satisfied, and swaps places if not.
     * A bubble will move at least one element to its rightful position.
     *
     * @param arr Integer arrays
     */
    public static void bubbleSort(Integer[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {

            // If no exchange occurs, it indicates that it has been ordered, and the cycle can be ended
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                return;
            }
        }
    }


    /**
     * First, we need to select a base number, which is usually the first one in the sequence to be sorted.
     * 1.Compare the number from the far right with the base number, and swap places if it is lower than the base number;
     * 2.Compare the number from the second on the right with the base number, and swap places if it is larger than the base number;
     * Repeat the above two steps in turn to divide the sequence into three parts: {Smaller than the base number} The base number {Larger than the base number},
     * that is complete a fast sort. Then the left and right parts are executed again.
     *
     * @param arr Integer arrays
     */
    public static void fastSort(Integer[] arr, int left, int right) {
//        int base = left;
        int base = arr[left];
        int i = left;
        int j = right;
        while (i < j) {

            /*if (i == base && arr[j] < arr[base]) {
                int temp = arr[base];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                base = j;
            } else if (i == base) {
                j--;
            } else if (j == base && arr[i] > arr[base]) {
                int temp = arr[base];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
                base = i;
            } else if (j == base) {
                i++;
            }

            if (left < base - 1) {
                fastSort(arr, left, base - 1);
            }
            if (right > base + 1) {
                fastSort(arr, base + 1, right);
            }*/

            while (i < j && arr[j] >= base) {
                j--;
            }
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;

            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }


        }
        if (left < i) {
            fastSort(arr, left, i - 1);
        }
        if (right > j) {
            fastSort(arr, j + 1, right);
        }


    }


    public static void main(String[] args) {
        int len = 10000;
        Integer[] arr = new Integer[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(len) + 1;
        }

        System.out.println("Before sorting: " + Arrays.deepToString(arr));
        long start = System.currentTimeMillis();
//        selectSort(arr);
//        bubbleSort(arr);
        fastSort(arr, 0, len - 1);
        System.out.println("After sorting: " + Arrays.deepToString(arr));
        System.out.println("used times: " + (System.currentTimeMillis() - start) + " ms");
    }


}
