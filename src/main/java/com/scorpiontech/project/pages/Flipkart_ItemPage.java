package com.scorpiontech.project.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_ItemPage {

	public static WebDriver driver;

	@FindBy(xpath="//div[.='APPLE iPhone 12 Pro (Graphite, 256 GB)']")
	private WebElement clkItem;

	@FindBy(xpath="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	private WebElement clkAddtoCart;

	@FindBy(xpath="//span[.='Place Order']")
	private WebElement clkPlaceOrder;

	@FindBy(xpath="//*[@id=\"ADD14341863607372310\"]/span")
	private WebElement selAdd;

	@FindBy(xpath="//button[.='Deliver Here']")
	private WebElement clkDel;

	@FindBy(xpath="//button[.='CONTINUE']")
	private WebElement clkCont;

	@FindBy(xpath="//button[.='Accept & Continue']")
	private WebElement clkAccept;

	public Flipkart_ItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void scroll_Item() throws IOException {
		//String currentWin1 = driver.getWindowHandle();
		//System.out.println(currentWin1);
		//		int xaxis = clkItem.getLocation().getX();
		//		int yaxis = clkItem.getLocation().getY();
		//		System.out.println(xaxis);
		//		System.out.println(yaxis);
		//		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
		//		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clkItem);
		Actions actions = new Actions(driver);
		actions.moveToElement(clkItem);
		actions.perform();

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(800,1500)");
		TakesScreenshot ts = (TakesScreenshot)jse;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./photo/parag.png");
		FileUtils.copyFile(src, des);
	}

	public void sel_Item() throws InterruptedException {
		clkItem.click();
		Thread.sleep(4000);
	}

	public void switchWin() {


	}

	public void Order_Item() {
		clkAddtoCart.click();
		selAdd.click();
		clkDel.click();
		clkCont.click();
		clkAccept.click();
	}

}
