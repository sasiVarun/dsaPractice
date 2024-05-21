package com.test.kk.recursion.easy;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int factorialAns = factorial(n);
        int sumAns = sum(n);
        System.out.println(factorialAns);
        System.out.println(sumAns);
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
