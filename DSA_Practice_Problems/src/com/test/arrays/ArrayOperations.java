package com.test.arrays;

public class ArrayOperations {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 6;
		arr[3] = 10;
		arr[4] = 15;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
