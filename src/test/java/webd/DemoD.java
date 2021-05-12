package webd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoD {
	static
	{
	         System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	         System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	
	public static void testBrowser(ChromeDriver driver)
	{
		driver.manage().window().maximize();
		   
		   driver.get("http://www.google.com");
		     
		   String gpTitle = driver.getTitle();
		   System.out.println(gpTitle);
		   
		   driver.close();
		
	}
	
	public static void testBrowser(FirefoxDriver driver)
	{
		driver.manage().window().maximize();
		   
		   driver.get("http://www.google.com");
		     
		   String gpTitle = driver.getTitle();
		   System.out.println(gpTitle);
		   
		   driver.close();
	}
	
	
	
	
	public static void main(String[] args)
	{
		
		
		   ChromeDriver driver = new ChromeDriver();
		    testBrowser(driver);
		   
		   
		   System.out.println("==========================================");
		   
		 FirefoxDriver driver1 = new FirefoxDriver();
		 
		 
		 testBrowser(driver1);
		   
	

	}

}
