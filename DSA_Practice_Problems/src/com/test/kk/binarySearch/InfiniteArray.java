package com.test.kk.binarySearch;

/**
 * <strong>Note:</strong> When we are trying to find some elements,
 *  let's say from 99 we will get index bound exception because we are doubling the size of array.
 *  But as per problem we are having Infinite array, so when data is large we wont get exception.
 *  Here having issue with data providing but not issue with logic of program.
 */
public class InfiniteArray {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,7,9,10,23,33,37,56,77,83,85,99,100,102,105,109};
		int target = 85;
		
		int index = findRange(arr, target);
		System.out.println(index);
	}

	static int findRange(int[] arr, int target) {
		int start = 0;
		int end = 1;

		while (target > arr[end]) {
			int temp = end + 1;
			end = end + (end - start + 1) * 2;
			start = temp;
		}
		return binarySearch(arr, target, start, end);
	}

	static int binarySearch(int[] arr, int target, int start, int end) {

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
		return -1;
	}

}
