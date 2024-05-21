package com.test.kk.recursion.strings;

public class Permutation {

    public static void main(String[] args) {
        String given = "abc";
        permutations("", given);

    }

    static void permutations(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            permutations(first + ch + second, unprocessed.substring(1));

        }
    }
}
