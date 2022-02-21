package webdriverstask1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class DemoWindowHandle2 {
    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
    }

    public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String pwh = driver.getWindowHandle();
		System.out.println(pwh);
		
		driver.get("http://www.naukri.com");
		
		Set<String> whs = driver.getWindowHandles();
		int count = whs.size();
		System.out.println(count);
		System.out.println(whs);
		
//		driver.close();
		driver.quit();
		
			
	}

}
