package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To find Wheteher the element isEnable or not.
 * @author Manu Kakkar
 *
 */
public class DemoIsEnabled extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("firefox","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		
		if(unTB.isEnabled())
		{
			System.out.println("The UserName TextBox Element is Enabled");
		}
		else	
			{
				System.out.println("The UserName TextBox Element is not Disabled");
			}
		
		
		System.out.println("===============================================");
		
		WebElement pwTB = driver.findElement(By.id("password"));
		
		if(pwTB.isEnabled())
		{
			System.out.println("The PassWord TextBox Element is Enabled");
		}
		else	
			{
				System.out.println("The PassWord TextBox Element is not Disabled");
			}
		
		
		
	
		
		

	}

}
