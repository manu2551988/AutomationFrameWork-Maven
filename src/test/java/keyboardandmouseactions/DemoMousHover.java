package keyboardandmouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DemoMousHover {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    }

    public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.qspiders.com");
		
		WebElement abtus = driver.findElement(By.xpath("//a[contains(text(),'About us')]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(abtus).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Faculty']")).click();
		
		driver.findElement(By.xpath("//a[text()='Mr.Bhanu Prakasha']")).click();
		
		String s = driver.findElement(By.xpath("(//p)[2]")).getText();
		System.out.println(s);
		

	}

}
