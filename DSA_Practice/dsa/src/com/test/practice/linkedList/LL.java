package com.test.practice.linkedList;

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

        public Node(){
            this.value = 0;
            this.next = null;
        }
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void display(Node node){
            Node temp = node;
            while(temp!=null){
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
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

    public int deleteFirst() {
        Node node = head;
        int value = node.value;
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
        Node previous = get(size - 2);
        int value = previous.next.value;
        tail = previous;
        tail.next = null;
        size--;
        return value;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node previous = get(index - 1);
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

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public void removeDuplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public Node merge(Node first, Node second){
        Node f = first;
        Node s = second;
        Node dummy = new Node();
        Node ans = dummy;
        while(f.next != null && s.next !=null){
            if(f.value < s.value){
                ans.next = f;
                f = f.next;
                ans = ans.next;
            }else{
                ans.next = s;
                s = s.next;
                ans = ans.next;
            }
        }
        while(f.next != null){
            ans.next = f;
            f = f.next;
        }
        while(s.next !=null){
            ans.next = s;
            s = s.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        LL li = new LL();
//        li.insertLast(1);
//        li.insertLast(1);
//        li.insertLast(2);
//        li.insertLast(3);
//        li.insertLast(3);
//        li.display();
//        li.removeDuplicates();
//        li.display();

        LL l1 = new LL();
        l1.insertLast(1);
        l1.insertLast(3);
        l1.insertLast(5);
        LL l2 = new LL();
        l2.insertLast(2);
        l2.insertLast(4);
        l2.insertLast(6);

        LL temp = new LL();
        Node ans = temp.merge(l1.head,l2.head);
        ans.display(ans);

    }
}
