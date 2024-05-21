package com.test.comparator;

import java.util.Arrays;

import com.test.arrays.NthMaxElement;

public class Test {

	public static void main(String[] args) {
		
		Employee[] employees = new Employee[4];
		employees[0] = (new Employee(101, "Sanjay"));
		employees[1] = (new Employee(102,"Krishna"));
		employees[2] = (new Employee(103,"David"));
		employees[3] = (new Employee(104,"Ajay"));
		
		//Employees sorting using Comparable printing in ascending order
		Arrays.sort(employees);
		System.out.println(Arrays.toString(employees));
		
		//Employees sorting using Comparator printing in descending order
		Arrays.sort(employees, new IdComparator());
		System.out.println(Arrays.toString(employees));
		
		//Employees sorting using Comparator printing in ascending order using Names
		Arrays.sort(employees,Employee.NameComparator);
		System.out.println(Arrays.toString(employees));
		
		//Picking nth max employee
		Employee emp = NthMaxElement.findNthmax(employees, 2);
		System.out.println(emp);
	}

}
