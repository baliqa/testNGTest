package testNGTests;

public class Child2 extends Child3 {
	
	int a;
	
	public Child2(int a) {
		
		super(a);//activates child3
		this.a = a;
		
	}

	public int increment() {
		
		a = a+1;
		return a;
		
	}
	
	public int decrement() {
		
		a= a-1;
		return a;
	}

}
