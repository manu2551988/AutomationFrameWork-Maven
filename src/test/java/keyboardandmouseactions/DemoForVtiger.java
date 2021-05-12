package keyboardandmouseactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoForVtiger {	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.vtiger.com");
		WebElement resource = driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
		
		Actions action =  new Actions(driver);
		action.moveToElement(resource).perform();
		
		WebElement contact = driver.findElement(By.xpath("//h6[contains(text(),'Contact')]"));
        contact.click();
        
       int yaxis = driver.findElement(By.xpath("//p[contains(text(),'U.S. & Global')]")).getLocation().getY();
       
      JavascriptExecutor jse = (JavascriptExecutor)driver;
      jse.executeScript("window.scrollBy(0,"+yaxis+")");
      
     String hrNo = driver.findElement(By.xpath("//p[contains(text(),'Human Resources')]/../p[2]")).getText();
	  System.out.println(hrNo);
	}

}
