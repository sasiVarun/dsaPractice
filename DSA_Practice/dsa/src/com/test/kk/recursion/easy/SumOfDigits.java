package com.test.kk.recursion.easy;

public class SumOfDigits {
    public static void main(String[] args) {
        int num = 1345;
        int ans = sumOf(num);
        System.out.println("Sum of " + num + " is: " + ans);
    }
    static int sumOf(int num){
        if(num == 0){
            return 0;
        }
        return (num % 10) + sumOf(num / 10);
    }
}
