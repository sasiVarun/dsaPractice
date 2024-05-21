package com.test.kk.tree;

public class AVL {
    private Node root;

    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        if (value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        node = rotate(node);
        return node;
    }

    public Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            //left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
//                System.out.println("Displaying before right rotation");
//                display(node,0);
                // Left-Left Case, so rotate right
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
//                System.out.println("Displaying before left-right rotation");
//                display(node,0);
                // Left-Right case -> So rotate left 1st then rotate right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            //right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
//                System.out.println("Displaying before left rotation");
//                display(node,0);
                // Right-Right case -> Rotate left
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
//                System.out.println("Displaying before right-left rotation");
//                display(node,0);
                // Right - Left case -> So rotate right first then rotate left
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

//        System.out.println("Displaying after right rotation");
//        display(c,0);

        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

//        System.out.println("Displaying after left rotation");
//        display(p,0);

        return p;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.value);
        }else{
            System.out.println(node.value);
        }
        display(node.left, level + 1);
    }
}
