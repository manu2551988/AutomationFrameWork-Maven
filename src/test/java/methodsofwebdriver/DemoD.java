package methodsofwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoD {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		
	}

	public static void main(String[] args) 
	{
		     WebDriver  driver =new ChromeDriver();
		      driver.manage().window().maximize();
//		      driver.get("http://www.facebook.com");
//		      
//		      Navigation n = driver.navigate();
//		      n.to("http://www.yahoo.com");
//		      n.back();
//		      n.forward();
//		      n.refresh();
		      
		      //is it possible to open the application without using get() method
		      driver.navigate().to("http://www.yahoo.com");
		      driver.navigate().to("http://www.google.com");
		      driver.navigate().back();
		      driver.navigate().forward();
		      driver.navigate().refresh();
		      
		      driver.close();
		    
		     
		    

	}

}
