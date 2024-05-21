package com.test.practice.recursion;

public class fibonacci {

    public static void main(String[] args){
        fibonacci(6);
    }

    static void fibonacci(int n){
        int prev = 0;
        int last = 1;
        System.out.print(prev + " ");
        System.out.print(last + " ");
        fibonacci(prev,last,n-2);
    }

    private static void fibonacci(int prevLast, int last, int n){
        if(n == 0){
            return;
        }

        int current = prevLast + last;
        System.out.print(current + " ");
        fibonacci(last,current,n-1);
    }
}
