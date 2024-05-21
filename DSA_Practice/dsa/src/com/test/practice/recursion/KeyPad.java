package com.test.practice.recursion;

public class KeyPad {
    static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) {
        String num = "23456";
        printCombinations(num,0,"");
    }

    static void printCombinations(String str, int index, String combinations){
        if(index == str.length()){
            System.out.print(combinations + " ");
            return;
        }
        char currentChar = str.charAt(index);
        String mapping = keypad[currentChar-'0'];
        for (int i = 0; i < mapping.length(); i++) {
            printCombinations(str,index+1,combinations+mapping.charAt(i));
        }
    }
}
