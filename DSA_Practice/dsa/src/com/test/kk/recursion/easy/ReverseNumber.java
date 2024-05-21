package com.test.kk.recursion.easy;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 2345;
        int ans = reverse(num,0);
        System.out.println(ans);
    }

    static int reverse(int n, int reversed){
        if(n == 0){
            return reversed;
        }
        int last = n % 10;
        reversed = reversed * 10 + last;
        return reverse(n/10, reversed);
    }
}
