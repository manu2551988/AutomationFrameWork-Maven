package methodsofwebdriver;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAllCildBrowserwindow {
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
        
        whs.remove(pwhs);
        int count2 = whs.size();
        System.out.println(count2);
        for(String window:whs)
        {
        	
        	driver.switchTo().window(window);
        	driver.close();
//        	if(pwhs.equals(window))
//        	{
//        		String title = driver.getTitle();
//        		System.out.println("parent window havnt close so capture the title--->"+title);
//        	}
//        	else
//        	{
//        		driver.close();
//        	}
        	
        }
	

	}

}
