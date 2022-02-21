package practice_programs;

import browser_setups.BrowserMulti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assig_3 extends BrowserMulti{
	
	@Test
	
	public void TC() {
		
		browserSetup("chrome", "https://www.vtiger.com");
				
		WebElement clkAgree = driver.findElement(By.xpath("//a[contains(.,'Agree')]"));
		clkAgree.click();
				
        WebElement resource = driver.findElement(By.xpath("//a[contains(.,'Resources')]"));
        resource.click();
        
        WebElement contain=driver.findElement(By.xpath("//h6[contains(.,'Contact')]"));
        //WebDriverWait wait= new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(contain)).click();
        contain.click();
        
        WebElement hr = driver.findElement(By.xpath("//p[contains(.,'Human Resources')]/../p[2]"));
		String printHR = hr.getText();
		System.out.println("Contact details for HR as follow--->"+printHR);
		
		
		shutDown();
	}
	
	
	

}
