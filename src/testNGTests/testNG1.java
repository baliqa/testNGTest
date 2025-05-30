package testNGTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class testNG1 {

    @Test(groups="Smoke", enabled=false)
	public void demo1() {
		
		System.out.println("this is smoke test cases");
		
	}
    
    @BeforeTest
    public void demo2() {
    	
    	System.out.println("This should be executed first in testNG1");
    }
    @Parameters("URL")	
    @Test
    public void demo3(String urlname) {
    	
    	System.out.println("helllllooooooooooooooooooo");
    	System.out.println(urlname);
    }
    
   
	

}
