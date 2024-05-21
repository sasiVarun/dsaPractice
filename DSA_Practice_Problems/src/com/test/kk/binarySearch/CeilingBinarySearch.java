package com.test.kk.binarySearch;

/**
 * <p>Problem statement is we have to find ceiling of the target in an array.
 * 
 * If target number is present in array we have to return it.
 * 
 * If target number not there we have to return next smallest of largest numbers present in array.</p>
 * 
 * Let us say
 * <pre> int arr[]  = { 1, 3, 5, 7, 9, 14, 16, 18 }</pre>
 * 
 * <p>Target is 15. So 15 not present in array so next largest numbers are 16, 18.</p>
 * <p>Out of 16, 18 -> 16 is the smallest of largest numbers present</p> 
 */

public class CeilingBinarySearch {
	

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 14, 16, 18 };
		int target = 15;

		int index = ceilingSearch(arr, target);
		if (index != -1)
			System.out.println("Ceiling of " + target + " in given array is: " + arr[index] + " at index: " + index);
		else
			System.out.println("Ceiling of " + target + " in given array is not found");
	}
	
	/** <p>Basically program is similar to Binary search.
	 * Only change in program is earlier if number is not found we used to return -1.
	 * Now we will return <strong>start</strong>
	 * Additionally we are checking if target is greater than largest number in Array then we are returning index -1 </p>
	 */

	public static int ceilingSearch(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;

		if (arr[end] < target) {
			return -1;
		}

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (arr[middle] == target) {
				return middle;
			}

			if (arr[middle] < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		return start;
	}
}
