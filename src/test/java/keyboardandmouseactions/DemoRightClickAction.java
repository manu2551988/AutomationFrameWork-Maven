package keyboardandmouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class DemoRightClickAction {

    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    }

    public static void main(String[] args) throws AWTException, InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost:/login.do");
		
		WebElement actTIMELink = driver.findElement(By.xpath("//a[text()='actiTIME Inc.']"));
            
		Actions act =new Actions(driver);		
		act.contextClick(actTIMELink).perform();;
		Thread.sleep(1000);
		Robot r = new Robot();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_T);

	}

}
