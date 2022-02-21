package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoFileUploadpopups2 {

    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    public static void main(String[] args) throws AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost:/login.do");
		
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		int count = tabs.size();
		System.out.println(count);
		
		for(String tab:tabs)
		{
			driver.switchTo().window(tab);
			String s = driver.getTitle();
			if(s.equals("actiTIME - Time Tracking Software for Boosting Your Business"))
			{
				WebElement hs = driver.findElement(By.xpath("//a[text()='Help Center']"));
				
				Actions act = new Actions(driver);
				act.moveToElement(hs).perform();
				
				driver.findElement(By.xpath("//a[text()='Contact Support']")).click();
				int yaxis = driver.findElement(By.xpath("//label[text()='Question']")).getLocation().getY();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0,"+yaxis+")");
				
				WebElement fp = driver.findElement(By.xpath("//input[@type='file']"));
				act.click(fp).perform();
				
				StringSelection filepath =new StringSelection("C:\\Users\\warlo\\Desktop\\New Microsoft Word Document.docx");
				
				Toolkit tlk = Toolkit.getDefaultToolkit();
				
				Clipboard clp = tlk.getSystemClipboard();
				clp.setContents(filepath, null);
				
				Robot r =new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
				
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
						
			}
			else
			{
				driver.close();
			}
		}
	
	}

}
