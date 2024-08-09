package test;

public class ChildClass extends ParentClass {

	public static int b;
	public static void m2() {
		System.out.println("=== Child Class ===");
		System.out.println("The value of b:" +b);		
	}
	
	static {
		System.out.println("Child Class Static block...");
	}

}
