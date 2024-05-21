package com.test.practice.recursion;

public class PlaceTiles {
    public static void main(String[] args) {
        int n = 4, m = 2;
        int totalPossibilities = placeTiles(n,m);
        System.out.println(totalPossibilities);
    }

    static int placeTiles(int n, int m){

        if(n == m){
            return 2;
        }

        if( n < m){
            return 1;
        }

        int vertical = placeTiles(n-m,m);
        int horizontal = placeTiles(n-1,m);

        return vertical + horizontal;
    }
}
