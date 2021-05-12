package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DemoClear2 extends BaseClass
{

	public static void main(String[] args)
	{
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		unTB.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		

	}

}
