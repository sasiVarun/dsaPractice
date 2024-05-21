package com.test.kk.fileHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream_FIS {
	public static void main(String[] args) {
		try(InputStream input = new FileInputStream("./src/input.txt")){
			// Mentioning how many bytes of data to be read
			byte[] array = new byte[10];
			
			//Before reading printing how many bytes data present
			System.out.println("available: " + input.available());
			
			//reading from input stream -> will read data of bytes[] size
			int re = input.read(array);
			System.out.println("re: " + re);
			
			// After reading there will be decrease in size of input stream.
			System.out.println("available: " + input.available());
			
			// Converting byte array to String
			String data = new String(array);
			System.out.println("Data from file: "+ data);
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
