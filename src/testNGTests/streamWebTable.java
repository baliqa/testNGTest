package testNGTests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streamWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\belaiti\\Documents\\Personal\\Job Related\\Selenium Training\\Environment\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
		
		//click on column
		//capture all webelements into a list
		//capture texts of all webelements into a new original list
		//sort the list
		//compare sorted list with original list
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> vegName = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> orginalList = vegName.stream().map(a->a.getText())
        		.collect(Collectors.toList());
        List<String> sortedList = orginalList.stream().sorted()
        		.collect(Collectors.toList());
		Assert.assertTrue(orginalList.equals(sortedList));
		
		//get the price for an item
		
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Cherry"))
					.map(s->getPrice(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			
				
			}
		}while(price.size()<1);
		
		driver.quit();
		
	}
	

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
