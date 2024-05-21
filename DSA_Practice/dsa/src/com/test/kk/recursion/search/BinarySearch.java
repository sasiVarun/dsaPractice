package com.test.kk.recursion.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 5, 7, 8, 9, 13, 17};
        int target = 2;
        int index = binarySearch(array, target, 0, array.length - 1);
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        // Target is not found so returning -1
        if (start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        //Writing my 3 conditions of Binary Search
        //1.If middle equal to target return middle
        if (arr[middle] == target) {
            return middle;
        }
        // 2. If middle is less than target answer is in right side so shift start to middle + 1
        if (arr[middle] < target) {
            return binarySearch(arr, target, middle + 1, end);
        }
        // 3. If middle is greater than target answer is in left side so shift end to middle - 1
        return binarySearch(arr, target, start, middle - 1);
    }
}
