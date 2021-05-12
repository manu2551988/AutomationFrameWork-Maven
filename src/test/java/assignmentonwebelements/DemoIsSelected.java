package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To find Whether the element isSelected or not.
 * @author Manu Kakkar
 *
 */
public class DemoIsSelected extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://demo.opensourcebilling.org");
		
		WebElement signIN = driver.findElement(By.xpath("//label[text()='Keep me signed in']"));
		
		signIN.click();	
		
		WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		if(chkbox.isSelected())
		{
			System.out.println("The CheckBox isSelected");
		}
		else
		{
			System.out.println("The CheckBox is not Selected");
		}
		
		
		

	}

}
