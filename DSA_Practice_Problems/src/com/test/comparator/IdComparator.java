package com.test.comparator;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e2.getId() - e1.getId();
	}
	

}
