package com.test.kk.recursion;

import java.util.Arrays;

public class MergeSortInPlace {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 8, 2, 1 };
		mergeSortInPlace(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSortInPlace(int[] arr, int start, int end) {
		if (end - start == 1) {
			return;
		}
		int middle = (start + end) / 2;

		mergeSortInPlace(arr, start, middle);
		mergeSortInPlace(arr, middle, end);

		mergeInPlace(arr, start, middle, end);
	}

	static void mergeInPlace(int arr[], int start, int middle, int end) {

		int[] mix = new int[end - start];
		int i = start;
		int j = middle;
		int k = 0; 

		while (i < middle && j < end) {
			if (arr[i] < arr[j]) {
				mix[k] = arr[i];
				i++;
			} else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}

		while (i < middle) {
			mix[k] = arr[i];
			i++;
			k++;
		}
		while (j < end) {
			mix[k] = arr[j];
			j++;
			k++;
		}

		for (int l = 0; l < mix.length; l++) {
			arr[start + l] = mix[l];
		}

	}

}
