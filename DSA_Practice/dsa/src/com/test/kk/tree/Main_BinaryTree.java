package com.test.kk.tree;

import java.util.Scanner;

public class Main_BinaryTree {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        bt.populate(scanner);
        bt.prettyDisplay();
    }
}
