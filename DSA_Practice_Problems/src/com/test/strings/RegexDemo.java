package com.test.strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		boolean p = Pattern.matches("\\D", "a");
		System.out.println(p);
		
		Pattern pattern = Pattern.compile("[ayz]?");
		Matcher matcher = pattern.matcher("ay");
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
