package com.test.kk.fileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialization {
	public static void main(String[] args) {
		try {
			FileOutputStream file = new FileOutputStream("./src/serialize.txt");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			
			Dog dog = new Dog("Snoopy","Pomerian");
			
			obj.writeObject(dog);
			
			ObjectInputStream obj1 = new ObjectInputStream(new FileInputStream("./src/serialize.txt"));
			
			Dog dog1 = (Dog) obj1.readObject();
			System.out.println(dog1.getName());
			System.out.println(dog1.getBreed());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

class Dog implements Serializable{
	private String name;
	private String breed;
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getBreed() {
		return this.breed;
	}
	
}