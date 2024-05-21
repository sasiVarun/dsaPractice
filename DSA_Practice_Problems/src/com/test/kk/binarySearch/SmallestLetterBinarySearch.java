package com.test.kk.binarySearch;

public class SmallestLetterBinarySearch {

	public static void main(String[] args) {
		char[] character = { 'c', 'd', 'f' };
		char target = 'g';
		
		char ans = smallChar(character, target);
		System.out.println("Character: " + ans);

	}

	public static char smallChar(char[] arr, char target) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (arr[middle] < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		return arr[start % arr.length];
	}

}
