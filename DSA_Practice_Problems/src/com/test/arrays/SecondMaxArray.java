package com.test.arrays;

import java.util.Iterator;

public class SecondMaxArray {

	public static void main(String[] args) {
		int arr[] = { 12, 34, 2, 34, 33, 1 };
		SecondMaxArray ma = new SecondMaxArray();
		System.out.println(ma.findSecondMaximum(arr));
	}

	public int findSecondMaximum(int arr[]) {
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				secondMax = max;
				max = arr[i];
			} else if(arr[i] > secondMax && arr[i]!=max) {
				secondMax = arr[i];
			}
		}		
		
		return secondMax;
	}

}
