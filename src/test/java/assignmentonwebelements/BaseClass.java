package assignmentonwebelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * 
 * @author Sunil
 *
 */
public class BaseClass 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");	
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		System.setProperty("webdriver.ie.driver","./driver/internetexplorerserverdriver.exe");
	}
	
	public static WebDriver driver; 
	/**
	 * This Method is used to Open The Browser.
	 * @param sBrowserName
	 */
	public static void openBrowser(String sBrowserName , String url)
	{
		if(sBrowserName.equals("chrome"))
		{
		    driver= new ChromeDriver();
		   
		}
		else if(sBrowserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(sBrowserName.equals("ie"))
		{
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		
		driver.get(url);
		
	}

}
