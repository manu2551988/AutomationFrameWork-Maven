package practice_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import browser_setups.BrowserMulti;

public class Assig_2 extends BrowserMulti {
	
	@Test
	public void TC() {
		
		browserSetup("chrome", "http://www.qspiders.com/");
		
		WebElement clkAbt = driver.findElement(By.xpath("//a[.='About us ']"));
		Actions act=new Actions(driver);
		act.moveToElement(clkAbt).perform();
		
		WebElement clkFaculty = driver.findElement(By.xpath("//a[.='Faculty']"));
		clkFaculty.click();
		
		WebElement para = driver.findElement(By.xpath("//p[contains(.,'Mr. Girish is')]"));
		String info = para.getText();
		System.out.println(info);
		
		shutDown();
		
	}

}
