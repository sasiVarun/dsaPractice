package com.test.practice.recursion;

public class FirstLastOccurence {
    public static void main(String[] args) {
        String given = "abaacdaefaah";
        firstLast(given,'a', 0,-1,-1);
    }

    static void firstLast(String given , char target, int index, int first, int last){
        if((given.length()-1) == index){
            System.out.println("First Index: "+ first + " Last Index: " + last);
            return;
        }

        if(given.charAt(index) == target){
            if(first == -1){
                first = index;
            }else{
                last = index;
            }
        }

        firstLast(given,target,index+1,first,last);

    }
}
