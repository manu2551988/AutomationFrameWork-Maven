package com.tyss.project.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tyss.project.init.IAutoConstant;



abstract public class BrowserMulti implements IAutoConstant {

	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(EDGE_KEY, EDGE_VALUE);
	}
	
//	Browser Setup in order to launching any browser as per requirement
//	Author Manu Kakkar
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void browserSetup(String sbrowser,String url) {
		
		if (sbrowser.equals("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("incognito");
			options.addArguments("start-maximized");			
			driver=new ChromeDriver(options);
		}
		else if (sbrowser.equals("firefox")) {
			
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			options.addPreference("browser.privatebrowsing.autostart",true);
			driver=new FirefoxDriver();			
		}
		
		else if (sbrowser.equals("edge")) 
		{
			EdgeOptions options=new EdgeOptions();
			driver=new EdgeDriver(options);			
		}
		
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PTO, TimeUnit.SECONDS);
		driver.get(url);
	}

	
	@AfterMethod
	public void shutDown() {
		driver.close();
		
		//driver.quit();
	}
	 
}
