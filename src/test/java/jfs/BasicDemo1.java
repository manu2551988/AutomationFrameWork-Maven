package jfs;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicDemo1 {
	
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) 
	{
		//Open The Browser
	FirefoxDriver driver = new FirefoxDriver();
		

          //Options m = driver.manage();
         //Window w = m.window();
         //w.maximize();

        //Optimization we use method chaining
         driver.manage().window().maximize();

         driver.get("http://www.google.com");    
		

	}

}
