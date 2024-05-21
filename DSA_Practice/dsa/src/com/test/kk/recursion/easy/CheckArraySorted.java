package com.test.kk.recursion.easy;

public class CheckArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,4,8,9};
//        boolean arraySorted = isSorted(arr,0);
        boolean arraySorted = isSorted1(arr,0);
        System.out.println(arraySorted);
    }
    //My logic
    static boolean isSorted(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        if(arr[index]>arr[index+1]){
            return false;
        }
        return isSorted(arr,index+1);
    }
    // Kunal's Logic
    static boolean isSorted1(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && isSorted1(arr,index+1);
    }
}
