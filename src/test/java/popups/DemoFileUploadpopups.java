package popups;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoFileUploadpopups {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost:/login.do");
		
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		int count = tabs.size();
		System.out.println(count);
		
		for(String tab:tabs)
		{
			driver.switchTo().window(tab);
			String s = driver.getTitle();
			if(s.equals("actiTIME - Time Tracking Software for Boosting Your Business"))
			{
				WebElement hs = driver.findElement(By.xpath("//a[text()='Help Center']"));
				
				Actions act = new Actions(driver);
				act.moveToElement(hs).perform();
				
				driver.findElement(By.xpath("//a[text()='Contact Support']")).click();
				int yaxis = driver.findElement(By.xpath("//label[text()='Question']")).getLocation().getY();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0,"+yaxis+")");
				String path = "C:\\Users\\warlo\\Desktop\\New Microsoft Word Document.docx";
				driver.findElement(By.id("fileupload")).sendKeys(path);
								
			}
			else
			{
				driver.close();
			}
		}
		
		
		
		
	
	}

}
