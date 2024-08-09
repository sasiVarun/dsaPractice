package functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDataBase;

public class ConsumerExample {
	static Consumer<Student> c2 = (student) -> System.out.println(student);
	static Consumer<Student> c3 = (student) -> System.out.print(student.getName() + " : ");
	static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

	public static void main(String[] args) {
		Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

//		c1.accept("java8");
//		printName();
//		printNameAndActivities();
		printNameAndActivitiesUsingCondition();
	}

	public static void printName() {

		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(c2);
	}

	public static void printNameAndActivities() {

		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(c3.andThen(c4)); // consumer chaining
	}

	public static void printNameAndActivitiesUsingCondition() {

		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(((student) -> {
			if (student.getGradeLevel() >= 3) {
				c3.andThen(c4).accept(student);
			}
		}));
		
		/**
		 * Lambda in forEach is logic of Consumer interface. So accept() method will be called internally in forEach()
		 * c3, c4 are Consumer interfaces. In order to print values we need to call accept()   
		 */
	}
}
