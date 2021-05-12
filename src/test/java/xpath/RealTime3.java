package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTime3 {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.myntra.com");
		
		
		WebElement srchBOX = driver.findElement(By.className("desktop-searchBar"));
		srchBOX.sendKeys("tshirts",Keys.ENTER);
		
		WebElement offerpercentage = driver.findElement(By.xpath("//img[contains(@src,'Maroon-Striped-Polo-Collar-T-shi')]/../../../../../../div[2]/div/span[2]"));
	    String s = offerpercentage.getText();
	    System.out.println(s);
	    driver.close();
	}

}
