package basicslocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoaA {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
		

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("file:///C:/Users/Sunil/Desktop/web.html");
		
//		String tagname = "a";
//		By by = By.tagName(tagname);
//		WebElement linktext = driver.findElement(by);
//		linktext.click();
		
//		WebElement linktext = driver.findElement(By.tagName("a"));
//		linktext.click();
		
//		WebElement linktext = driver.findElement(By.id("a1"));
//		linktext.click();
		
//		WebElement linktext = driver.findElement(By.name("n1"));
//		linktext.click();
		
//		WebElement linktext = driver.findElement(By.className("c1"));
//		linktext.click();
		
//		WebElement linktext = driver.findElement(By.linkText("Qspiders"));
//		linktext.click();
		
//		WebElement linktext = driver.findElement(By.partialLinkText("Qsp"));
//		linktext.click();
		
//		driver.findElement(By.cssSelector("a[href='http://www.qspiders.com']")).click();
	     
		driver.findElement(By.xpath("./html/body/a")).click();
	
	
	
	}



}
