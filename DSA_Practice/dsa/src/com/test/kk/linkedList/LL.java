package com.test.kk.linkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int value) {

        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
//        int index = this.get();
        Node secondLast = this.get(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
//        for (int i = 0; i < index-2; i++) {
//            temp = temp.next;
//        }
//
//        int value = temp.next.value;
//        tail = temp;
//        temp.next = null;
//        size--;
        return value;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node previous = this.get(index - 1);
        int value = previous.next.value;
        previous.next = previous.next.next;
        size--;
        return value;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void insertRecursion(int value, int index) {
        head = insertRecursion(value, index, head);
    }

    private Node insertRecursion(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertRecursion(value, index - 1, node.next);
        return node;
    }

    public void removeDuplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
            size++;
        }

        while (f != null) {
            ans.insertLast(f.value);
            size++;
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            size++;
            s = s.next;
        }
        return ans;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            // Checking values to swap
            if (first.value > second.value) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node previous = get(col - 1);
                    previous.next = second;
                    tail = first;
                    first.next = null;
                    second.next = first;
                } else {
                    Node previous = get(col - 1);
                    previous.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // recursion Reverse
    public void reverseRecursion(Node node) {
        if (node == tail) {
            head = node;
            return;
        }

        reverseRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    // https://leetcode.com/problems/reverse-linked-list/description/
    public void reverse(Node node) {
        if(node == null && size < 2){
            return;
        }
        Node previous = null;
        Node present = node;
        Node next = present.next;

        while (present != null) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = previous;
    }


    public static void main(String[] args) {
//        LL first = new LL();
//        LL second = new LL();
//        LL mergeList = new LL();
//
//        first.insertLast(1);
//        first.insertLast(3);
//        first.insertLast(5);
//
//        second.insertLast(1);
//        second.insertLast(2);
//        second.insertLast(9);
//        second.insertLast(15);
//
//        LL ans = mergeList.merge(first, second);
//        ans.display();

        LL list = new LL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i);
        }
//        list.display();
//        list.bubbleSort();
//        list.display();

        list.display();
//        list.reverseRecursion(list.head);
        list.reverse(list.head);
        list.display();
    }
}
