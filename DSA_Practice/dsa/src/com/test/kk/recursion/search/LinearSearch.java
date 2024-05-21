package com.test.kk.recursion.search;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4,3,9,1,0,-1,8,4};
        int target = 4;
//        int index = linearSearch(arr,target,0);
//        System.out.println(index);
//        List<Integer> indexes = findAllIndexes(arr,target,0,new ArrayList<>());
        List<Integer> indexes = findAllIndexes2(arr,target,0);
        System.out.println(indexes);
    }
    static int linearSearch(int[] arr, int target, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return linearSearch(arr,target,index+1);
    }
    static ArrayList<Integer> findAllIndexes(int[] arr, int target, int index, ArrayList<Integer> ans){
        if(index == arr.length){
            return ans;
        }

        if(arr[index] == target){
            ans.add(index);
        }
        return findAllIndexes(arr, target,index+1,ans);
    }

    static ArrayList<Integer> findAllIndexes2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return list;
        }

        if(arr[index] == target){
            list.add(index);
        }

        ArrayList<Integer> allAnswers = findAllIndexes2(arr, target, index+1);
        list.addAll(allAnswers);

        return list;
    }
}
