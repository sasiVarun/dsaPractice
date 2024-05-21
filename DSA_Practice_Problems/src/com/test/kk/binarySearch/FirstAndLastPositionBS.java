package com.test.kk.binarySearch;

import java.util.Arrays;

public class FirstAndLastPositionBS {

	public static void main(String[] args) {

		int[] array = { 5, 7, 7, 7, 7, 9 };
		int target = 7;

		int[] range = searchRange(array, target);
		System.out.println(Arrays.toString(range));

	}

	public static int[] searchRange(int[] arr, int target) {

		int[] ans = { -1, -1 };

		ans[0] = search(arr, target, true);
		if(ans[0] != -1) {
			ans[1] = search(arr, target, false);
		}

		return ans;
	}

	public static int search(int[] arr, int target, boolean findStartIndex) {

		int ans = -1;
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (arr[middle]<target) {
				start = middle + 1;
			} else if (target < arr[middle]) {
				end = middle - 1;
			} else {
				ans = middle;
				if (findStartIndex) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
			}

		}

		return ans;
	}

}
