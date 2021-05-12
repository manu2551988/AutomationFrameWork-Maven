package tasksonwebapplication;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoBOpenAplication {
	
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args)
	{
		//open the browser
		FirefoxDriver driver = new FirefoxDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//enter the url
		driver.get("http://www.google.com");
		
		//get the title of the page in current browser
		
		String title = driver.getTitle();
		System.out.println(title);
		
		//close the current browser
		driver.close();
		
		

	}

}
