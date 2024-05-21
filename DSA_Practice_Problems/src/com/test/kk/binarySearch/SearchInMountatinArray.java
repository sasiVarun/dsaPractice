package com.test.kk.binarySearch;

public class SearchInMountatinArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 7, 6, 2, 0 };
		int target = 2;
		int index = searchIndex(arr, target);
		System.out.println(index);
	}

	static int searchIndex(int[] arr, int target) {
		int maxIndex = peakIndex(arr);
		int ans = binarySearch(arr, target, 0, maxIndex);
		if(ans == -1) {
			ans = binarySearch(arr, target, maxIndex+1, arr.length-1);
		}
		return ans;
	}

	static int peakIndex(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int middle = start + (end - start) / 2;
			if (arr[middle] > arr[middle + 1]) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}

		return start;
	}

	static int binarySearch(int[] arr, int target, int start, int end) {
		boolean flag = arr[start] < arr[end]; // ascending means true, descending means false

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (arr[middle] == target) {
				return middle;
			}

			if (flag) {
				if (arr[middle] < target) {
					start = middle + 1;
				} else {
					end = middle - 1;
				}
			} else {
				if (arr[middle] < target) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
			}
		}

		return -1;
	}

}
