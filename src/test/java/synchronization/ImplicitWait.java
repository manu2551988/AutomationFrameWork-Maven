package synchronization;

import browser_setups.BrowserMulti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait extends BrowserMulti{
	
	@Test
	public void implicit() {
		
		
		
		browserSetup("chrome", "http://localhost/login.do");
		//Implicit Wait line of code
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String lpTitle = driver.getTitle();
		System.out.println("The Login Page Tile Is------>"+lpTitle);
		
		WebElement unTB = driver.findElement(By.id("username"));
		unTB.sendKeys("admin");
		
		WebElement pwTB = driver.findElement(By.name("pwd"));
		pwTB.sendKeys("manager");
		
		WebElement chkBox = driver.findElement(By.id("keepLoggedInCheckBox"));
		chkBox.click();
		
		WebElement lgnBTN = driver.findElement(By.xpath("//div[text()='Login ']"));
		lgnBTN.click();
		
		//Explicit Wait line of code
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("actiTIME - Enter Time-Track"));	
				
		String hpTitle = driver.getTitle();
		System.out.println("The Home Page title is-------->"+hpTitle);
		
		WebElement settings = driver.findElement(By.xpath("(//div[contains(text(),'Settings')])[1]"));
		settings.click();
		
		WebElement licenses = driver.findElement(By.xpath("//a[text()='Licenses']"));
		licenses.click();
		
		String lcpTitle = driver.getTitle();
		System.out.println("The Licences Page Title is----->"+lcpTitle);
		
		
		WebElement lgOut = driver.findElement(By.id("logoutLink"));
		lgOut.click();
		
		shutDown();
	}

}
