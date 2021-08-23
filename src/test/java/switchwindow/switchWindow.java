package switchwindow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.scorpiontech.project.init.IAutoConstant;

public class switchWindow implements IAutoConstant{
	
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("incognito");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");
		System.out.println("I am Amazon Homepage");
		System.out.println("The title of this window is-->"+driver.getTitle());		
		String currentID = driver.getWindowHandle();
		System.out.println("The session ID of current window is--->"+currentID);
		
		Thread.sleep(2000);
		Robot key=new Robot();
		key.keyPress(KeyEvent.VK_CONTROL);
		key.keyPress(KeyEvent.VK_T);
		key.keyRelease(KeyEvent.VK_CONTROL);
		key.keyRelease(KeyEvent.VK_T);
		
		Thread.sleep(2000);
		key.keyPress(KeyEvent.VK_CONTROL);
		key.keyPress(KeyEvent.VK_T);
		key.keyRelease(KeyEvent.VK_CONTROL);
		key.keyRelease(KeyEvent.VK_T);
			
		Thread.sleep(TS);
		driver.switchTo().window(currentID);
		System.out.println(driver.getTitle());
		
		Thread.sleep(TS);
		
		Set<String> multiweb = driver.getWindowHandles();
		System.out.println("Session ID for multiple windows");
		System.out.println(multiweb);
		
		ArrayList<String> tablist=new ArrayList<String>(multiweb);
		for (String string : tablist) {
			System.out.println(string);
			
		}
		
		driver.switchTo().window(tablist.get(1));
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(tablist.get(2));
		driver.get("https://www.flipkart.com");
		System.out.println(driver.getTitle());
		
	}

}
