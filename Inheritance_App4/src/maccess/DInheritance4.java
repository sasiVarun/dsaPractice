package maccess;

import test.*;

public class DInheritance4 {

	public static void main(String[] args) {
		ChildClass ob = new ChildClass();
		
		  ChildClass.a = 12; 
		  ChildClass.b = 13; 
		  ChildClass.m1(); 
		  ChildClass.m2();
		 
		/*
		 * ob.a = 12; ob.b = 13; ob.m1(); ob.m2();
		 */

	}

}
