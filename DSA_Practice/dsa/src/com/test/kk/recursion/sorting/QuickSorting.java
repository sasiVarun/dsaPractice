package com.test.kk.recursion.sorting;

import java.util.Arrays;

public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex){
            return;
        }
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr,leftPointer,rightPointer);
        }
        swap(arr,leftPointer,highIndex);
        quickSort(arr,lowIndex,leftPointer-1);
        quickSort(arr,leftPointer+1,highIndex);

    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
