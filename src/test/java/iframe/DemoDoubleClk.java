package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import browser_setups.BrowserMulti;

public class DemoDoubleClk extends BrowserMulti {
	
	@Test
	public void doubleClk() throws InterruptedException 
	{
		browserSetup("chrome", "https://www.gmail.com");
		
		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("manu2551988",Keys.ENTER);
		
		WebElement clkapp = driver.findElement(By.xpath("//a[@class='gb_D']"));
		clkapp.click();
		
		WebElement clkApproverTab=driver.findElement(By.xpath("abc"));
		WebElement swtiFrame = driver.findElement(By.xpath("abc"));
		driver.switchTo().frame(swtiFrame);
        Thread.sleep(5000);
        int yaxis = clkApproverTab.getLocation().getY();
        System.out.println("Y-Coordinate:"+ yaxis);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,"+yaxis+")");
        Thread.sleep(5000);
		
		
		
		Thread.sleep(4000);
		shutDown();
	}

}
