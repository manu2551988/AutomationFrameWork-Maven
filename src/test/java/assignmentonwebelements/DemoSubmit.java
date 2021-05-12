package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Click on The Button Without using Click() method
 * @author Manu Kakkar
 *
 */
public class DemoSubmit extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://demo.opensourcebilling.org");
		//Submit() method work with those webelement only where the attribute type also submit
		driver.findElement(By.xpath("//button[text()='Submit']")).submit();
		
		
	}

}
