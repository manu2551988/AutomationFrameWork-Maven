package frames;

import browser_setups.BrowserSimple;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Assig_4 extends BrowserSimple{
	
	public static void main(String[] args) throws InterruptedException{

		browserSetup("chrome", "https://www.selenium.dev");
		
		WebElement clkDown = driver.findElement(By.xpath("//nav[@id='navbar']/a[.='Downloads']"));
		clkDown.click();
		
		int yAxis = driver.findElement(By.xpath("//td[.='Java']")).getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+yAxis+")");
		
		WebElement clkAPI = driver.findElement(By.xpath("//td[.='Java']/following-sibling::td[5]/a[.='API Docs']"));
		clkAPI.click();
		
		//Here All Frames are Sibling frames not parent child frames
		WebElement pkgFrame = driver.findElement(By.name("packageFrame"));
		WebElement abstFrame = driver.findElement(By.name("classFrame"));
		WebElement pkglstFrame = driver.findElement(By.name("packageListFrame"));
		WebElement cndFrame = driver.findElement(By.name("packageFrame"));
		WebElement staticFrame = driver.findElement(By.name("classFrame"));
		
		driver.switchTo().frame(pkgFrame);
				
		WebElement clkAbs = driver.findElement(By.xpath("//a[.='AbstractAnnotations']"));
		clkAbs.click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(abstFrame);
		
		Thread.sleep(1000);
		
		WebElement clkAnn = driver.findElement(By.xpath("//span/a[contains(.,'AbstractAnnotations')]"));
		clkAnn.click();
		WebElement txtBuild = driver.findElement(By.xpath("//h3[.='Method Detail']/../ul/li/pre[contains(.,'buildBy')]"));
		String txtAnn = txtBuild.getText();
		System.out.println(txtAnn);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(pkglstFrame);
		
		WebElement clkLink = driver.findElement(By.xpath("//a[.='com.thoughtworks.selenium.condition']"));
		clkLink.click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(cndFrame);
		
		Thread.sleep(1000);
		
		WebElement clkCondn = driver.findElement(By.xpath("//span[.='ConditionRunner']"));
		clkCondn.click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(staticFrame);
		
		Thread.sleep(1000);
		
		WebElement getTxt = driver.findElement(By.xpath("//code[contains(.,'static')]"));
		String txtStatic = getTxt.getText();
		System.out.println(txtStatic);
		
		driver.close();
		
	}

}
