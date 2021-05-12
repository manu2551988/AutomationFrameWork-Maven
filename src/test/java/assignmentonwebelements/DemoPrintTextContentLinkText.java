package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Print the Content of the LinkText
 * @author Manu Kakkar
 *
 */
public class DemoPrintTextContentLinkText extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement linkText = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
		String content = linkText.getText();
		System.out.println("The Content of The LinkText Is------>"+content);

	}

}
