package com.tyss.project.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.tyss.project.init.IAutoConstant;
import com.tyss.project.init.IConstants;




abstract public class BaseTest implements IAutoConstant,IConstants
{
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	public static WebDriver driver;
	
	public static void openBrowser(String sBrowser)
	{
		
		if (sBrowser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("incognito");
			options.addArguments("start-maximized");			
			driver=new ChromeDriver(options);
		}
		
		else if (sBrowser.equalsIgnoreCase("firefox")) 
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			options.addPreference("browser.privatebrowsing.autostart",true);
			driver=new FirefoxDriver(options);			
		}
		
		else if (sBrowser.equalsIgnoreCase("edge")) 
		{
			EdgeOptions options=new EdgeOptions();
			driver=new EdgeDriver(options);			
		}
		
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}

}
