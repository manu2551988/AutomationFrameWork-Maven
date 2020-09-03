package com.scorpiontech.project.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.scopiontech.project.init.IAutoConstant;

public abstract class BaseLib implements IAutoConstant {

	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(EDGE_KEY, EDGE_VALUE);
	}

	public static int passCount = 0, failCount = 0;
	public static WebDriver driver;

	@BeforeClass
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

	@BeforeMethod
	public void openApplication() {
		driver.get(URL);
	}

	@AfterMethod
	public void logoutApplication(ITestResult res) {

		int status = res.getStatus();
		String methodName = res.getName();
		if (status == 1) {
			passCount++;
		} else {
			failCount++;
			String Photo_Path = resultscreenShotPath + methodName + ".png";
			GenericLib.takeScreenShotResult(driver, Photo_Path);
		}

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
