package com.test.kk.linkedList;

public class DLL {
    private Node head;

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.previous = null;
        if(head !=null){
            head.previous = node;
        }
        head = node;
    }

    public void insertLast(int value){
        Node node = new Node(value);
        Node last = head;
        node.next = null;
        if(last == null){
            node.previous = null;
            head = node;
            return;
        }
        while(last.next !=null){
            last = last.next;
        }
        last.next = node;
        node.previous = last;
    }

    public void display(){
        Node node =head;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }
}
