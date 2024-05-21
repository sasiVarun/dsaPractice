package com.test.practice.recursion;

public class Power {
    public static void main(String[] args) {
//        int ans = power(2, 10);
        int ans = powerStackSizeLog(2, 10);
        System.out.println(ans);
    }

    static int power(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int xPownm1 = power(x, n - 1);
        int xPown = x * xPownm1;

        return xPown;
    }

    static int powerStackSizeLog(int x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            return powerStackSizeLog(x, n / 2) * powerStackSizeLog(x, n / 2);
        } else {
            return powerStackSizeLog(x, n / 2) * powerStackSizeLog(x, n / 2) * x;
        }
    }
}
