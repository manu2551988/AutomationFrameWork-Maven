package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoHiddenDivisionPopup {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://flipkart.com");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("Sunil");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();

	}

}
