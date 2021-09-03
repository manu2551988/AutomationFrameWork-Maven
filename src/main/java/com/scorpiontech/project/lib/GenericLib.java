package com.scorpiontech.project.lib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.scorpiontech.project.init.IAutoConstant;

public class GenericLib {

	public static Workbook workbook;

	public static int passCount = 0, failCount = 0;

	/**
	 * @param driver
	 * @param expectedPT
	 * @Author: Manu Kakkar
	 * Description: Method to verify the page titles
	 */
	public static void chkPageTitle(WebDriver driver, String expectedPT) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(expectedPT));

		String actualPT = driver.getTitle();
		if (actualPT.equals(expectedPT)) {
			System.out.println("Expected Page is Displayed-->" + expectedPT);
		} else {
			System.out.println("Expected Page is NOT Displayed-->" + actualPT);
		}
	}

	/**
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @Author: Manu Kakkar
	 * Description: To write the Data in Excel Sheet
	 */

	public static void createCell(String path, String sheetName, int rowNo, int cellNo, int data) {
		try {
			workbook = WorkbookFactory.create(new FileInputStream(path));
			Cell c = workbook.getSheet(sheetName).getRow(rowNo).createCell(cellNo);
			c.setCellValue(data);

			workbook.write(new FileOutputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @Author: Manu Kakkar
	 * Description: To read Data from the Excel file of any kind by converting it String
	 */

	public static String getCellNumData(String sheet, int row, int col) {
		String data = null;
		try {
			FileInputStream fin = new FileInputStream(IAutoConstant.EfilePath);
			Workbook workbook = WorkbookFactory.create(fin);
			Sheet sht = workbook.getSheet(sheet);
			Cell cl = sht.getRow(row).getCell(col);
			data = cl.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Author: Manu Kakkar
	 * Description: To read the Data from Excel Sheet
	 *
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 */

	public static String getExcelData(String sheet, int row, int col) {
		String data = null;
		try {
			FileInputStream fin = new FileInputStream(IAutoConstant.EfilePath);
			workbook = WorkbookFactory.create(fin);
			Sheet sht = workbook.getSheet(sheet);
			Cell cl = sht.getRow(row).getCell(col);
			data = cl.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	/**
	 * Author: Manu Kakkar
	 * Description: To read the Data from Excel Sheet from a
	 * specific path of file
	 *
	 * @param path
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 */

	public static String getExcelDataByPath(String path, String sheet, int row, int col) {
		String data = null;
		try {
			FileInputStream fin = new FileInputStream(path);
			workbook = WorkbookFactory.create(fin);
			Sheet sht = workbook.getSheet(sheet);
			Cell cl = sht.getRow(row).getCell(col);
			data = cl.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	/**
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @Author: Manu Kakkar
	 * Description: To read the Expected Result in LHS from Excel Sheet by splitting the output
	 */

	public static String getExpected(String sheet, int row, int col) {
		String data = getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[0];
	}

	/**
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @Author: Manu Kakkar
	 * Description: To read the Expected Result in RHS from Excel Sheet by splitting the output
	 */
	public static String getExpectedIndex1(String sheet, int row, int col) {
		String data = getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[1];
	}

	/**
	 * @param key
	 * @return
	 * @Author: Manu Kakkar
	 * Description: To read the Data from Property File
	 */

	public static String getPropData(String key) {

		String data = null;
		try {
			Properties prop = new Properties();
			FileInputStream fin = new FileInputStream(IAutoConstant.PfilePath);
			prop.load(fin);
			data = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	/**
	 * Author: Manu Kakkar
	 * Description: To read the total number of Rows in Excel Sheet
	 *
	 * @param path
	 * @param sheet
	 * @return
	 */

	public static int read_XL_RowCount(String path, String sheet) {
		int data = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * @param path
	 * @return
	 * @throws IOException
	 * @Author: Manu Kakkar
	 * Description: To read data in the XML file
	 */

	public static String readXML(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	/**
	 * @param driver
	 * @param name
	 * @Author: Manu Kakkar
	 * Description: To take the ScreenShot of browser
	 */

	public static void takeScreenShot(WebDriver driver, String name) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			Reporter.log("Taking the Screenhot of" + name);
			File desc = new File(IAutoConstant.screenShotPath + name + ".png");
			FileUtils.copyFile(src, desc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screenshot not taken");
		}

	}

	/**
	 * @param driver
	 * @param path
	 * @Author: Manu Kakkar
	 * Description:To take the ScreenShot of browser by failed test cases
	 */

	public static void takeScreenShotResult(WebDriver driver, String path) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			Reporter.log("Taking the Screenhot");
			File desc = new File(path);
			FileUtils.copyFile(src, desc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @throws AWTException
	 * @Author: Manu Kakkar
	 * Description: Open New Tab using Robot Class
	 */

	public static void newTab() throws AWTException {
		Robot open = new Robot();
		open.keyPress(KeyEvent.VK_CONTROL);
		open.keyPress(KeyEvent.VK_T);
		open.keyRelease(KeyEvent.VK_CONTROL);
		open.keyRelease(KeyEvent.VK_T);
	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to capture x,y coordinate of element on page
	 *
	 * @param elempath
	 */

	public static void getLocation(WebElement elempath) {
		int x = elempath.getLocation().getX();
		int y = elempath.getLocation().getY();

		System.out.println("X Coordinate" + x);
		System.out.println("Y Coordinate" + y);

		scrollToElem(x, y);
	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to navigate to location on page using Javascript
	 *
	 * @param x
	 * @param y
	 */

	public static void scrollToElem(int x, int y) {

		JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
		js.executeScript("javascript:window.scrollBy(" + x, y + ")");

	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to scroll using WebDriverWait ElementClickable
	 *
	 * @param elempath
	 */

	public static void scrollToElemWeb(WebElement elempath) {
		Actions act = new Actions(BaseTest.driver);
		act.moveToElement(new WebDriverWait(BaseTest.driver, 20).
				until(ExpectedConditions.elementToBeClickable(elempath))).build().perform();


	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method for scrolling
	 */
	public static void scrollUntilVisible() {
		((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", new WebDriverWait(BaseTest.driver, 20).
				until(ExpectedConditions.visibilityOfElementLocated(By.xpath("element"))));
	}

	/**
	 * Author: Manu Kakkar
	 * Description : Method to TakeScreenShot using Dynamic name for Fail Test Script
	 *
	 * @param fileName
	 * @throws IOException
	 */

	public static void getScreenShotFail(String fileName) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(IAutoConstant.failScreenShotPath + fileName + "-" + dateFormat.format(date) + ".png"));
	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to TakeScreenShot using Dynamic name for Pass Test Script
	 *
	 * @param fileName
	 * @throws IOException
	 */
	public static void getScreenShotPass(String fileName) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(IAutoConstant.failScreenShotPath + fileName + "-" + dateFormat.format(date) + ".png"));
	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to TakeScreenShot based on Pass/Fail Test Script
	 *
	 * @param res
	 * @throws InterruptedException
	 */

	public static void tearDown(ITestResult res) throws InterruptedException {

		int status = res.getStatus();
		String methodName = res.getName();
		if (status == 1) {
			passCount++;
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
			Date date = new Date();
			String Photo_Path = IAutoConstant.passScreenShotPath + methodName + " " + dateFormat.format(date) + ".png";
			GenericLib.takeScreenShotResult(BaseTest.driver, Photo_Path);
		} else {
			failCount++;
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
			Date date = new Date();
			String Photo_Path = IAutoConstant.failScreenShotPath + methodName + " " + dateFormat.format(date) + ".png";
			GenericLib.takeScreenShotResult(BaseTest.driver, Photo_Path);
		}
		Thread.sleep(5000);
		BaseTest.driver.close();

	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to TakeScreenShot at Random Point
	 *
	 * @param filename
	 * @throws IOException
	 */
	public static void getScreenShotRandom(String filename) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(IAutoConstant.screenShotPath + filename + "-" + dateFormat.format(date) + ".png"));
	}
}