package com.test.kk.recursion.sorting;

import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args){
        int[] arr = {8,2,12,2,1,5};
        int[] sortedArray = mergeSort(arr);
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int middle = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,middle));
        int[] right = mergeSort(Arrays.copyOfRange(arr,middle,arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }

        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
