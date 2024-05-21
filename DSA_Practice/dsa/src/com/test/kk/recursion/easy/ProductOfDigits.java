package com.test.kk.recursion.easy;

public class ProductOfDigits {
    public static void main(String[] args) {
        int num = 1345;
        int ans = productOf(num);
        System.out.println("Product of " + num + " is: " + ans);
    }
    static int productOf(int n){
        if(n==0){
            return 1;
        }

        return (n%10) * productOf(n/10);
    }
}
