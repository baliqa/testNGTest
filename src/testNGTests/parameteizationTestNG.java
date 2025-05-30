package testNGTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameteizationTestNG {

	 @Parameters("URL")	
	    @Test
	    public void param(String uname) {
	    	
	    	System.out.println(uname);
	    	
	
}
	 @Test(dataProvider="getData")
	 public void dtprovider(String username, String password) {
		 System.out.println(username);
		 System.out.println(password);
		
	 }
	 @DataProvider
	 public Object[][] getData() {
		 
		 Object[][] data= new Object[3][2];
		 
		 //1st Set
		 data[0][0] = "firstUsername";
		 data[0][1] = "firstPassword";
		 
		 //2nd Set
		 data[1][0] = "secondUsername";
		 data[1][1] = "secondPassword";
		 
		 //3rd Set
		 data[2][0] = "thirdUsername";
		 data[2][1] = "thirdPassword";
		 return data;
		 
	 }
	 
	 
}