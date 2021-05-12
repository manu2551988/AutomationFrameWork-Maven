package synchronization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import browser_setups.BrowserMulti;

public class AutoSuggestiontrycatch  {
	
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com");
		
		WebElement srchbox = driver.findElement(By.name("q"));
		
		srchbox.sendKeys("java");
		
		//try and catch method to overcome use of Thread.sleep(), implicitlywait() and explicitwait()
		try {
		
			List<WebElement> autosugg = driver.findElements(By.xpath("//span[contains(.,'java')]"));
			int count = autosugg.size();
			System.out.println("Autosuggestion count--->"+count);
			
			for (WebElement webElement : autosugg) 
			{
				
				String sugg = webElement.getText();
				System.out.println(sugg);
			}
			
			autosugg.get(4).click();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		driver.close();
		
		
	}
	

}
