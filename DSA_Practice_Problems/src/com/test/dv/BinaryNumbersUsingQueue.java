package com.test.dv;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Logic is adding 0 or 1 to parent node
 *       1
       /   \
     10     11
    /  \   /  \
  100 101 110 111
 *
 * Binary  |  Decimal
 * -------------------
 * 	  1			1
 * 	  10		2
 * 	  11		3
 * 	  100		4
 * 	  101		5
 * 	  110		6
 */


public class BinaryNumbersUsingQueue {
	
	public static void main(String[] args) {
		String[] ans = generateBinaryNumbers(4);
		System.out.println(Arrays.toString(ans));
	}
	
	public static String[] generateBinaryNumbers(int n) {
		
		String result[] = new String[n];
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("1");
		
		for (int i = 0; i < n; i++) {
			result[i] = queue.poll();
			String n1 = result[i] + "0";
			String n2 = result[i] + "1";
			queue.offer(n1);
			queue.offer(n2);
		}
		
		return result;
	}

}
