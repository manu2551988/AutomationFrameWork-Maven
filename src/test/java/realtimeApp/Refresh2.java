package realtimeApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Refresh2 {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args)  {
				
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("incognito");
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://localhost/login.do");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement login = driver.findElement(By.xpath("//div[.='Login ']"));
		login.click();
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("manager");
		login.click();
		
	

	}

}
