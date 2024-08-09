package functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import data.Student;
import data.StudentDataBase;

public class BiConsumerExample {
	
	public static void main(String[] args) {
		BiConsumer<String,String> biConsumer = (a,b) -> System.out.println("a: " + a + ", b: " + b);
		biConsumer.accept("java7", "java8");
		
		BiConsumer<Integer,Integer> multiply = (a,b) -> System.out.println("Multiplication is: " + a*b);
		
		
		BiConsumer<Integer,Integer> division = (a,b) -> System.out.println("Division is: " + a/b);
		
		multiply.andThen(division).accept(10, 5);
		
		nameAndActivities();
	}
	
	public static void nameAndActivities() {
		System.out.println("-----------From nameAndActivities----------");
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);
		
		List<Student> studentsList = StudentDataBase.getAllStudents();
		
		studentsList.forEach((student) -> biConsumer.accept(student.getName(), student.getActivities()));
		
		/**
		 * forEach() parameter is Consumer type. So passing Lambda expression
		 * Inside Lambda expression calling BiConsumer, since I am calling BiConsumer need to call accept()
		 */
	}

}
