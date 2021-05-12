package iframe;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
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
		
		
		
		
		
		Thread.sleep(4000);
		shutDown();
	}

}
