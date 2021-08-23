package practice_programs;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import browser_setups.BrowserSetup;

public class Assig_1 extends BrowserSetup{
	
		
	@Test
	public void TC_01() throws InterruptedException {
		//WAS to clear the data which is present in inside the textbox?
					
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
		WebElement user = driver.findElement(By.id("t1"));
		user.sendKeys("manu2551988");
		
		Thread.sleep(3000);
		user.clear();
		WebElement pass=driver.findElement(By.id("t2"));
		pass.sendKeys("manu2551988");
		Thread.sleep(3000);
		pass.clear();
		driver.close();
		
	}
	
	@Test
	public void TC_02() throws InterruptedException {
		//WAS to clear the data which is present in inside the textbox without using clear() method?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
		WebElement user = driver.findElement(By.id("t1"));
		user.sendKeys("manu2551988");
		user.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(3000);
		//driver.navigate().refresh();
		WebElement pass=driver.findElement(By.id("t2"));
		pass.sendKeys("manu2551988");
		pass.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(3000);
		//driver.navigate().refresh();
		driver.close();
		
	}
	
	@Test
	public void TC_03() throws InterruptedException {
		//WAS to copy the data present in one textbox and paste it in another textbox?
		
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
		WebElement user = driver.findElement(By.id("t1"));
		user.sendKeys("manu2551988",Keys.CONTROL+"ac");
		Thread.sleep(3000);
		//WebElement userfill = driver.findElement(By.id("t1"));
		//String copypaste=userfill.getText();
		WebElement pass=driver.findElement(By.id("t2"));
		pass.sendKeys(Keys.CONTROL+"v");
		Thread.sleep(3000);
		driver.close();
		
	}
	
	@Test
	public void TC_04() throws InterruptedException {
		//WAS to clear the data which is present inside the textbox without using shortkeys?
		
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
			
		WebElement userfill = driver.findElement(By.id("t1"));
		userfill.sendKeys("manu2551988");
		Thread.sleep(3000);
		userfill.clear();
		userfill.sendKeys("manu2551988");
		driver.navigate().refresh();
		WebElement pass=driver.findElement(By.id("t2"));
		pass.sendKeys("manu2551988");
		Thread.sleep(3000);
		pass.clear();
		pass.sendKeys("manu2551988");
		driver.navigate().refresh();
		driver.close();
		
	}
	
	@Test
	public void TC_05() throws InterruptedException {
		//WAS to find the x and y co-ordinate of the textbox(element)?
		
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");		
		WebElement userfill = driver.findElement(By.id("t1"));
		int valuex = userfill.getLocation().getX();
		int valuey = userfill.getLocation().getY();
		System.out.println("X and Y Co-ordinate of text box are----->"+userfill.getLocation());
		System.out.println("X Co-ordinate of text box are----->"+valuex);
		System.out.println("Y Co-ordinate of text box are----->"+valuey);
		
		driver.close();
		
	}
	
	@Test
	public void TC_06() throws InterruptedException {
		//WAS to find the height and width of the textbox(element)?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");		
		WebElement userfill = driver.findElement(By.id("t1"));
		int height = userfill.getSize().getHeight();
		int width = userfill.getSize().getWidth();
		System.out.println("Height and width of text box is----->"+userfill.getSize());
		System.out.println("Height of text box is----->"+height);
		System.out.println("Width of text box is----->"+width);
		
		driver.close();
		
	}
	
	@Test
	public void TC_07() throws InterruptedException {
		//WAS to find whether the element is Displayed or not?
		
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");		
		WebElement user = driver.findElement(By.id("t6"));
		
		if (user.isDisplayed()) {
			System.out.println("Textbox is Displayed");
			
		}
		else {
			System.out.println("Textbox is NOT Displayed");
		}
		driver.close();
		
	}
	
	
	@Test
	public void TC_08() throws InterruptedException {
		//WAS to find whether element is Enabled or not?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");		
		WebElement pass = driver.findElement(By.id("t6"));
		
		if (pass.isEnabled()) {
			System.out.println("Textbox is Enabled");
			
		}
		else {
			System.out.println("Textbox is NOT Enabled");
		}
		driver.close();
		
	}
	
	@Test
	public void TC_09() throws InterruptedException {
		//WAS to find whether checkbox is Selected or not?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");		
		WebElement check = driver.findElement(By.id("t3"));
		//check.click();
		
		if (check.isSelected()) {
			System.out.println("Textbox is Selected");
			
		}
		else {
			System.out.println("Textbox is NOT Selected");
		}
		driver.close();
		
	}
	
