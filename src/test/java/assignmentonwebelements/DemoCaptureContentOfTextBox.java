package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Capture or Retrive Data present in the TextBox..
 * @author Manu Kakkar
 *
 */
public class DemoCaptureContentOfTextBox extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		String s = unTB.getAttribute("value");
		System.out.println("The Data Which is present inside the textBox is ----->"+s);
		
		unTB.clear();
		unTB.sendKeys("Sunil");
		String s1 = unTB.getAttribute("value");
		System.out.println("The Data Which is present inside the textBox is ----->"+s1);
		
		String s3 = unTB.getAttribute("id");
		System.out.println(s3);
		
	}

}
