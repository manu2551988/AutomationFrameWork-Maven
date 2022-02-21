package scrolltoele;

import assignmentonwebelements.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Write Selenium Script To scroll the window to desired location and take screenshot
 * @author Manu Kakkar
 *
 */
public class DemoScrollDown2 extends BaseClass
{

	public static void main(String[] args) throws IOException
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
				
				TakesScreenshot ts = (TakesScreenshot)jse;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File des = new File("./photo/parag.png");
				FileUtils.copyFile(src, des);
			}
		}
		
		
		
		
	}

}
