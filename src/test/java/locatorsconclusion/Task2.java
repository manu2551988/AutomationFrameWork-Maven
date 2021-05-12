package locatorsconclusion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Sunil/Desktop/exampl.html");
		
		
		WebElement unTB1 = driver.findElement(By.xpath("//div[1]/input[1]"));
		unTB1.sendKeys("Tanu");
		
		WebElement pwTB1 = driver.findElement(By.xpath("//div[1]/input[2]"));
		pwTB1.sendKeys("Architha");
		
		WebElement unTB2 = driver.findElement(By.xpath("//div[2]/input[1]"));
		unTB2.sendKeys("Niveditha");
		
		WebElement pwTB2 = driver.findElement(By.xpath("//div[2]/input[2]"));
		pwTB2.sendKeys("Ramya");
		
		
		
		
		
		
		

	}

}
