package jfs;

import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTestSele {
	static
	{
		System.out.println("Shivangi");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
//		String key="webdriver.chrome.driver";
//		String value="./driver/chromedriver.exe";
//		
//		System.setProperty(key, value);
		
//		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	     new  ChromeDriver();

	}

}
