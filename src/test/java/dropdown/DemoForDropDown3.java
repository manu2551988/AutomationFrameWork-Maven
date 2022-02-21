package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DemoForDropDown3 {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    }

    public static void testBrowser(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get("file:///C:/Users/Sunil/Desktop/dd.html");
		
		WebElement fruitsDDL = driver.findElement(By.id("moreT"));
		
		WebElement languageDDL = driver.findElement(By.id("SE"));
		
		Select sel = new Select(fruitsDDL);
		System.out.println(sel.isMultiple());
		
		WebElement wrapper = sel.getWrappedElement();
		System.out.println(wrapper.getText());
		
		
	}
	
	public static void main(String[] args)throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();		
		testBrowser(driver);
	}

}
