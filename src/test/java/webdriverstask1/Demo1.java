package webdriverstask1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
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
		   driver.get("http://wwwgoogle.com");
		   
		   //get the title and print it
		   String title = driver.getTitle();
		   System.out.println(title);
		   
		   //get the current URL and print it
		  String curl = driver.getCurrentUrl();
		  System.out.println(curl);
		  
		  //get the source code of the application
//		  String psrc = driver.getPageSource();
//		  System.out.println(psrc);
		  
		  
		   
		

	}

}
