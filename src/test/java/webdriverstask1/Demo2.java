package webdriverstask1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) 
	{
		   //open the browser
		   WebDriver driver = new ChromeDriver();
		   
		   //Maximize the browser
		   driver.manage().window().maximize();
		   
		   //Enter the URL
		   driver.get("http://www.google.com");
		   
		   //navigate from google to facebook
		   
		   Navigation n = driver.navigate();
		   n.to("http://www.facebook.com");
		   n.back();
		   n.forward();
		   n.refresh();
		   
		   
		   driver.close();
		   
		   
		  
		  
		   
		

	}

}
