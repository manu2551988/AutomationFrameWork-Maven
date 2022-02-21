package scrolltoele;

import assignmentonwebelements.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Write Selenium Script To scroll the window to desired location
 * @author Manu Kakkar
 *
 */
public class DemoScrollDown1 extends BaseClass
{

	public static void main(String[] args)
	{
		
		openBrowser("chrome","http://localhost:8082/login.do");
		
		BaseClass.driver.findElement(By.id("licenseLink")).click();
		
		Set<String> whs = BaseClass.driver.getWindowHandles();
		int count1 = whs.size();
		System.out.println("After Clicking on the view licences link "+count1);
		
		for(String w:whs)
		{
			driver.switchTo().window(w);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals("actiTIME License Agreement"))
			{
				driver.manage().window().maximize();
				WebElement paragraph = driver.findElement(By.xpath("//h2[text()='12. Export Controls']"));
				int yaxis = paragraph.getLocation().getY();
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,"+yaxis+")");
			}
		}
		
		
		
		
	}

}
