package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RealTime4OptimizedCode {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	/**
	 * This Method Is Used To Verify the Page Title
	 * @param driver
	 * @param expecteTitle
	 */
	
	public static void verifyPage(WebDriver driver ,String expecteTitle)
	{
		  
		    String actaualTitle = driver.getTitle();
		    
		    if(actaualTitle.equals(expecteTitle))
		    {
		    	System.out.println("The Expected Page Title is Displayed--->"+expecteTitle);
		    }
		    else
		    {
		    	System.out.println("The Expected Page Title is Not Displayed--->"+actaualTitle);
		    }
		
	}

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8082/login.do");
		
		
		WebElement unTB = driver.findElement(By.id("username"));
		Thread.sleep(1000);
		unTB.sendKeys("admin");
		
		WebElement pwTB = driver.findElement(By.name("pwd"));
		Thread.sleep(1000);
		pwTB.sendKeys("manager");
		
		WebElement chkBOX = driver.findElement(By.id("keepLoggedInCheckBox"));
		Thread.sleep(1000);
		chkBOX.click();
		
		WebElement lgnBTN = driver.findElement(By.xpath("//div[text()='Login ']"));
		Thread.sleep(1000);
	    lgnBTN.click();
	    
	    Thread.sleep(1000);
	    verifyPage(driver, "actiTIME - Enter Time-Track");
	   
	    
	    WebElement settings = driver.findElement(By.xpath("(//div[contains(text(),'Settings')])[1]"));
	     Thread.sleep(1000);
	     settings.click();
	     
	    WebElement licensesLinkText = driver.findElement(By.xpath("//a[text()='Licenses']"));
	    Thread.sleep(1000);
	    licensesLinkText.click(); 
	    
	     verifyPage(driver,"actiTIME - Licenses");
	     
	    String expectedPE ="actiTIME 2017.4";
	    WebElement productEdition = driver.findElement(By.xpath("//nobr[text()='Product Edition:']/../../td[2]"));
	    Thread.sleep(1000);
	    String actualPE = productEdition.getText();
	    
	    if(actualPE.equals(expectedPE))
	    {
	    	System.out.println("The Expected Product Edition is Proper--->"+expectedPE);
	    	System.out.println("TestCase is Passed");
	    }
	    else
	    {
	    	System.out.println("The Expected Product Edition is Not Proper--->"+actualPE);
	    	System.out.println("TestCase is Failed");
	    }
	    
	    WebElement lgOutBTN = driver.findElement(By.id("logoutLink"));
	    Thread.sleep(1000);
	    lgOutBTN.click();
	    
	    driver.close();
	    
	   
	}

}
