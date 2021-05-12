package keyboardandmouseactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoDD {
	
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://drive.google.com/drive/folders/1J6L4xOVE38a0zsIkg0ZqkPV9r1Suq0U6");
        WebElement folder1 = driver.findElement(By.xpath("(//div[text()='launchbrowser'])[1]"));
		Actions act =new Actions(driver);
		Thread.sleep(500);
		act.doubleClick(folder1).perform();
		
		driver.close();
	}

}
