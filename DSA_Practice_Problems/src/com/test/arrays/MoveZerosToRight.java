package com.test.arrays;

public class MoveZerosToRight {

	public static void main(String[] args) {
		MoveZerosToRight arrayUtil = new MoveZerosToRight();
		arrayUtil.arrayDemo();

	}

	public void arrayDemo() {
		int arr[] = { 8, 1, 0, 2, 1, 0, 3 };
		printArray(arr);
		int[] finalArrray = moveZeros(arr);
		printArray(finalArrray);
	}

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int[] moveZeros(int[] arr) {
		int j = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			if (arr[j] != 0) {
				j++;
			}
		}
		
		return arr;
	}

}
