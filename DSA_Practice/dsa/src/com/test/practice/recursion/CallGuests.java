package com.test.practice.recursion;

public class CallGuests {
    public static void main(String[] args) {
        int guests = 4;
        int possibilities = callGuests(guests);
        System.out.println(possibilities);
    }

    static int callGuests(int n){
        if(n <= 1){
            return 1;
        }
        // single
        int way1 = callGuests(n-1);
        // pair
        int way2 = (n-1) *callGuests(n-2);

        return way1 + way2;
    }
}
