package testNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotationExmple {
	String baseURL = "https://rahulshettyacademy.com/angularpractice/";
	WebDriver driver;
	String driverPath = "C:\\Users\\belaiti\\Documents\\Personal\\Job Related\\Selenium Training\\Environment\\chromedriver-win64\\chromedriver.exe";


@BeforeTest
public void launchBrowser() {
	System.out.println("Browser is launcing");
	driver = new ChromeDriver();

	driver.get(baseURL);
	
}
@Test
public void getTitle() {
	String expectedTitle = "ProtoCommerce";
	String actualTitle = driver.getTitle();
	System.out.println(actualTitle);
	Assert.assertEquals(actualTitle, expectedTitle);
	
}
@AfterTest
public void closebrowser() {
	driver.quit();
}
}