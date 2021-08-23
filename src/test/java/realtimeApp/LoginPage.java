package realtimeApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args)
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		
		WebElement unTB = driver.findElement(By.xpath("//input[@id='username']"));
		unTB.sendKeys("admin");
		
		WebElement pwTB = driver.findElement(By.xpath("//input[@name='pwd']"));
        pwTB.sendKeys("manager");
        
        WebElement chkBox = driver.findElement(By.xpath("//input[@id='keepLoggedInCheckBox']"));
	    chkBox.click();
	    
	    WebElement lgnBTN = driver.findElement(By.xpath("//div[text()='Login ']"));
	    lgnBTN.click();
	    
//	    WebElement rightclk = driver.findElement(By.xpath("//a[.='actiTIME Inc.']"));
//	    
//	    Actions act=new Actions(driver);
//	    act.contextClick(rightclk).perform();
	    
	    
	}

}
