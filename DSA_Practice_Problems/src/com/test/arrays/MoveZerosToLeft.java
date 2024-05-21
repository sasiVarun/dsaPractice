package com.test.arrays;

import java.util.Arrays;

public class MoveZerosToLeft {

	public static void main(String[] args) {
		int[] arr = {1, 0, 3, 0, 5, 0, 7,0};
//      moveZeroesToLeft(arr);
		int i = arr.length-1;
		int j = arr.length-1;
		
		while(true) {
			if(i == -1 || j==-1) {
				break;
			}
			if(arr[i]!=0 && arr[j]==0) {
				swap(arr,j,i);
			}
			
			if(arr[j]!=0) {
				j--;
				i--;
			}
			
			if(i!=-1 && arr[i]==0) {
				i--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void moveZeroesToLeft(int[] nums) {
      int left = nums.length-1; // Pointer for placing non-zero elements
      int right = nums.length-1; // Pointer for iterating through the array
      
      // Iterate through the array
      while (right >=0) {
          // If the current element is non-zero, move it to the left
          if (nums[right] != 0) {
              nums[left] = nums[right];
              left--;
          }
          right--;
      }
      
      // Fill the rest of the array with zeroes
      while (left >=0) {
          nums[left] = 0;
          left--;
      }
  }

}
