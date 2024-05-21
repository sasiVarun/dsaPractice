package com.test.arrays;

public class XOR {
	
	public static void main(String[] args) {
		int a1[] = {100,200,300,200,100,400,300};
		int num = singleNumber(a1);
		System.out.println(num);
	}
	
	/*Single Number: Given an array of integers, every element appears twice except for one. Find that single one.*/
	public static int singleNumber(int[] nums) {
	    int result = 0;
	    for (int num : nums) {
	        result ^= num;
	    }
	    return result;
	}


}
