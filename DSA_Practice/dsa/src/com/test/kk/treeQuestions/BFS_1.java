package com.test.kk.treeQuestions;

import java.util.*;

public class BFS_1 {
    Node root;
    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            value = _val;
        }
    }

    public Node connect(Node root){
        if(root == null){
            return root;
        }

        Node leftmost = root;

        while(leftmost.left!=null){
            Node current = leftmost;
            while(current!=null){
                current.left.next = current.right;
                if(current.next!=null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public void insert(Scanner scanner) {
        System.out.print("Enter the root node: ");
        int value = Integer.parseInt(scanner.nextLine());
        root = new Node(value);
        insert(root, scanner);
    }

    private void insert(Node node, Scanner scanner) {
        System.out.print("Do you want to insert left of " + node.value + ": ");
        String left = scanner.nextLine();
        if (left.equalsIgnoreCase("y") || left.equalsIgnoreCase("yes")) {
            System.out.print("Enter the value left of " + node.value + ": ");
            int value = Integer.parseInt(scanner.nextLine());
            node.left = new Node(value);
            insert(node.left, scanner);
        }
        System.out.print("Do you want to insert right of " + node.value + ": ");
        String right = scanner.nextLine();
        if (right.equalsIgnoreCase("y") || right.equalsIgnoreCase("yes")) {
            System.out.print("Enter the value right of " + node.value + ": ");
            int value = Integer.parseInt(scanner.nextLine());
            node.right = new Node(value);
            insert(node.right, scanner);
        }
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
}
