package com.test.practice.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSorting {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100000);
        }
//        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before");
//        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("After");
//        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int inputLength = array.length;
        if (inputLength < 2) {
            return;
        }
        int middleIndex = inputLength / 2;
        int[] leftHalf = new int[middleIndex];
        int[] rightHalf = new int[inputLength - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int j = middleIndex; j < inputLength; j++) {
            rightHalf[j - middleIndex] = array[j];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
