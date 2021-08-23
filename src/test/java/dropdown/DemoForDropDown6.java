package dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoForDropDown6 {
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
		
	     String expected ="Mango";
	     boolean flag=false;
		
		//Select the DropDown Content/Elements by using its VisibleText
		
		
        
        List<WebElement> lisbBoxElements = sel.getOptions();
        for(WebElement elem:lisbBoxElements)
        {
        	String actual = elem.getText();
        	if(actual.equals(expected))
        	{
        		sel.selectByVisibleText("Mango");
        		flag=true;
        		break;
        				
        	}
        }
        
//        Thread.sleep(1000);
//        System.out.println("------------------------");
//        List<WebElement> selElements = sel.getAllSelectedOptions();
//        int count = selElements.size();
//        System.out.println(count);
//        System.out.println("-------------------------");
//        for(WebElement element:selElements)
//        {
//        	String s = element.getText();
//        	System.out.println(s);
//        }
        
//        sel.deselectByValue("b");
//        Thread.sleep(1000);
//        sel.deselectByIndex(0);
//        Thread.sleep(1000);
//        sel.deselectByVisibleText("Mango");
//		
//		
		
	}
	
	public static void main(String[] args)throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();		
		testBrowser(driver);
		
		
				
				
		

	}

}
