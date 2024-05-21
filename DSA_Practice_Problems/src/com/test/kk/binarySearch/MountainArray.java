package com.test.kk.binarySearch;

public class MountainArray {
	
	public static void main(String[] args) {
		int arr[] = {2,3,4,5,6,4,2,0};
		System.out.println(findMax(arr));
	}
	
	static int findMax(int[] arr) {
		
		int start = 0;
		int end = arr.length-1;
		
		while(start<end) {
			int middle = start + (end-start)/2;
			
			if(arr[middle]>arr[middle+1]) {
				/**
				 * That means I am in descending portion of array This can be answer, but there
				 * may be answer lying to left side So making end = middle;
				 */
				
				end = middle;
			}else {
				
				start = middle + 1; 
				
				/**
				 * If above if condition not satisfied that mean I am in ascending part of
				 * array. So already we checked and got middle is less than middle + 1. So we
				 * are assigning start to middle + 1
				 */ 
			}
		}
		return arr[start];
	}

}
