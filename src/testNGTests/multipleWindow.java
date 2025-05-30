package testNGTests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class multipleWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\belaiti\\Documents\\Personal\\Job Related\\Selenium Training\\Environment\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);

		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver
				.findElements(By.xpath("//div[@id='courses-block']//h2//a")).get(1).getText();
		// (By.xpath("//a[contains(text(), 'All-Access Membership')]")).getText();
		System.out.println(courseName);

		driver.switchTo().window(parent);
		WebElement editBox = driver.findElement(By.tagName("label"));
		driver.findElement(
				RelativeLocator.with(By.xpath("//div[@class='form-group']//input[@name='name']")).below(editBox))
				.sendKeys(courseName);
		
		//take a screenshot of the name editbox (not a full window screenshot)
		
		File file = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"))
		.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("sh.png"));
		
		//get height and width of an element
		
		WebElement hw = driver.findElement
				(By.xpath("//div[@class='form-group']//input[@name='name']"));
		System.out.println(hw.getRect().getDimension().getHeight());
		System.out.println(hw.getRect().getDimension().getWidth());
		driver.quit();

	}

}
