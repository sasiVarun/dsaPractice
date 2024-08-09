package test;

public class ParentClass {
	public static int a;

	public static void m1() {
		System.out.println("=== Parent Class ===");
		System.out.println("The value a: " + a);
	}

	static {
		System.out.println("Parent Class Static Block...");
	}

}
