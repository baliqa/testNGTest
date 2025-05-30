package testNGTests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class stremFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\belaiti\\Documents\\Personal\\Job Related\\Selenium Training\\Environment\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("cherry");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> vegName = veggies.stream().map(v->v.getText())
        		.collect(Collectors.toList());
        System.out.println(vegName);
        List<WebElement> filteredVeg = veggies.stream().filter(veg->veg.getText()
        .contains("Cherry")).collect(Collectors.toList());
      
        Assert.assertEquals(veggies.size(), filteredVeg.size());
		driver.close();
	}

}
