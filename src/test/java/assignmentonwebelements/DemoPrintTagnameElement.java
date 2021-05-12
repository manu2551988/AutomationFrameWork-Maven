package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Print the TagName Of the Element
 * @author Manu Kakkar
 *
 */
public class DemoPrintTagnameElement extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement logo = driver.findElement(By.className("logo"));
		String tagname = logo.getTagName();
		System.out.println("The TagName of the Logo is------>"+tagname);

	}

}
