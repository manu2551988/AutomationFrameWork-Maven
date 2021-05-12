package webdriverstask1;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCloseChildWindow 
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
		
		whs.remove(parentwh);
		for(String w:whs)
		{
			driver.switchTo().window(w);
//			if(parentwh.equals(w))
//			{
//				String s = driver.getTitle();
//				System.out.println("parent window title is-->"+s);
//			}
//			else
//			{	
//			  driver.close();
//			}
			
			driver.close();
		}
		
		
	}
	

}
