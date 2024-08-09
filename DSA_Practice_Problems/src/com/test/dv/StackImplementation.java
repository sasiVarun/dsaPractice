package com.test.dv;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class StackImplementation {
	
	private ListNode top;
	private int length;
	
	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public StackImplementation() {
		this.top = null;
		this.length = 0;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean isEmpty() {
		return this.length == 0;
	}
	
	public void push(int value) {
		ListNode node = new ListNode(value);
		
		node.next = top;
		top = node;
		length++;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public void display() {
		ListNode temp = top;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		StackImplementation stack = new StackImplementation();
		stack.push(5);
		stack.push(3);
		stack.push(10);
		stack.push(1);
		stack.push(21);
		stack.display();
		stack.pop();
		stack.pop();
		stack.display();
		System.out.println(stack.peek());
	}

}
