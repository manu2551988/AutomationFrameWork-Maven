package tasksonwebapplication;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoAOpenApplication {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args)
	{
		//open the browser
		RemoteWebDriver driver = new ChromeDriver();
		
//		Options m = driver.manage();
//		Window w = m.window();
//		w.maximize();		
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//Enter the url
		driver.get("http://www.google.com");
		
		//get the title of application in the browser and print it
		String title = driver.getTitle();
		System.out.println("The current page Title:->"+title);
		
		
		//close the current browser
		driver.close();

	}

}
