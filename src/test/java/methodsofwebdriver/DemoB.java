package methodsofwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoB {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		System.setProperty("webdriver.opera.driver","./driver/operadriver.exe");
		System.setProperty("webdriver.ie.driver","./driver/IEDriverServer.exe");
	}

	public static void main(String[] args) 
	{
		     WebDriver  driver =new ChromeDriver();
		     
		     driver.manage().window().maximize();
		     
		     driver.get("http://www.google.com");
		     
		     //get the current url in the browser and print it
		    String curl = driver.getCurrentUrl();
		    
		    System.out.println(curl);
		    
		    //get the title in the browser and print it
		    String cTitle = driver.getTitle();
		    System.out.println(cTitle);
		    
		    //get the sourcecode of the page nd print it
		    String psrc = driver.getPageSource();
		    System.out.println(psrc);
	

	}

}
