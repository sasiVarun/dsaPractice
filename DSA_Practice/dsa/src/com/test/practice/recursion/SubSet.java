package com.test.practice.recursion;

import java.util.ArrayList;

public class SubSet {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> list= new ArrayList<>();
        printSubset(3,list);
    }

    static void printSubset(int n, ArrayList list){
        if(n == 0){
            System.out.print(list + " ");
            return;
        }

        // take num
        list.add(n);
        printSubset(n-1,list);
        // dont take num
        list.remove(list.size()-1);
        printSubset(n-1,list);
    }
}
