package handlingmultipleElements;

import browser_setups.BrowserMulti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DemoPrintEmptyList extends BrowserMulti {
	
	
	

	@Test
	public void PrintLinks() throws InterruptedException {
		
		browserSetup("chrome","https://www.google.com");
		//locator not able to find the element on the webpage
		List<WebElement> link = driver.findElements(By.xpath("//a1"));
		//findElements printing empty list
		System.out.println("List of element found---->"+link);
		int count = link.size();
		
		System.out.println("Total number of links are-->"+count);
		
		for (WebElement webElement : link) {
					
				String printlink = webElement.getText();
				System.out.println(printlink);
			
		}
		
		shutDown();
		
	}
	

}
