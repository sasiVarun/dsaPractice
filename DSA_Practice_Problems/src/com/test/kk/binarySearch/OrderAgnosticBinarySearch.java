package com.test.kk.binarySearch;

public class OrderAgnosticBinarySearch {

	public static void main(String[] args) {
//		int[] array = {1, 3, 5, 10, 24, 31, 39, 45, 53 };
		int[] array = {67, 43, 35, 28, 21, 19, 4, -5, -8 };
		int target = 67;
		
		int index = binarySearch(array, target);
		System.out.println("Index of " + target + " is: " + index);
	}
	
	public static int binarySearch(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length-1;
		
		boolean isAsc = arr[start] < arr[end];
		
		while(start<=end) {
			int middle = (start + end)/2;
			
			if(arr[middle] == target) {
				return middle;
			}
			
			if(isAsc) {
				if(arr[middle]<target) {
					start = middle + 1;
				}else {
					end = middle-1;
				}
			}else {
				if(arr[middle]<target) {
					end = middle -1;
				}
				else {
					start = middle + 1;
				}
			}
		}
		
		return -1;
	}
}
