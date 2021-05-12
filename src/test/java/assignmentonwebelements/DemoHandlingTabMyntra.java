package assignmentonwebelements;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Handle Multiple Tabs
 * @author Manu Kakkar
 *
 */
public class DemoHandlingTabMyntra extends BaseClass
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		openBrowser("chrome","http://www.myntra.com");
		String ptab = driver.getWindowHandle();
		WebElement srchBox = driver.findElement(By.className("desktop-searchBar"));
		srchBox.sendKeys("kurtis",Keys.ENTER);
		
		driver.findElement(By.xpath("//img[contains(@src,'Kurti-4121-1')]")).click();
		Thread.sleep(2000);
		
		Set<String> tabs = driver.getWindowHandles();
		int count = tabs.size();
		System.out.println(count);
		 for(String tab:tabs)
		 {
			driver.switchTo().window(tab);
			if(ptab.equals(tab))
			{
				driver.close();
			}
			else
			{
				driver.findElement(By.xpath("//p[text()='XS']/ancestor::div[@class='size-buttons-buttonContainer']")).click();
			}
		 }
		
		
		
		
		
		
		
		
	}

}
