package handlingmultipleElements;

import browser_setups.BrowserMulti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DemoPrintAllLinks extends BrowserMulti {
	
	
	

	@Test
	public void PrintLinks() throws InterruptedException {
		
		browserSetup("chrome","https://www.google.com");
		
		List<WebElement> link = driver.findElements(By.xpath("//a"));
		int count = link.size();
		
		System.out.println("Total number of links are-->"+count);
		
		for (WebElement webElement : link) {
			
			
			if (webElement.isDisplayed()) {
				
				String printlink = webElement.getText();
				System.out.println(printlink);
				
			}
			
		}
		
		shutDown();
		
	}
	

}