	@Test
	public void TC_10() throws InterruptedException {
		//WAS to get the text content of the link text?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");		
		WebElement link = driver.findElement(By.name("link"));
		String txt = link.getText();
		System.out.println("Text Content of link text is--->"+txt);
		
		driver.close();
		
	}
	
	@Test
	public void TC_11() throws InterruptedException {
		//WAS to print tagname of logo?
		
		driver.get("https://www.flipkart.com/");		
		WebElement link = driver.findElement(By.xpath("//img[@class='_1e_EAo']"));
		String tagname = link.getTagName();
		System.out.println("Tagname of the logo is---->"+tagname);
		
		driver.close();
		
	}
	
	@Test
	public void TC_12() throws InterruptedException {
		//WAS to retrive the data/properties of the textbox?
		
		driver.get("https://www.flipkart.com");		
		WebElement link = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		String data = link.getAttribute("title");
		System.out.println("Data/Properties of the textbox---->"+data);
		
		driver.close();
		
	}
	@Test
	public void TC_13() throws InterruptedException {
		//WAS to click on the button without using click() method?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
		Thread.sleep(3000);
		WebElement click = driver.findElement(By.id("clkbutton"));
		click.sendKeys(Keys.ENTER);
		//click.submit();
		// Submit() method only works only if the attribute type should be submit
		// and it should be present inside the form tag
		Thread.sleep(3000);
		
		driver.close();
		
	}
	
