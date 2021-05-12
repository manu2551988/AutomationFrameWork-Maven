package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To find The Height and Width of the textbox or element.
 * @author Manu Kakkar
 *
 */
public class DemoIsDispalyed extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("firefox","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		
		int heightunTB = unTB.getSize().getHeight();
		System.out.println("Height of the Username TextBox is --->"+heightunTB);
		
		int widthunTB = unTB.getSize().getWidth();
		System.out.println("Width of the Username textbox is ----->"+widthunTB);
		
		
		System.out.println("===============================================");
		
		WebElement pwTB = driver.findElement(By.id("password"));
		
		
		int heightpwTB = pwTB.getSize().getHeight();
		System.out.println("Height of the PassWord TextBox is --->"+heightpwTB);
		
		int widthpwTB = pwTB.getSize().getWidth();
		System.out.println("Width of the PassWord textbox is ----->"+widthpwTB);
	
		
		

	}

}
