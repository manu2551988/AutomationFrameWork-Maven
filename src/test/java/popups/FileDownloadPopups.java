package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class FileDownloadPopups {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    }

    public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.seleniumhq.org");
		
		driver.findElement(By.xpath("//a[text()='Downloads']")).click();
		
		int yaxis = driver.findElement(By.xpath("//h2[text()='Selenium Client & WebDriver Language Bindings']")).getLocation().getY();
		
       JavascriptExecutor jse = (JavascriptExecutor) driver;
       jse.executeScript("window.scrollBy(0,"+yaxis+")");
       
       driver.findElement(By.xpath("//td[text()='Java']/../td[6]/a[1]")).click();
       
       Robot r =  new Robot();
       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_ENTER);
       r.keyRelease(KeyEvent.VK_ENTER);
	}

}
