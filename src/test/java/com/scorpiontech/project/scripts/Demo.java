package com.scorpiontech.project.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.scorpiontech.project.lib.BaseTest;

public class Demo extends BaseTest{
	
	@Test
	public void TC_01() throws InterruptedException
	{
		String URL="https://www.flipkart.com/";
		driver.get(URL);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("Manu Kakkar");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("abc");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		
	}
	

}
