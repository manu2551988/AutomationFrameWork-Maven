package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoClear extends BaseClass
{

	public static void main(String[] args)
	{
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		unTB.clear();
		

	}

}
