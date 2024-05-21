package com.test.practice.recursion;

import java.util.HashSet;

public class SubSequence {
    public static void main(String[] args) {
        String given = "abc";
//        subSequence(given,0,"");
//        subSequence1("", given);
        String dup = "aaa";
        uniqueSubSequence(dup,0,"", new HashSet<String>());
    }

    static void subSequence(String str, int index, String newString){
        if(index == str.length()){
            System.out.print(newString + " ");
            return;
        }
        char currentChar = str.charAt(index);
        // Taking String
        subSequence(str,index+1,newString+currentChar);
        // Not taking String
        subSequence(str,index+1,newString);
    }

    static void subSequence1(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.print(processed + " ");
            return;
        }
        char currentChar = unprocessed.charAt(0);

        subSequence1(processed+currentChar,unprocessed.substring(1));
        subSequence1(processed,unprocessed.substring(1));
    }

    static void uniqueSubSequence(String str, int index, String newString, HashSet set){
        if(index == str.length()){
            if(set.contains(newString)){
                return;
            }else{
                System.out.print(newString + " ");
                set.add(newString);
                return;
            }
        }
        char currentChar = str.charAt(index);
        uniqueSubSequence(str,index+1,newString+currentChar,set);
        uniqueSubSequence(str,index+1,newString,set);

    }
}
