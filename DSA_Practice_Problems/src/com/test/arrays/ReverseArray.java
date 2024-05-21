package com.test.arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 2, 11, 5, 10, 7, 8};
		printArray(arr);
		int reversedArray[] = reverseArray(arr, 0, arr.length-1);
		System.out.println();
		printArray(reversedArray);
	}

	public static int[] reverseArray(int[] arr, int start, int last) {
		
		while(start<last) {
			int temp = arr[start];
			arr[start] = arr[last];
			arr[last] = temp;
			start++;
			last--;			
		}
		return arr;
	}
	
	public static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
