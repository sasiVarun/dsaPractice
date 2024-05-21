package com.test.kk.sorting;

import java.util.Arrays;

public class SelectionSorting {

	public static void main(String[] args) {
		
		int[] arr = {4,5,2,1,3};
//		int[] arr = {};
//		int[] arr = {1};
//		int[] arr = {-3,-5,-6,-8,0,0};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int lastIndex = arr.length-i-1;
			int maxIndex = getMaxIndex(arr, 0, lastIndex);
			swap(arr, maxIndex, lastIndex);
		}
	}
	
	static int getMaxIndex(int[] arr, int start, int end) {
		int max = start;
		
		for(int i=start; i<=end; i++) {
			if(arr[max]<arr[i]) { // if need to make sorting as descending change less than to greater than
				max = i;
			}
		}
		
		return max;
	}
	
	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}
