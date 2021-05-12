package assignmentonwebelements;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

/**
 * Write Selenium Script To Handle Multiple Tabs
 * @author Manu Kakkar
 *
 */
public class DemoHandlingTab extends BaseClass
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		openBrowser("chrome","http://localhost:8082/login.do");
		
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		int count = tabs.size();
		System.out.println(count);
		
		for(String tab:tabs)
		{
			driver.switchTo().window(tab);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals("actiTIME - Time Tracking Software for Boosting Your Business"))
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='Try Free']")).click();
				Thread.sleep(1000);
				String s = driver.getTitle();
				System.out.println(s);
			}
		}
		
		
	}

}
