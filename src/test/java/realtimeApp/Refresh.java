package realtimeApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Refresh {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	private static WebElement username;

	public static void main(String[] args) {
				
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("incognito");
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://localhost/login.do");

		username= driver.findElement(By.id("username"));
		driver.navigate().refresh();
		username.sendKeys("admin");
		
	

	}

}
