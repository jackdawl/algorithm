package com.jackdawl.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {


    /**
     * Inserting elements into an ordered set, and the sequence is still ordered after insertion,
     * which is the idea of the insertion sorting algorithm. The specific steps are as follows:
     * 1.Divide the array into sorted and unsorted segments, and the sorted segment has only one element at initialization;
     * 2.Insert elements from unsorted segments into sorted segments, and ensure that they are still orderly after insertion;
     * 3.Repeat until all unsorted segment elements are retrieved.
     *
     * @param arr Integer arrays
     */
    public static void insertSort(Integer[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }

        for (int i = 1; i < length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }

    }

    /**
     * An optimization for insertion sorting
     * The idea is to group the elements by a certain increment of the target, and use direct insertion sorting for each group;
     * As the increment decreases, each group contains more and more elements, and when the increment decreases to 1,
     * all elements are grouped and the algorithm is terminated.
     *
     * @param arr Integer arrays
     */
    public static void sherSort(Integer[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int add = length / 2;
        while (add > 0) {

            for (int k = 0; k < add; k++) {
                for (int i = k + add; i < length; i += add) {
                    int temp = arr[i];
                    for (int j = i - add; j >= 0 && temp < arr[j]; j -= add) {
                        arr[j + add] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            add /= 2;
        }


    }


    /**
     * Divide the elements in half, and each half continues to be divided in half,
     * until there is only one element, and then group them together by inserting the sort.
     *
     * @param arr   Integer arrays
     * @param left Array segment left index
     * @param right Array segment right index
     */
    public static void mergeSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            doMerge(arr, left, mid, right);

        }

    }

    public static void doMerge(Integer[] arr, int left, int mid, int right) {
        //When the amount of data is too large, it may be slow due to memory limitations, and can be declared outside the method
        Integer[] temp = new Integer[arr.length];
        int p1 = left;
        int p2 = mid + 1;
        int cur = left;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                temp[cur++] = arr[p1++];

            } else {
                temp[cur++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            temp[cur++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[cur++] = arr[p2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }


    public static void main(String[] args) {
        int len = 1000;
        Integer[] arr = new Integer[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(len) + 1;
        }

        System.out.println("Before sorting: " + Arrays.deepToString(arr));
        long start = System.currentTimeMillis();
//        insertSort(arr);
//        sherSort(arr);
        mergeSort(arr, 0, len - 1);
        System.out.println("After sorting: " + Arrays.deepToString(arr));
        System.out.println("used times: " + (System.currentTimeMillis() - start) + " ms");
    }

}
