package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DemoClear3 extends BaseClass
{

	public static void main(String[] args)
	{
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('email').value=''");
		

	}

}
