package methodsofwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWindoHandle {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args)
	{
		
		WebDriver driver =new ChromeDriver();
		System.out.println(driver);
		System.out.println("----------------------------------");
		String cwind = driver.getWindowHandle();
		System.out.println(cwind);
		

	}

}
