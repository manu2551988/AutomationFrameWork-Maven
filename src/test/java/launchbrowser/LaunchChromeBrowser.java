package launchbrowser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchChromeBrowser {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
//		String key="webdriver.chrome.driver";
//		String value="./driver/chromedriver.exe";
//		System.setProperty(key, value);
		
//		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		 ChromeDriver driver = new ChromeDriver();
		 SearchContext sc;
		 WebDriver wd;
		 TakesScreenshot ts;
		 JavascriptExecutor jse;
		 
		 RemoteWebDriver rd;
		 
		 
		 
		 
		 
		

	}

}
