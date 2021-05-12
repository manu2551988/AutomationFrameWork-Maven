package launchbrowser;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefoxBrowser {
	
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args)
	{
//		String key="webdriver.gecko.driver";
//		String value="./driver/geckodriver.exe";
//		System.setProperty(key, value);
		
//		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		new FirefoxDriver();

	}

}
