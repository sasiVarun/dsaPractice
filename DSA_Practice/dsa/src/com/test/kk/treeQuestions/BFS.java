package com.test.kk.treeQuestions;

import java.util.*;

public class BFS {
    Node root;

    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
    //https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    public List<Double> averageOfLevels(Node root) {
        List<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double averageOfLevel=0;
            for (int i = 0; i < levelSize; i++) {
                Node currentLevelNode = queue.poll();
                averageOfLevel+=currentLevelNode.value;
                if(currentLevelNode.left!=null){
                    queue.offer(currentLevelNode.left);
                }
                if(currentLevelNode.right!=null){
                    queue.offer(currentLevelNode.right);
                }
            }
            averageOfLevel=averageOfLevel/levelSize;
            result.add(averageOfLevel);
        }
        return result;
    }

    public Node findSuccessor(Node root, int key){
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node currenLevelNode = queue.poll();
            if(currenLevelNode.left!=null){
                queue.offer(currenLevelNode.left);
            }
            if(currenLevelNode.right!=null){
                queue.offer(currenLevelNode.right);
            }
            if(currenLevelNode.value == key){
                break;
            }
        }
        return queue.peek();
    }
    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if(!isReverse){
                    Node currentLevelNode = queue.pollFirst();
                    currentLevel.add(currentLevelNode.value);
                    if(currentLevelNode.left!=null){
                        queue.addLast(currentLevelNode.left);
                    }
                    if(currentLevelNode.right!=null){
                        queue.addLast(currentLevelNode.right);
                    }
                }else{
                    Node currentLevelNode = queue.pollLast();
                    currentLevel.add(currentLevelNode.value);
                    if(currentLevelNode.right!=null){
                        queue.addFirst(currentLevelNode.right);
                    }
                    if(currentLevelNode.left!=null){
                        queue.addFirst(currentLevelNode.left);
                    }
                }
            }
            isReverse = !isReverse;
            result.add(currentLevel);
        }
        return result;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(0,currentLevel);
        }
        return result;
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
