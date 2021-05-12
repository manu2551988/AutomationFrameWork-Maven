package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTime {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		
		WebElement srchbox = driver.findElement(By.id("twotabsearchtextbox"));
		srchbox.sendKeys("mimobile",Keys.ENTER);
		
		
		WebElement price = driver.findElement(By.xpath("//span[text()='Redmi Note 8 Pro (Electric Blue, 6GB RAM, 64GB Storage with Helio G90T Processor)']/../../../../../../../div[2]/div[1]/div/div[1]/div/div/a/span[2]"));
		String rs = price.getText();
		System.out.println("Price of the Mi Mobile phone is--->"+rs);
		driver.close();
	
	}

}
