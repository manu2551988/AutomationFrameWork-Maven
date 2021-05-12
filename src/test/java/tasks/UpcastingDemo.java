package tasks;

import org.openqa.selenium.chrome.ChromeDriver;

public class UpcastingDemo {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args)
	{
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		

	}

}
