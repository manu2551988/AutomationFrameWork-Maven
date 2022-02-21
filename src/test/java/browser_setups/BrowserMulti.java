package browser_setups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserMulti {

    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");

    }

//	Browser Setup in order to launching any browser as per requirement
//	Author Manu Kakkar
	
	public static WebDriver driver;
	
	//@BeforeMethod
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
	}

	
	//@AfterMethod
	public void shutDown() {
		//driver.close();
		//Thread.sleep(2000);
		driver.quit();
	}
	 
}
