package com.test.kk.binarySearch;

public class RotatedBinarySearchWithDuplicates {

	public static void main(String[] args) {
		int arr[] = {2,9,1,2,2};
		int target = 9;
		int index = search(arr,target);
		System.out.println(index);
	}

	static int search(int[] arr, int target) {
		int pivot = findPivot(arr);

		if (pivot == -1) {
			return binarySearch(arr, target, 0, arr.length - 1);
		}

		if (arr[pivot] == target) {
			return pivot;
		}

		if (target >= arr[0]) {
			return binarySearch(arr, target, 0, pivot - 1);
		}
		return binarySearch(arr, target, pivot + 1, arr.length - 1);
	}

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

			if (arr[middle] == arr[start] && arr[middle] == arr[end]) {

				// Here we are checking whether start, middle, end are equal. If equal we want
				// to skip start and end.
				// NOTE: what if these elements at start and end were the pivot??
				// check if start is pivot
				if (start < end && arr[start] > arr[start + 1]) {
					return start;
				}

				start++;

				// check if end is pivot
				if (end > start && arr[end] < arr[end - 1]) {
					return end - 1;
				}
				end--;
			} else if (arr[start] < arr[middle] || (arr[start] == arr[middle] && arr[middle] > arr[end])) {
				start = middle + 1;
			} else {
				end = middle - 1;
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
