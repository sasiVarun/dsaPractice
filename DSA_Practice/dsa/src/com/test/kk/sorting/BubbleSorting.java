package com.test.kk.sorting;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
//        int[] arr = {3,5,4,2,1};
        int[] arr = {1,4,3,2,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        boolean swapped;
        // run the steps n-1 times
        for(int i=0; i<arr.length-1; i++){
            swapped = false;
            // for each step, max item will come at the last respective index
            for(int j=1; j<arr.length-i; j++){
                // swap if the item is smaller than previous item
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // for one complete j iteration swap not happened break the i loop as array is sorted
            if(!swapped){
                break;
            }
        }
    }
}
