package com.test.kk.fileHandling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStream_FOS {

	public static void main(String[] args) {
		try (OutputStream output = new FileOutputStream("./src/output.txt")) {
			// Data to be written into file
			String data = "Write this line into the output file";

			// Converting String data to byte[] format
			byte[] array = data.getBytes();

			// Using write method writing data to file
			output.write(array);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
