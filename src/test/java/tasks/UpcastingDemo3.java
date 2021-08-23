package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class UpcastingDemo3 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	/**
	 * This method is useful for find the title
	 * @param driver
	 */
	public static void testBrowser(WebDriver driver)
	{
        driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		
		String titleGB = driver.getTitle();
		System.out.println(titleGB);
		driver.close();
		
		
	}
	
	

	public static void main(String[] args)
	{
		
		ChromeDriver driver = new ChromeDriver();
		
		testBrowser(driver);	
		
		FirefoxDriver driver1 = new FirefoxDriver();
		testBrowser(driver1);
      
		OperaDriver driver2 = new OperaDriver();
		testBrowser(driver2);
		
		InternetExplorerDriver driver3 =new InternetExplorerDriver();
		testBrowser(driver3);
		
		

	}

}
