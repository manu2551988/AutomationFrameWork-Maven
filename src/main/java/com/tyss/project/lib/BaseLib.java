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


public class BaseLib {
	
	static
	{
		System.setProperty(GenericLib.getPropData("BrowserKey"), GenericLib.getPropData("BrowserPath"));
	}
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		String browser = GenericLib.getPropData("BrowserName");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);	
			driver = new FirefoxDriver(options);
		}
		if (browser.equalsIgnoreCase("edge")) 
		{
			EdgeOptions options=new EdgeOptions();
			driver=new EdgeDriver(options);			
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get(GenericLib.getPropData("url"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
