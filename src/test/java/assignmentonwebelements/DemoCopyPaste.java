package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DemoCopyPaste extends BaseClass {

	public static void main(String[] args) throws InterruptedException
	{
		openBrowser("firefox","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		Thread.sleep(1000);
		unTB.clear();
		unTB.sendKeys("Sunil",Keys.CONTROL+"ac");
		
		WebElement pwTB = driver.findElement(By.id("password"));
		pwTB.clear();
		pwTB.sendKeys(Keys.CONTROL+"v");
		
		

	}

}
