package methodsofwebdriver;

import browser_setups.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class BrowserSwitch extends BrowserSetup {
	
	
	@Test
	public void Browser() throws InterruptedException {
		
		
		driver.get("https://www.myntra.com/");
		WebElement search = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		search.sendKeys("T-Shirts");
		WebElement clksrh = driver.findElement(By.xpath("//a[@class='desktop-submit']/span"));
		clksrh.click();
		Thread.sleep(3000);
		WebElement prod = driver.findElement(By.xpath("//h4[.='All-Over-Printed T-shirt']"));
		prod.click();
		
		Set<String> wind = driver.getWindowHandles();
		
		ArrayList<String> array=new ArrayList<String>(wind);
		for (String string : array) {
			System.out.println("Session ID's of window's are--->"+string);
			
		}
		
		String curtwind = driver.getWindowHandle();
		System.out.println("Current Window Session ID--->"+curtwind);
		
		String primwin=array.get(0);
		String secwin=array.get(1);
		
		driver.switchTo().window(secwin);
		
		WebElement select = driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/div[2]/div[3]/div[1]/button"));
		select.click();
		driver.close();
		
		driver.switchTo().window(primwin);
		driver.close();
		
	}

}
