package browser_setups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {

    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

    }

    public static WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("incognito");
		options.addArguments("start-maximized");			
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	
	@AfterMethod
	public void Shutdown() throws InterruptedException {
		//driver.close();
		Thread.sleep(3000);
		driver.quit();
	}
	 
}
