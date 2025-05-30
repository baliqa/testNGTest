package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class relativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\belaiti\\Documents\\Personal\\Job Related\\Selenium Training\\Environment\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //above
        WebElement editBox = driver.findElement(By.cssSelector("[name='name']"));
       
        System.out.println(driver.findElement(RelativeLocator.with(By
        		.tagName("label")).above(editBox)).getText());
        //below
        WebElement findBelow = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(RelativeLocator.with(By.tagName("input"))
				.below(findBelow)).click();
		//toLeft
		WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(RelativeLocator.with(By.tagName("input"))
				.toLeftOf(checkBox)).click();
		
		//toRight
		WebElement toRight = driver.findElement(By.id("inlineRadio1"));
		driver.findElement(RelativeLocator.with(By.id("inlineRadio2"))
				.toRightOf(toRight)).click();
		

	}

}
