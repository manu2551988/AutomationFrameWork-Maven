package frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFrmae2 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("file:///C:/Users/Sunil/Desktop/pg1.html");
		
		WebElement unTB = driver.findElement(By.id("t1"));
		unTB.sendKeys("Bhanu");
		
		WebElement frame = driver.findElement(By.id("f1"));
		
		//We switch into frame Window By Using Frame Index
         driver.switchTo().frame(0);
		
		WebElement pwTB = driver.findElement(By.id("p1"));
		pwTB.sendKeys("Prakash");
		
		//Switch out of the frame window by using parentframe()
		driver.switchTo().parentFrame();
		unTB.clear();
		unTB.sendKeys("Sunil");
		
		//We switch into frame Window By Using String
		driver.switchTo().frame("f1");
		pwTB.clear();
		pwTB.sendKeys("R Gowda");
		
		//Switch out of the frame window by using defaultcontent()
		driver.switchTo().defaultContent();
		unTB.clear();
		
		//We switch into frame Window By Using WebElement Refernce
		driver.switchTo().frame(frame);
		pwTB.clear();
		
		
		
		
	}

}
