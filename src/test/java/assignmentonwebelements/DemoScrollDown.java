package assignmentonwebelements;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To 
 * @author Manu Kakkar
 *
 */
public class DemoScrollDown extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://localhost:8082/login.do");
		
		Set<String> whs = BaseClass.driver.getWindowHandles();
		int count = whs.size();
		System.out.println("Before Clicking on the licence link "+count);
		
		BaseClass.driver.findElement(By.id("licenseLink")).click();
		
		Set<String> whs1 = BaseClass.driver.getWindowHandles();
		int count1 = whs1.size();
		System.out.println("After Clicking on the view licences link "+count1);
		
		String currentpagetitle = BaseClass.driver.getTitle();
		System.out.println(currentpagetitle);
		
		
		
		
	}

}
