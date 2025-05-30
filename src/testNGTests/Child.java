package testNGTests;

import org.testng.annotations.Test;

public class Child extends Parent {
	
	@Test
	public void childMethod() {
		
		Child2 inc= new Child2(3);
		int a =3;
		
		
		callingParentMethod();
		
		System.out.println(inc.increment());
		System.out.println(inc.decrement());
		
		
		
		System.out.println(inc.multiply());
	}

}
