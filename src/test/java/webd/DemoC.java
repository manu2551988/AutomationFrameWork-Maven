package webd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoC {
	static
	{
	         System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	         System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		
		
		   ChromeDriver driver = new ChromeDriver();
		    
		   driver.manage().window().maximize();
		   
		   driver.get("http://www.google.com");
		     
		   String gpTitle = driver.getTitle();
		   System.out.println(gpTitle);
		   
		   driver.close();
		   
		   System.out.println("==========================================");
		   
		 FirefoxDriver driver1 = new FirefoxDriver();
		 
		 
		   driver1.manage().window().maximize();
		   
		   driver1.get("http://www.google.com");
		     
		   String gpTitle1 = driver1.getTitle();
		   System.out.println(gpTitle);
		   
		   driver1.close();
		   
	

	}

}