	@Test
	public void TC_14() throws InterruptedException {
		//WAS to get the title of webpage without using getTitle() method?
		
		driver.get("https://www.flipkart.com");
		Thread.sleep(2000);
		WebElement Title = driver.findElement(By.tagName("title"));
		String pageTitle = Title.getAttribute("textContent");
//		System.out.println("Title of given WebPage is---->"+pageTitle);
//		WebElement pgtitle = driver.findElement(By.xpath("//meta[@name='og_title']"));
//		System.out.println("Title of given WebPage is---->"+pgtitle.getAttribute("content"));
		System.out.println("Title of given WebPage is---->"+pageTitle);
		Thread.sleep(3000);
		
		driver.close();
		
	}
	@Test
	public void TC_15() throws InterruptedException {
		//WAS to clear the data present inside the textbox without using clear() and shortkey?

		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
		WebElement userfill = driver.findElement(By.id("t1"));
		userfill.sendKeys("manu2551988");
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('t1').value=''");
		
		driver.close();
		
	}
	@Test
	public void TC_16() {
		//WAS to close multiple browsers if any?

		driver.get("https://www.naukri.com/");
		driver.quit();
				
	}
	@Test
	public void TC_17() throws InterruptedException {
		//WAS to close all browsers without using quit() method?
	
		driver.get("https://www.naukri.com/");
		Set<String> wincount = driver.getWindowHandles();
		
		ArrayList<String> array=new ArrayList<String>(wincount);
		for (Object object : array) {
			System.out.println("Session ID of Windows are--->"+object);
			
		}
		String parentbrow=array.get(0);
		String childbrow=array.get(1);
		driver.switchTo().window(childbrow);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentbrow);
		driver.close();
		
		
				
	}
	
	@Test
	public void TC_18() throws InterruptedException {
		//WAS to close only Parent browsers except Child browser?

		driver.get("https://www.naukri.com/");
		Set<String> wincount = driver.getWindowHandles();
		
		ArrayList<String> array=new ArrayList<String>(wincount);
		for (Object object : array) {
			System.out.println("Session ID of Windows are--->"+object);
			
		}
		String parentbrow=array.get(0);
		/*
		 * String childbrow=array.get(1); driver.switchTo().window(childbrow);
		 * driver.close(); Thread.sleep(2000);
		 */
		driver.switchTo().window(parentbrow);
		driver.close();
		
	}
	
	@Test
	public void TC_19() throws InterruptedException {
		//WAS to close only Child browsers except Parent browser?
	
		driver.get("https://www.naukri.com/");
		Set<String> wincount = driver.getWindowHandles();
		
		ArrayList<String> array=new ArrayList<String>(wincount);
		for (Object object : array) {
			System.out.println("Session ID of Windows are--->"+object);
			
		}
//		String parentbrow=array.get(0);
		String childbrow=array.get(1);
		driver.switchTo().window(childbrow);
		driver.close(); 		 
//		driver.switchTo().window(parentbrow);
//		driver.close();
						
	}
	
	@Test
	public void TC_20() throws InterruptedException, AWTException {
		//WAS to close only specific browser?
		
		driver.get("https://www.naukri.com/");
		Set<String> wincount = driver.getWindowHandles();
		
		ArrayList<String> array=new ArrayList<String>(wincount);
		for (Object object : array) {
			System.out.println("Session ID of Windows are--->"+object);
			
		}
		String parentbrow=array.get(0);
		String childbrow=array.get(1);
		driver.switchTo().window(childbrow);
		driver.close(); 		 
		driver.switchTo().window(parentbrow);
		//driver.close();
						
	}
	
	@Test
	public void TC_21() throws IOException {
		//WAS to TakeScreenShot of the WebPage?
		
		driver.get("https://www.amazon.in");
		
		//TypeCasting from WebDriver to TakeScreenshot Interface
		TakesScreenshot shot=(TakesScreenshot)driver;
		//Capture the photo and store it in temp file
		File src=shot.getScreenshotAs(OutputType.FILE);
		//Create one file inside the photo folder
		File desc=new File("./target/"+System.currentTimeMillis()+".png");
		//Copy file from srcfile to desc file
		FileUtils.copyFile(src, desc);
		
		driver.close();
				
	}
	
	@Test
	public void TC_22() throws Exception {
		//WAS to handle the disabled element?
	
		driver.get("C:\\Users\\warlo\\Desktop\\UN PW.html");
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('t5').value='manu2551988'");
		
		jse.executeScript("document.getElementById('t6').value='manu2551988'");
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
	
	@Test
	public void TC_23() throws Exception {
		//WAS to move scroll bar to specific element position?

		driver.get("http://localhost/login.do");
		driver.findElement(By.id("licenseLink")).click();
		Set<String> whs = driver.getWindowHandles();
		int count1 = whs.size();
		System.out.println("After Clicking on the view licences link---> "+count1);
		
		for(String w:whs)
		{
			driver.switchTo().window(w);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals("actiTIME License Agreement"))
			{
				driver.manage().window().maximize();
				WebElement paragraph = driver.findElement(By.xpath("//h2[text()='12. Export Controls']"));
				int yaxis = paragraph.getLocation().getY();
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,"+yaxis+")");
				
				TakesScreenshot ts = (TakesScreenshot)jse;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File des = new File("./target/parag.png");
				FileUtils.copyFile(src, des);
			}
		}
		
	}
	
	@Test
	public void TC_24() throws Exception {
		//WAS for following scenario
			//	Open the browser
			// 	Enter the Actitime URL
			// 	Click on Actitime Icon
			//  Click on try for free button and get the title of webpage
			//  Close all browser

		driver.get("http://localhost/login.do");
		WebElement clk = driver.findElement(By.xpath("//a[.='actiTIME Inc.']"));
		clk.click();
		Set<String> tab = driver.getWindowHandles();
		int count = tab.size();
		System.out.println("Count of tabs--->"+count);
		for (String string : tab) {
			
			driver.switchTo().window(string);
			String actualTitle = driver.getTitle();
			//we compare title to switch to desired window using driver.switchTo.window(string)
			//it will switch to only window where title will match
			if (actualTitle.equals("actiTIME - Time Tracking Software for Boosting Your Business")) {
				WebElement tryfree = driver.findElement(By.xpath("//a[.='Try Free']"));
				tryfree.click();
				System.out.println("Page Title of current page is--->"+driver.getTitle());
			}
		}
		driver.close();
	}
	
	@Test
	public void TC_25() throws Exception {
		//WAS for following scenario
				//	Open the browser
				// 	Enter the Myntra Application URL
				// 	Find the SearchBox
				//  Enter the Specific Item and click on Search
				//  Select the size of item which you already selected
	
		driver.get("https://www.myntra.com/");
		String ptab = driver.getWindowHandle();
		WebElement search = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		search.sendKeys("T-Shirt");
		WebElement clksrh = driver.findElement(By.xpath("//a[@class='desktop-submit']/span"));
		clksrh.click();
		Thread.sleep(3000);
		WebElement prod = driver.findElement(By.xpath("//img[@title='Roadster Men Brown Printed Round Neck T-shirt']"));
		prod.click();
		
		Set<String> tabs = driver.getWindowHandles();
		int count = tabs.size();
		System.out.println("Total Count of tabs--->"+count);

		 for(String tab:tabs)
		 {
			driver.switchTo().window(tab);
			if(ptab.equals(tab))
			{
				driver.close();
			}
			else
			{
				WebElement size = driver.findElement(By.xpath("//p[text()='L']/ancestor::div[@class='size-buttons-buttonContainer']"));
				size.click();
			}
		 }
		
	}
	
}
