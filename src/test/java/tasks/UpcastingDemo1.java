package tasks;

import org.openqa.selenium.firefox.FirefoxDriver;

public class UpcastingDemo1 {
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args)
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		

	}

}
