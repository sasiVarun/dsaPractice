package com.test.kk.recursion;

import java.util.ArrayList;
import java.util.List;

public class Find {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 4, 5 };
		int target = 4;
		List a = findAllIndex(arr,target,0,new ArrayList<Integer>());
		System.out.println(a);

	}

	static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {

		if (index == arr.length) {
			return list;
		}

		if (arr[index] == target) {
			list.add(index);
		}

		return findAllIndex(arr, target, index + 1, list);
	}

}
