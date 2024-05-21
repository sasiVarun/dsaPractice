package com.test.kk.sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {
//        int[] arr = {3, 1, 5, 4, 2};
        int[] arr = {5, 4, 3, 2, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int lastIndex = arr.length - i - 1;
            int max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[lastIndex];
            arr[lastIndex] = temp;
        }
    }
}
