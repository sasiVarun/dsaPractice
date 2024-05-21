package com.test.kk.sorting;

public class FindMissingElement {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        int n = 4;
        int ans = cyclicSort(arr, n);
        System.out.println(ans);
    }

    static int cyclicSort(int[] arr, int n) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return n;
    }
}
