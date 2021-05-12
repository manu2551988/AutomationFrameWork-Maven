package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoIDP {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Sunil/Desktop/table.html");
		
		WebElement priceJAVA = driver.findElement(By.xpath("//td[text()='Java']/../td[2]"));
		String rs = priceJAVA.getText();
		System.out.println("The Java Book Price is ---->"+rs);
		driver.close();
		
	}

}
