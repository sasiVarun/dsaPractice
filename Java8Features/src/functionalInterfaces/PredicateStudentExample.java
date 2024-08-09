package functionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import data.Student;
import data.StudentDataBase;

public class PredicateStudentExample {
	static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
	
	static Predicate<Student> p2 = (student) -> student.getGpa() >= 3.9;
			
	public static void main(String[] args) {
		filterStudentByGradeLevel();
		filterStudentByGpa();
		filterStudents();
	}
	
	/*
	 * Trying to replicate printNameAndActivitiesUsingCondition() method from ConsumerExample class
	 */
	
	public static void filterStudentByGradeLevel() {
		System.out.println("------------filterStudentByGradeLevel----------------");
		List<Student> studentsList = StudentDataBase.getAllStudents();
		
		studentsList.forEach((student) -> {
			
			if(p1.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	public static void filterStudentByGpa() {
		System.out.println("------------filterStudentByGpa----------------");
		List<Student> studentsList = StudentDataBase.getAllStudents();
		
		studentsList.forEach((student) -> {
			
			if(p2.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	public static void filterStudents() {
		System.out.println("------------filterStudents----------------");
		List<Student> studentsList = StudentDataBase.getAllStudents();
		
		studentsList.forEach((student) -> {
			if(p1.and(p2).test(student)) {
				System.out.println(student);
			}
		});
	}

}
