package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import lib.BaseTest;

public class DemoFlip extends BaseTest{
	
	@Test
	public void TC_01() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(3000);
		WebElement mouseHover = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[5]/a/div[1]/div/img"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(mouseHover).perform();

		driver.findElement(By.name("q")).sendKeys("iPhone 12 pro max", Keys.ENTER);

	}

}
