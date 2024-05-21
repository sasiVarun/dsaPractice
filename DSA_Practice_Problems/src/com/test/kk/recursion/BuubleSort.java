package com.test.kk.recursion;

import java.util.Arrays;

public class BuubleSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 1 };
		buubleSort(arr, arr.length - 1, 0);
		System.out.println(Arrays.toString(arr));
	}

	static void buubleSort(int[] arr, int r, int c) {
		if (r == 0) {
			return;
		}

		if (c < r) {
			if (arr[c] > arr[c + 1]) {
				int temp = arr[c];
				arr[c] = arr[c + 1];
				arr[c + 1] = temp;
			}
			buubleSort(arr, r, c + 1);
		} else {
			buubleSort(arr, r - 1, 0);
		}
	}

}
