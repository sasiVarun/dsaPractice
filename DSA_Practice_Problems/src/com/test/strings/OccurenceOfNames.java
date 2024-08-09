package com.test.strings;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OccurenceOfNames {
	
	public static void main(String[] args) {
		List<String> names = List.of("Ajay","Mukesh","Mayur","David","Mukesh","Mahesh");
		
		Map<String, Integer> occurence = new LinkedHashMap<>();
		
		for(String name: names) {
			if(name.toUpperCase().startsWith("M")) {
				if(occurence.containsKey(name)) {
					int count = occurence.get(name);
					occurence.put(name, count + 1);
				}else {
					occurence.put(name, 1);
				}
			}
		}
		
		occurence.forEach((key,value) -> {
			System.out.println(key + " - " + value);
		});
	}

}
