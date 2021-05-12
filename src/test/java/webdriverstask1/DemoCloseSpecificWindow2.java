package webdriverstask1;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCloseSpecificWindow2 
{	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	
	public static void main(String[] args) 
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.naukri.com");
		
		String parentwh = driver.getWindowHandle();
		
		
		Set<String> whs = driver.getWindowHandles();
		int count = whs.size();
		System.out.println(count);
		
		
		for(String w:whs)
		{
			driver.switchTo().window(w);
			String s = driver.getTitle();
			if(s.equals("Optum"))
			{
			  driver.close();
			}
			else
				
			{
				System.out.println(s);
			}
			
			
		}
		
		
	}
	

}
