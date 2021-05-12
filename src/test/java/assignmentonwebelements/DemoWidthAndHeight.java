package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To find whether the element is Displayed or not 
 * @author Manu Kakkar
 *
 */
public class DemoWidthAndHeight extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("firefox","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		
		if(unTB.isDisplayed())
		{
			System.out.println("The UserName TextBox Element is Displayed");
		}
		else	
			{
				System.out.println("The UserName TextBox Element is not Displayed");
			}
	
		
		
		System.out.println("===============================================");
		
		WebElement pwTB = driver.findElement(By.id("password"));
		
		if(pwTB.isDisplayed())
		{
			System.out.println("The PassWord Textbox element is Displayed");
		}
		else	
		{
			System.out.println("The PassWord TextBox Element is not Displayed");
		}
		
		
		

	}

}
