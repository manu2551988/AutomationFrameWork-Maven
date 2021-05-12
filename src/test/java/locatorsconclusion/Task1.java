package locatorsconclusion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Sunil/Desktop/exampl.html");
		WebElement un1TB = driver.findElement(By.tagName("input"));
		un1TB.clear();
		un1TB.sendKeys("Bhanu");
		
		WebElement pw1TB = driver.findElement(By.cssSelector("input[value='B']"));
		pw1TB.clear();
		pw1TB.sendKeys("Prakash");
		
		WebElement un2TB = driver.findElement(By.cssSelector("input[value='C']"));
        un2TB.clear();
        un2TB.sendKeys("Niveditha");
        
        WebElement pw2TB = driver.findElement(By.cssSelector("input[value='D']"));
        pw2TB.clear();
        pw2TB.sendKeys("Architha");
	}

}
