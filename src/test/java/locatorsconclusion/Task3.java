package locatorsconclusion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Sunil/Desktop/exampl.html");
		
		
		WebElement unTB1 = driver.findElement(By.xpath("//input[@value='A']"));
		unTB1.clear();
		unTB1.sendKeys("Tanu");
		
		WebElement pwTB1 = driver.findElement(By.xpath("//input[@value='B']"));
		pwTB1.clear();
		pwTB1.sendKeys("Architha");
		
		WebElement unTB2 = driver.findElement(By.xpath("//input[@value='C']"));
		unTB2.clear();
		unTB2.sendKeys("Niveditha");
		
		WebElement pwTB2 = driver.findElement(By.xpath("//input[@value='D']"));
		pwTB2.clear();
		pwTB2.sendKeys("Ramya");
		
		
		
		
		
		
		

	}

}
