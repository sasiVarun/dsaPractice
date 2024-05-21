package com.test.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseStringBetweenNumbers {

	public static void main(String[] args) {
		 String input = "123test456epam";
	        List<String> segments = splitStringUsingRegex(input);
//	        StringBuilder result = new StringBuilder();
//	        segments.forEach((segment) -> result.append(segment));
//	        System.out.println(result);
	        String result = segments.stream().map(String::toString).collect(Collectors.joining(""));
	        System.out.println(result);
	}

	 public static List<String> splitStringUsingRegex(String input) {
	        List<String> segments = new ArrayList<>();
	        Pattern pattern = Pattern.compile("\\d+|[a-zA-Z]+");
	        Matcher matcher = pattern.matcher(input);

	        while (matcher.find()) {
	        	String data = matcher.group(); 
	        	if(data.matches(".*[a-zA-Z]")) {
	        		segments.add(new StringBuilder(data).reverse().toString());
	        	}else {
	        		segments.add(data);
	        	}
	        }
	        
	        return segments;
	    }
}
