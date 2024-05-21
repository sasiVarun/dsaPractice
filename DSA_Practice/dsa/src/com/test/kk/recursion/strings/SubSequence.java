package com.test.kk.recursion.strings;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        String given = "abc";
//        subseq("", given);
        System.out.println(subseq1("", given));
    }

    static void subseq(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.print(processed + " ");
            return;
        }

        char ch = unprocessed.charAt(0);
        subseq(processed + ch, unprocessed.substring(1));
        subseq(processed, unprocessed.substring(1));
    }

    static ArrayList<String> subseq1(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        ArrayList<String> left = subseq1(processed + ch, unprocessed.substring(1));
        ArrayList<String> right = subseq1(processed, unprocessed.substring(1));

        left.addAll(right);

        return left;
    }
}
