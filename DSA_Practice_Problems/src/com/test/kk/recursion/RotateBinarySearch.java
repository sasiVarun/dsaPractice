package com.test.kk.recursion;

public class RotateBinarySearch {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 1, 2, 3 };
		int target = 9;
		int index = search(arr, target, 0, arr.length - 1);
		System.out.println("Index is: " + index);
	}

	static int search(int[] arr, int target, int start, int end) {
		if (start > end) {
			return -1;
		}

		int middle = start + (end - start) / 2;

		if (arr[middle] == target) {
			return middle;
		}

		if (arr[start] <= arr[middle]) {
			if (arr[start] <= target && target <= arr[middle]) {
				return search(arr, target, start, middle - 1);
			} else {

				return search(arr, target, middle + 1, end);
			}
		}

		if (target >= arr[middle] && target <= arr[end]) {
			return search(arr, target, middle + 1, end);
		}

		return search(arr, target, start, middle - 1);
	}

}
