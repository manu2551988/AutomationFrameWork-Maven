package methodsofwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CloseAllTheBrowserWithoutQuit {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.naukri.com");
        
        Set<String> whs = driver.getWindowHandles();
        int count = whs.size();
        System.out.println(count);
        
        for(String window:whs)
        {
        	
        	driver.switchTo().window(window);
        	String title = driver.getTitle();
        	System.out.println(title);
        	driver.close();
        	
        }
	

	}

}
