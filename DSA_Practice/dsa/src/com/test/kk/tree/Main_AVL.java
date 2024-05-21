package com.test.kk.tree;

public class Main_AVL {
    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        tree.populate(nums);
        tree.display();
        System.out.println("\nTree height: " + tree.height());
    }
}
