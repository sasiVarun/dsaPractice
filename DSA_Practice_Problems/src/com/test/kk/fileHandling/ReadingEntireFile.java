package com.test.kk.fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadingEntireFile {
	public static void main(String[] args) {
		try(BufferedReader bf = new BufferedReader(new FileReader("./src/input.txt"))){
			String line;
			
			while((line = bf.readLine()) != null) {
				System.out.println(line);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
