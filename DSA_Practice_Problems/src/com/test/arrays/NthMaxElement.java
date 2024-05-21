package com.test.arrays;

import java.util.Arrays;

public class NthMaxElement {
	
	public static void main(String[] args) {
		Integer[] numbers = {2,9,0,6,10,13};
		Integer nthMax = findNthmax(numbers, 2);
		System.out.println(nthMax);
		
		String[] words = {"Sam","david","javed","Ajay"};
		String nthMaxWord = findNthmax(words, 1);
		System.out.println(nthMaxWord);
	}
	
	public static <T extends Comparable<T>> T findNthmax(T[] array, int n){
		
		if(n<1 || n>array.length)
			throw new IllegalArgumentException("Invalid element number n");
		
		Arrays.sort(array, (a,b) -> b.compareTo(a));
		
		return array[n-1];
	}

}
