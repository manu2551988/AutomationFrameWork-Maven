package com.scorpiontech.project.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.xpath("//nav[@id='navbar']/a[.='Downloads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='3.141.59']")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
