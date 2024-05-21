package com.test.kk.binarySearch;

/**
 * <p>Problem statement is we have to find floor of the target in an array.
 * 
 * If target number is present in array we have to return it.
 * 
 * If target number not there we have to return next largest of smallest numbers present in array.</p>
 * 
 * Let us say
 * <pre> int[] arr  = { 1, 3, 5, 7, 9, 14, 16, 18 }</pre>
 * 
 * <p>Target is 13. So 13 not present in array so next smallest numbers are 1,3,5,7,9</p>
 * <p>Out of 1,3,5,7,9 -> 9 is the largest of smallest numbers present</p> 
 */

public class FloorBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 14, 16, 18 };
		int target = 13;

		int index = floorSearch(arr, target);
		if (index != -1)
			System.out.println("Ceiling of " + target + " in given array is: " + arr[index] + " at index: " + index);
		else
			System.out.println("Ceiling of " + target + " in given array is not found");
	}
	
	/** <p>Basically program is similar to Binary search.
	 * Only change in program is earlier if number is not found we used to return -1.
	 * Now we will return <strong>end</strong></p>
	 */
	public static int floorSearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

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

		return end;
	}

}
