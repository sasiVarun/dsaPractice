package com.test.dv;

import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		String input = "{[()]}";
		boolean isBalanced = isValid(input);
		System.out.println("Brackets are balanced: " + isBalanced);
	}
	
	public static boolean isValid(String input) {
		Stack<Character> stack = new Stack<>();
		for (char character : input.toCharArray()) {
			if (character == '{' || character == '[' || character == '(') {
				stack.push(character);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char top = stack.peek();
					if (character == '}' && top == '{' || character == ']' && top == '['
							|| character == ')' && top == '(') {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		
		return stack.isEmpty();
	}

}
