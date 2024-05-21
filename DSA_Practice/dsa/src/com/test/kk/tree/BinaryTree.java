package com.test.kk.tree;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void populate(Scanner scanner) {
        System.out.print("Enter the root Node:");
        int value = Integer.parseInt(scanner.nextLine());
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {

        System.out.print("Do you want to enter the left of - " + node.value + ": ");
        String left = scanner.nextLine();
        if (left.equalsIgnoreCase("y") || left.equalsIgnoreCase("yes")) {
            System.out.print("Enter the value to the left of - " + node.value + ": ");
            int value = Integer.parseInt(scanner.nextLine());
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to enter the right of - " + node.value + ": ");
        String right = scanner.nextLine();
        if (right.equalsIgnoreCase("y") || right.equalsIgnoreCase("yes")) {
            System.out.print("Enter the value to the right of - " + node.value + ": ");
            int value = Integer.parseInt(scanner.nextLine());
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
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
