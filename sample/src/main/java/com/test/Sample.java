package com.test;

import java.util.Arrays;

public class Sample {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
//        moveZerosToLeft(nums);
        moveZerosToRight(nums);
        System.out.print(Arrays.toString(nums));
	}
	
	public static void moveZerosToLeft(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int lastNonZeroFoundAt = nums.length - 1;

        // Traverse the array from right to left
        for (int current = nums.length - 1; current >= 0; current--) {
            if (nums[current] != 0) {
                nums[lastNonZeroFoundAt] = nums[current];
                lastNonZeroFoundAt--;
            }
        }

        // Fill the remaining positions with zeros
        for (int i = lastNonZeroFoundAt; i >= 0; i--) {
            nums[i] = 0;
        }
    }
	public static void moveZerosToRight(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int lastNonZeroFoundAt = 0;
		
		// Traverse the array from right to left
		for (int current = 0; current <= nums.length - 1; current++) {
			if (nums[current] != 0) {
				nums[lastNonZeroFoundAt] = nums[current];
				lastNonZeroFoundAt++;
			}
		}
		
		// Fill the remaining positions with zeros
		for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
