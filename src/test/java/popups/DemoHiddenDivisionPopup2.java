package popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoHiddenDivisionPopup2 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://irctc.co.in");
		
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		driver.findElement(By.id("loginText")).click();
		
		driver.findElement(By.xpath("//a[contains(@class,'fa-window-close')]")).click();
		

	}

}
