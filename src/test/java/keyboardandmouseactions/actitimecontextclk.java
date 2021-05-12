package keyboardandmouseactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import browser_setups.BrowserMulti;

public class actitimecontextclk extends BrowserMulti{
	
	@Test
	public void TC() throws AWTException, InterruptedException {
		
		browserSetup("chrome", "http://localhost/login.do");
		
//		WebElement unTB = driver.findElement(By.xpath("//input[@id='username']"));
//		unTB.sendKeys("admin");
//		
//		WebElement pwTB = driver.findElement(By.xpath("//input[@name='pwd']"));
//        pwTB.sendKeys("manager");
//        
//        WebElement chkBox = driver.findElement(By.xpath("//input[@id='keepLoggedInCheckBox']"));
//	    chkBox.click();
	    
//	    WebElement lgnBTN = driver.findElement(By.xpath("//div[text()='Login ']"));
//	    lgnBTN.click();
	    
	    WebElement rightclk = driver.findElement(By.xpath("//a[.='actiTIME Inc.']"));
	    
	    Actions act=new Actions(driver);
	    act.contextClick(rightclk).perform();
	    
	    Robot rs= new Robot();
	    rs.keyPress(KeyEvent.VK_T);
	    rs.keyRelease(KeyEvent.VK_T);
	    
//		Set<String> tabID = driver.getWindowHandles();
//		  
//		for (String string : tabID) 
//		{
//		  driver.switchTo().window(string); 
//		  String pageTitle = driver.getTitle(); 
//		  if(pageTitle.equals("actiTIME - Time Tracking Software for Boosting Your Business")) 
//		  {
//		  System.out.println("PageTitle of current window is--->"+driver.getTitle()); }
//		  Thread.sleep(2000);
//		  driver.close();	  
//		  
//		}	    
	}

}
