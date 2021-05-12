package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DemoB extends BaseClass
{

	public static void main(String[] args) throws InterruptedException 
	{
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		Thread.sleep(1000);
		unTB.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		
		
		WebElement pwTB = driver.findElement(By.id("password"));
		Thread.sleep(1000);
		pwTB.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
