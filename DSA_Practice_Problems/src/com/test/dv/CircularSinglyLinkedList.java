package com.test.dv;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
	
	private ListNode last;
	private int length;
	
	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularSinglyLinkedList() {
		this.last = null;
		this.length = 0;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean isEmpty() {
		return this.length == 0;
	}
	
	public void createCircularLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(20);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		last = fourth;
	}
	
	public void display() {
		if(last==null) {
			return;
		}
		
		ListNode first = last.next;
		
		while(first!=last) {
			System.out.print(first.data + " ");
			first=first.next;
		}
		System.out.print(first.data);
		System.out.println();
	}
	
	public void insertFirst(int input) {
		ListNode temp = new ListNode(input);
		if(last == null) {
			last = temp;
		}else {
			temp.next = last.next;
		}
		
		last.next = temp;
		length++;
	}
	
	public void insertLast(int input) {
		ListNode temp = new ListNode(input);
		
		if(last == null) {
			last = temp;
			last.next = last;
		}else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}
	
	public int removeFirst() {
		int data;
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = last.next;
		if(last.next == last) {
			data = last.data;
			last = null;
		}else {
			data = temp.data;
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return data;
	}
	
	public static void main(String[] args) {
		CircularSinglyLinkedList csl = new CircularSinglyLinkedList();
//		csl.createCircularLinkedList();
//		csl.display();
		csl.insertFirst(21);
		csl.insertFirst(28);
		csl.insertFirst(34);
		csl.insertFirst(55);
//		csl.insertLast(2);
//		csl.insertLast(96);
//		csl.insertLast(21);
		csl.display();
		int removed = csl.removeFirst();
		System.out.println("Removed: " + removed);
		csl.display();
	}

}
