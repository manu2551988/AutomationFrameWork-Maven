package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To find The X and Y Coordinate of the textbox or element.
 * @author Manu Kakkar
 *
 */
public class DemoCoordinate extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("firefox","http://demo.opensourcebilling.org");
		
		WebElement unTB = driver.findElement(By.id("email"));
		int unTBXaxis = unTB.getLocation().getX();
		System.out.println("Xaxis------>"+unTBXaxis);
		
		int unTBYaxis = unTB.getLocation().getY();
		System.out.println("Yaxis------->"+unTBYaxis);
		
		System.out.println("===============================================");
		
		WebElement pwTB = driver.findElement(By.id("password"));
		int pwTBXaxis = pwTB.getLocation().getX();
		System.out.println("Xaxis------>"+pwTBXaxis);
		
		int pwTBYaxis = pwTB.getLocation().getY();
		System.out.println("Yaxis------->"+pwTBYaxis);
		
		

	}

}
