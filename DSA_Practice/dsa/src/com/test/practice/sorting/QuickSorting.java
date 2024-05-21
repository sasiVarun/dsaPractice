package com.test.practice.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSorting {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
//        int[] array = {1, 8, 3, 9, 4, 5, 7};
//        System.out.println(Arrays.toString(array));
        System.out.println("Before");
        quickSort(array);
        System.out.println("After");
//        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }
        // To take random index as pivot un-comment next 3 lines
        //int pivotIndex = new Random().nextInt(high-low) + low;
        //int pivot = arr[pivotIndex];
        //swap(arr,pivotIndex,high);
        // We are choosing last index as pivot.
        int pivot = arr[high];
        int leftPointer = low;
        int rightPointer = high;

        // When leftPointer and rightPointer are equal means need to swap with high(lastIndex)
        while (leftPointer < rightPointer) {
            // Move forward till leftPointer finds greater value than Pivot
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Move rightPointer 1 step back till it finds lesser value than Pivot
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            // Once we got leftPointer and rightPointer swap the values
            swap(arr, leftPointer, rightPointer);
        }
        // This line is executed when leftPointer and rightPointer is equal so swap leftPointer with high(lastIndex)
        swap(arr, leftPointer, high);

        // At every pass Pivot is at correct index. But we have to sort elements before and after Pivot
        // For that making recursion calls.
        // Values before pivot might not be sorted so high is leftPointer - 1
        // Similarly values after pivot might not be sorted so low is leftPointer + 1
        quickSort(arr, low, leftPointer - 1);
        quickSort(arr, leftPointer + 1, high);

    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
