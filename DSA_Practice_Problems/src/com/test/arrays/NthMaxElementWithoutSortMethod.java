package com.test.arrays;

public class NthMaxElementWithoutSortMethod {
	public static <T extends Comparable<T>> T nthMaxElement(T[] array, int n) {
		if (n < 1 || n > array.length) {
			throw new IllegalArgumentException("Invalid value of n");
		}

		// Apply selection algorithm to find the nth maximum element
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int pivotIndex = partition(array, start, end);
			if (pivotIndex == n - 1) {
				return array[pivotIndex];
			} else if (pivotIndex > n - 1) {
				end = pivotIndex - 1;
			} else {
				start = pivotIndex + 1;
			}
		}
		throw new IllegalStateException("Should not reach here");
	}

	// Partitioning method for selection algorithm
	private static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
		T pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot) >= 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

	// Utility method to swap elements in an array
	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] numbers = { 4, 2, 5, 1, 9, 7 };
//		Integer[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int n = 3; // Find the 3rd maximum element
		Integer nthMaxNumber = nthMaxElement(numbers, n);
		System.out.println("The " + n + "rd maximum element is: " + nthMaxNumber);

		String[] words = { "apple", "banana", "orange", "grape", "kiwi" };
		n = 2; // Find the 2nd maximum element
		String nthMaxWord = nthMaxElement(words, n);
		System.out.println("The " + n + "nd maximum element is: " + nthMaxWord);
	}
}
