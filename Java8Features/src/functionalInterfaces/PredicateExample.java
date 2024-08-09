package functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {
//		Predicate<Integer> predicate = (i) -> {return i%2 == 0;};
	static Predicate<Integer> p1 = (i) -> i % 2 == 0; // If single line statement can be re-writen like this without return keyword
	static Predicate<Integer> p2 = (i) -> i % 5 == 0;
	public static void main(String[] args) {

		System.out.println(p1.test(5));
		predicateAnd();
		predicateOr();
		predicateNegate();
	}
	
	public static void predicateAnd() {
		System.out.println("predicateAnd result is: " +p1.and(p2).test(10)); // predicate-chaining
		System.out.println("predicateAnd result is: " +p1.and(p2).test(8)); // predicate-chaining
	}
	
	public static void predicateOr() {
		System.out.println("preicateOr result is: " + p1.or(p2).test(4));
		System.out.println("preicateOr result is: " + p1.or(p2).test(7));
	}
	
	public static void predicateNegate() {
		System.out.println("predicateNegate result is: " + p1.negate().test(6));
		System.out.println("predicateNegate result is: " + p2.negate().test(3));
		
		System.out.println("predicateNegate result is: " + p1.or(p2).negate().test(4));
		System.out.println("predicateNegate result is: " + p1.or(p2).negate().test(7));
	}

}
