package com.test.kk.recursion.sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 8, 1};
        selectionSort(arr, arr.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {9, 6, 8, 7};
        selectionSort1(arr1, 0, 0, 0);
        System.out.println(Arrays.toString(arr1));
    }

    static void selectionSort(int[] arr, int i, int j, int max) {

        if (i == 0) {
            return;
        }

        if (j <= i) {
            if (arr[j] > arr[max]) {
                selectionSort(arr, i, j + 1, j);
            } else {
                selectionSort(arr, i, j + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            selectionSort(arr, i - 1, 0, 0);
        }
    }

    // My logic using increment for i & j
    static void selectionSort1(int[] arr, int i, int j, int max) {
        if (i == arr.length - 1) {
            return;
        }

        if (j < arr.length - i) {
            if (arr[j] > arr[max]) {
                selectionSort1(arr, i, j + 1, j);
            } else {
                selectionSort1(arr, i, j + 1, max);

            }
        } else {
            int temp = arr[max];
            arr[max] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
            selectionSort(arr, i + 1, 0, 0);
        }
    }
}
