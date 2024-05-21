package com.test.comparator;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	
	private Integer id;
	private String name;
	
	public Employee(Integer id, String name) {
		this.id =id;
		this.name = name;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employee emp) {
		return this.id - emp.id;
	}
	
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};

}
