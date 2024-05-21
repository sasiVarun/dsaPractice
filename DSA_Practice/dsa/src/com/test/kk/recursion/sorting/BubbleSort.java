package com.test.kk.recursion.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 9, 0};
        bubbleSort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {4,3,6,9,0};
        bubbleSort1(arr1, arr1.length - 1, 0, false);
        System.out.println(Arrays.toString(arr1));
        int[] arr3 = {9, 8, 7, 6};
        bubbleSort2(arr3, 0, 0);
        System.out.println(Arrays.toString(arr3));
    }

    // Kunals Logic
    static void bubbleSort(int[] arr, int i, int j) {
        if (i == 0) {
            return;
        }
        if (j < i) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSort(arr, i, j + 1);
        } else {
            bubbleSort(arr, i - 1, 0);
        }
    }

    // My logic added swapped additionally
    static void bubbleSort1(int[] arr, int i, int j, boolean swapped) {

        if (i == 0) {
            return;
        }

        if (j < i) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
            bubbleSort1(arr, i, j + 1, swapped);
        } else {
            if (!swapped) {
                return;
            }
            bubbleSort1(arr, i - 1, 0, false);
        }
    }

    // My logic using increment i and j
    static void bubbleSort2(int[] arr, int i, int j) {
        if (i == arr.length - 1) {
            return;
        }

        if (j < arr.length - i - 1) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSort2(arr, i, j + 1);
        } else {
            bubbleSort2(arr, i + 1, 0);
        }
    }
}
