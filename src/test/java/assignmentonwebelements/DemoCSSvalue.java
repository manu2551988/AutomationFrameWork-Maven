package assignmentonwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import browser_setups.BrowserMulti;

public class DemoCSSvalue extends BrowserMulti {
	
	@Test
	
	public void Cssvalue() throws InterruptedException
	{
		browserSetup("firefox","http://flipkart.com");
		
		WebElement inspect = driver.findElement(By.xpath("//h2[.='Deals of the Day']"));
		
		String fz = inspect.getCssValue("font-size");
		System.out.println("Font Size of element is---->"+fz);
		
		String color = inspect.getCssValue("color");
		System.out.println("Color of element is---->"+color);
		
		String ff = inspect.getCssValue("font-family");
		System.out.println("Font family of element is---->"+ff);
		
		shutDown();
	}
	
	
	
	

}
