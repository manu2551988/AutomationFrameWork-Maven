package webdriverstask1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class DemoCloseParentWindow {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
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
			if(parentwh.equals(w))
			{
				 driver.close();
			}
			else
			{	
				
				String s = driver.getTitle();
				System.out.println("child window title is-->"+s);
			 
			}
			
			
		}
		
		
	}
	

}
