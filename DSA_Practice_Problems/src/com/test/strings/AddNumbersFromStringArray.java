package com.test.strings;

public class AddNumbersFromStringArray {
	
	public static void main(String[] args) {
		String[] list = {"7as9","8r9t","yz99"};
		int result = 0; 
		for (String ele : list) {
			String data = ele.replaceAll("[^0-9]", ""); // replaces digits with empty
//			String data = ele.replaceAll("\\D", ""); // replaces digits with empty
			result+=Integer.valueOf(data);
		}
		System.out.println(result);
	}

}
