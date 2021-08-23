package methodsofwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoC {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		
	}

	public static void main(String[] args) 
	{
		     WebDriver  driver =new ChromeDriver();
		     
		    System.out.println(driver);
		    System.out.println("------------------------------------------------------------------------------------");
		    String windosessionID = driver.getWindowHandle();
		    System.out.println(windosessionID);
		     
		    

	}

}
