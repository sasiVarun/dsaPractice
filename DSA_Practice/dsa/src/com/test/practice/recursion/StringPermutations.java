package com.test.practice.recursion;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        printPermutations(str,"");
    }

    static void printPermutations(String str, String permutation){
        if(str.isEmpty()){
            System.out.print(permutation + " ");
            return;
        }
        // Inside for loop we are picking what character should appear first either a,b or c
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // newString will be the leftover characters other than currentChar
            // Ex: if we take a from abc, newString will be bc
            // Ex: if we take b from abc, newString will be ac
            // Ex: if we take c from abc, newString will be ab
            String newString  = str.substring(0,i) + str.substring(i+1);
            printPermutations(newString,permutation+currentChar);
        }
    }
}
