package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import browser_setups.BrowserSimple;

public class AssignBerry extends BrowserSimple {

	public static void main(String[] args) {
		
		//WAS to select all the options which contain Berry?
		
		browserSetup("chrome", "C:\\Users\\warlo\\Desktop\\Drop Down.html");
		
		List<WebElement> multi = driver.findElements(By.xpath("//select[@id='multi']/option[contains(.,'berry')]"));		
		for (WebElement webElement : multi) {
			webElement.click();	
		}
		
	}

}
