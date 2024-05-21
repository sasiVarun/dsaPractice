package com.test.kk.binarySearch;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, -3, -2, -1, 0, 1, 2, 3 };
//		int[] arr = { 4, 5, 6, 0, 1, 2, 3 };
//		int[] arr = { 0,1,2,3,4,5}; // will get pivot -1 for Not rotated array debug and check
		int target = 4;
		int ans = search(arr, target);
		System.out.println(ans);
	}

	static int search(int[] arr, int target) {
		int pivot = findPivot(arr);

		if (pivot == -1) {
			return binarySearch(arr, target, 0, arr.length - 1);
		}

		if (arr[pivot] == target) {
			return pivot;
		}

		if (target >= arr[0]) { // change to only greater than and debug got wrong index for target 4
			return binarySearch(arr, target, 0, pivot - 1);
		} else {
			return binarySearch(arr, target, pivot + 1, arr.length - 1);
		}
	}
	//Code wont work if duplicates are present.
	static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int middle = start + (end - start) / 2;
			if (middle < end && arr[middle] > arr[middle + 1]) {
				return middle;
			}

			if (middle > start && arr[middle] < arr[middle - 1]) {
				return middle - 1;
			}

			if (arr[start] >= arr[middle]) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}

		return -1;
	}

	static int binarySearch(int[] arr, int target, int start, int end) {

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (arr[middle] == target) {
				return middle;
			}
			if (target < arr[middle]) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}
}
