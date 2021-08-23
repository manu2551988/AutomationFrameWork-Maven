package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoCopyPaste2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException
	{
		openBrowser("firefox","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		Thread.sleep(1000);
		unTB.clear();
		unTB.sendKeys("Sunil");
		String s = unTB.getAttribute("value");
		
		WebElement pwTB = driver.findElement(By.id("password"));
		pwTB.clear();
		pwTB.sendKeys(s);
		
		

	}

}
