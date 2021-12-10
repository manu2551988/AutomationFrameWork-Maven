package jfs;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicDemo {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args)
	{
		//Open The Browser
		ChromeDriver driver = new ChromeDriver();


//Options m = driver.manage();
//Window w = m.window();
//w.maximize();

//Optimization we use method chaining

       driver.get("http://www.google.com");


	}

}
