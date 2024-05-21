package com.test.kk.linkedList;

public class SinglyLinkedList {
    private Node head;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = sll.new Node(8);
        Node second = sll.new Node(1);
        Node third = sll.new Node(10);
        sll.head.next = second;
        second.next = third;
    }
}
