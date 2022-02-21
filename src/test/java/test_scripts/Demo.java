package test_scripts;

import lib.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Demo extends BaseTest{
	
	@Test
	public void TC_01() throws InterruptedException
	{
		String URL="https://www.flipkart.com/";
		driver.get(URL);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("manu2551988@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("qweasd123!");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		WebElement srch=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
		srch.sendKeys("iPhone 12 Pro 128GB");
		Thread.sleep(3000);
		srch.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}
	

}
