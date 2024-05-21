package com.test.kk.sorting;

import java.util.Arrays;

public class BubbleSorting {
	
	public static void main(String[] args) {
//		int[] arr = {3,4,5,2,1};
//		int[] arr = {5,4,3,2,1};
//		int[] arr = {1};
//		int[] arr = {};
//		int[] arr = {5,6,0,-3,-9,4};
		int[] arr = {1,2,3,4,5};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int arr[]) {
		boolean swapped;
		for(int i=0; i<arr.length; i++) {
			swapped = false;
			for(int j=1; j<arr.length-i; j++) {
				
				if(arr[j]<arr[j-1]) { // if need to make sorting as descending change less than to greater than
					swap(arr, j, j-1);
					swapped=true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	
	public static void swap(int arr[], int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
