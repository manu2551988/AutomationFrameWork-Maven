package methodsofwebdriver;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoGetWindowhandles {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
	           WebDriver driver=new ChromeDriver();
	           driver.manage().window().maximize();
	           driver.get("http://www.naukri.com");
	          String pwidow = driver.getWindowHandle();
	          System.out.println(pwidow);
	         Set<String> windows = driver.getWindowHandles();
	         int count = windows.size();
	         System.out.println(count);
	         System.out.println(windows);
	         
	          driver.quit();

	}

}
