package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Get the title of the page Without using GetTitle Method.
 * @author Manu Kakkar
 *
 */
public class DemoGetTitleWithout extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://www.facebook.com");
		
		WebElement title = BaseClass.driver.findElement(By.tagName("title"));
		
		String pageTitle = title.getAttribute("textContent");
		System.out.println(pageTitle);
	}

}
