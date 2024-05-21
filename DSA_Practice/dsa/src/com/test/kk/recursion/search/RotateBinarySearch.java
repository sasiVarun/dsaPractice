package com.test.kk.recursion.search;

public class RotateBinarySearch {
    public static void main(String[] args) {
//        int[] arr = {5,6,7,8,9,1,2,3};
        int[] arr = {5, 6, 1, 2, 4,};
        int target = 6;
        System.out.println(rbs2(arr, target, 0, arr.length - 1));
    }
    // Kunals Logic
    static int rbs(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        if (arr[middle] == target) {
            return middle;
        }

        if (arr[start] <= arr[middle]) {
            if (target >= arr[start] && target <= arr[middle]) {
                return rbs(arr, target, start, middle - 1);
            } else {
                return rbs(arr, target, middle + 1, end);
            }
        }

        if (target >= arr[middle] && target <= arr[end]) {
            return rbs(arr, target, middle + 1, end);
        }

        return rbs(arr, target, start, middle - 1);
    }
    // My logic
    static int rbs2(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        if (arr[middle] == target) {
            return middle;
        }

        if (arr[start] <= arr[middle]) {
            if (target >= arr[start] && target <= arr[middle]) {
                return rbs2(arr, target, start, middle - 1);
            } else {
                return rbs2(arr, target, middle + 1, end);
            }
        }

        if (arr[start] >= arr[middle]) {
            if (target >= arr[middle] && target <= arr[end]) {
                return rbs2(arr, target, middle + 1, end);
            }
        }

        return rbs2(arr, target, start, middle - 1);
    }
}
