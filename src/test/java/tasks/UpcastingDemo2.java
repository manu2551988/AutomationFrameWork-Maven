package tasks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpcastingDemo2 {
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
		
		String titleGB = driver.getTitle();
		System.out.println(titleGB);
		driver.close();
		
		
		
		FirefoxDriver driver1 = new FirefoxDriver();
		
        driver1.manage().window().maximize();
		
		driver1.get("http://www.google.com");
		
		String titleFB = driver1.getTitle();
		System.out.println(titleFB);
		driver1.close();
		
		

	}

}
