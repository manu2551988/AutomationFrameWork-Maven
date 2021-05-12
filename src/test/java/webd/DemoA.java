package webd;

import org.openqa.selenium.chrome.ChromeDriver;

public class DemoA {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args)
	{
		                   //Open The Browser
		                   ChromeDriver driver = new ChromeDriver();
		                   
		                   //maximize the browser
		                   driver.manage().window().maximize();
		                   
		                   //Enter the URL of the Application which you want perform actions
		                     driver.get("http://www.google.com");
		                     
		                    //get the title of the Web application
		                     String title = driver.getTitle();
		                     System.out.println(title);
		                     
		                     //Close the Browser
		                     driver.close();
		

	}

}
