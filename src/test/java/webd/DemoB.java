package webd;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoB {
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args)
	{
		                   //Open The Browser
		                   FirefoxDriver driver = new FirefoxDriver();
		                   
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
