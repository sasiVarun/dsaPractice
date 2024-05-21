package com.test.kk.recursion.easy;

public class CountNumOfZeros {
    public static void main(String[] args) {
        int num = 100020000;
        int ans = count(num,0);
        System.out.println(ans);
    }

    static int count(int num, int count){
        if(num == 0){
            return count;
        }
        if(num%10 == 0){
            count++;
        }
        return count((num/10),count);
    }
}
