package lib;

import init.IAutoConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

abstract public class BrowserSimple implements IAutoConstant {

	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(EDGE_KEY, EDGE_VALUE);
	}

	public static int passCount = 0, failCount = 0;
	public static WebDriver driver;

	public void logoutApplication(ITestResult res) {

		int status = res.getStatus();
		String methodName = res.getName();
		if (status == 1) {
			passCount++;
		} else {
			failCount++;
			String Photo_Path = screenShotPath + methodName + ".png";
			ElementUtils.takeScreenShotResult(driver, Photo_Path);
		}

	}

//	public void openApplication() {
//		driver.get(URL);
//	}

	public void setUp() {
		String browser = CHROME;

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
		} else {
			Reporter.log("No Browser Configruation Found", true);
		}

		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PTO, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void tearDown() {
		driver.close();
	}

}
