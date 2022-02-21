package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DemoSinglSelect {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    }

    public static void testBrowser(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get("file:///C:/Users/Sunil/Desktop/dd.html");
		
		WebElement slistBox = driver.findElement(By.id("moreT"));
		Select select = new Select(slistBox);
		
		select.selectByIndex(3);
		Thread.sleep(1000);
		select.selectByValue("j");
		
		
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver = new ChromeDriver();		
		testBrowser(driver);


	}

}
