package com.test.kk.tree;

public class Main_BST {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        tree.populate(nums);
        tree.prettyDisplay();
        System.out.println("Is tree balanced: " + tree.balanced());
        System.out.println("Pre-Order");
        tree.preOrder();
        System.out.println("\nIn-Order");
        tree.inOrder();
        System.out.println("\nPost-Order");
        tree.postOrder();
//        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        tree.populateSorted(nums);
//        tree.display();
    }
}
