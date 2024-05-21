package com.test.kk.binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 10, 24, 31, 39, 45, 53 };
		int target = 53;
		
		int index = binarySearch(arr, target);
		System.out.println("Index of " + target + " is: " + index);
	}

	public static int binarySearch(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		
		while(start<=end) {
			int middle = (start + end) / 2;
			
			if(array[middle] == target)
				return middle;
			
			if (array[middle] < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			} 
		}
		
		return -1;

	}
}
