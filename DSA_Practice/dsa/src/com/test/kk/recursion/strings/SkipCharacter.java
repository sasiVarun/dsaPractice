package com.test.kk.recursion.strings;

public class SkipCharacter {
    public static void main(String[] args) {
        String given = "baccadh";
//        skip("",given);
        String ans = skip1(given);
        System.out.println(ans);
    }

    static void skip(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        if(ch == 'a'){
            skip(processed,unprocessed.substring(1));
        }else {
            skip(processed+ch,unprocessed.substring(1));
        }
    }

    static String skip1(String unprocessed){
        if(unprocessed.isEmpty()){
            return "";
        }

        char ch = unprocessed.charAt(0);
        if(ch == 'a'){
            return skip1(unprocessed.substring(1));
        }else {
            return ch + skip1(unprocessed.substring(1));
        }
    }
}
