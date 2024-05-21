package com.test.practice.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String given = "abcd";
        printReverse(given,given.length()-1);
    }

    static void printReverse(String given, int index){
        if(index == -1){
            return;
        }
        System.out.print(given.charAt(index));
        printReverse(given,index-1);
    }
}
