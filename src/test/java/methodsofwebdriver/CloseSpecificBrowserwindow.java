package methodsofwebdriver;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowserwindow {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.naukri.com");
        String pwhs = driver.getWindowHandle();
        
        Set<String> whs = driver.getWindowHandles();
        int count = whs.size();
        System.out.println(count);
        
        for(String window:whs)
        {
        	
        	driver.switchTo().window(window);
           String currentTitle = driver.getTitle();
           System.out.println(currentTitle);
           if(currentTitle.equals("Sopra Banking"))
           {
        	   driver.close();
           }
        	
        }
	

	}

}
