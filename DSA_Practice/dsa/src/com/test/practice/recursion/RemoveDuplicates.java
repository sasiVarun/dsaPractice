package com.test.practice.recursion;

public class RemoveDuplicates {
    // Total alphabets count is 26
    static boolean[] map = new boolean[26];
    public static void main(String[] args) {
        String given = "abbccdda";
        removeDuplicates(given,0,"");
    }

    static void removeDuplicates(String str, int index, String newString){
        if(index == str.length()){
            System.out.println(newString);
            return;
        }

        char currentChar = str.charAt(index);

        /**'a' - 'a' = 0
         * 'b' - 'a' = 1
         * 'c' - 'a' = 2
         * so on 'z' - 'a' = 25
         */
        if(map[currentChar-'a']){
        // When true already character has been present so not adding to newString, just increasing index
            removeDuplicates(str,index+1,newString);
        }else{
        // When false character not present so adding to newString, and increasing index
            newString+=currentChar;
            map[currentChar-'a'] = true;
            removeDuplicates(str,index+1,newString);
        }
    }
}
