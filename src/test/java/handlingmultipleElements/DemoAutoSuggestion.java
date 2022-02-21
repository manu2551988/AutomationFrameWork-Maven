package handlingmultipleElements;

import browser_setups.BrowserMulti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DemoAutoSuggestion extends BrowserMulti {
	
	@Test
	
	public void AutoSugg() {
		
		browserSetup("chrome", "http://www.google.com");

		WebElement srchbox = driver.findElement(By.name("q"));
		
		srchbox.sendKeys("java");
		
		List<WebElement> autosugg = driver.findElements(By.xpath("//span[contains(.,'java')]"));
		int count = autosugg.size();
		System.out.println("Autosuggestion count--->"+count);
		
		for (WebElement webElement : autosugg) {
			
			String sugg = webElement.getText();
			System.out.println(sugg);
		}
		
		autosugg.get(4).click();
		
		shutDown();
		
		
	}
	

}
