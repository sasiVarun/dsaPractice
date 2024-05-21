package com.test.kk.recursion.easy;

public class ReduceToZero {
    public static void main(String[] args) {
        int num = 14;
        int ans = count(num,0);
        System.out.println(ans);
    }

    static int count(int num, int count){
        if(num==0){
            return count;
        }
        // If num is odd subtract 1, else divide by 2
        if((num & 1) ==1){
            num= num-1;
        }else{
            num/=2;
        }
        return count(num,++count);
    }
}
