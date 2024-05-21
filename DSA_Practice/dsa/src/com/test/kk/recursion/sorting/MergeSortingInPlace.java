package com.test.kk.recursion.sorting;

import java.util.Arrays;

public class MergeSortingInPlace {
    public static void main(String[] args) {
        int[] arr = {8,2,12,3,1,5};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }
        int middle = start + (end-start)/2;
        mergeSort(arr,start,middle);
        mergeSort(arr,middle,end);

        merge(arr,start,middle,end);
    }

    static void merge(int[]arr,int start,int middle, int end){
        int[] mix = new int[end - start];
        int i = start;
        int j = middle;
        int k = 0;

        while(i < middle && j < end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<middle){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
        }
    }
}
