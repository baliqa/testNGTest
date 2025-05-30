package testNGTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;


public class testNG2 {

    @AfterTest
	public void demo4() {
		
		System.out.println("This should be executed LAST in testNG2");
		
	}
    
    @Test
    public void demo5() {
    	
    	System.out.println("hiiiii");
    }
    
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This should be executed before SUITE");
	}
	
    @BeforeTest
    public void demo6() {
    	
    	System.out.println("this sohuld be executed first in testNG2");
    }
	
    @BeforeMethod
    public void beforeMethod() {
    	
    	System.out.println("This should be executed before every method in testNG2");
    }
    @Test(enabled=false)
    public void demo7() {
    	
    	System.out.println("this is demo7");
    }
    
    @Test
    public void demo8() {
    	
    	System.out.println("this is demo 8");
    	Assert.assertTrue(false);
    }
    @Test(timeOut=1000)
    public void demo9() {
    	
    	System.out.println("this is demo9");
    }
    @AfterMethod
    public void afterMethod() {
    	System.out.println("this will run after each test method");
    }
    
    @Test(dependsOnMethods= {"demo7"},enabled=false)
    public void dependent() {
    	System.out.println("this method is dependent on demo1 method");
    }
}
