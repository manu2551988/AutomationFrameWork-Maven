package dropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoForDropDown5 {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	
	public static void testBrowser(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get("file:///C:/Users/Sunil/Desktop/dd.html");
		
		WebElement fruitsDDL = driver.findElement(By.id("moreT"));
		
		WebElement languageDDL = driver.findElement(By.id("SE"));
		
		Select sel = new Select(fruitsDDL);
		System.out.println(sel.isMultiple());
		
	
		
		//Select the DropDown Content/Elements by using its VisibleText
		
		sel.selectByIndex(3);
        Thread.sleep(1000);
        sel.selectByVisibleText("Mango");
        Thread.sleep(1000);
//        sel.selectByValue("c");
        
      WebElement s = sel.getFirstSelectedOption();
      System.out.println(s.getText());
        
        sel.deselectByValue("b");
        Thread.sleep(1000);
//        sel.deselectByIndex(0);
        Thread.sleep(1000);
        sel.deselectByVisibleText("Mango");
		
		
		
	}
	
	public static void main(String[] args)throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();		
		testBrowser(driver);
		
		
				
				
		

	}

}
