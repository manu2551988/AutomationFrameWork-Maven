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
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.scorpiontech.project.init.IAutoConstant;

public class GenericLib {

	public static Workbook workbook;

	/**
	 * @Author: Manu Kakkar
	 * Description: Method to verify the page titles
	 * @param driver
	 * @param expectedPT
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
	 * @Author: Manu Kakkar
	 * Description: To write the Data in Excel Sheet
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * 
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
	 * @Author: Manu Kakkar
	 * Description: To read Data from the Excel file of any kind by converting it String
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * 
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
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * 
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
	 * @param path
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * 
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
	 *@Author: Manu Kakkar
	 * Description: To read the Expected Result in LHS from Excel Sheet by splitting the output
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * 
	 */

	public static String getExpected(String sheet, int row, int col) {
		String data = getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[0];
	}



	/**
	 * @Author: Manu Kakkar
	 * Description: To read the Expected Result in RHS from Excel Sheet by splitting the output
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 */
	public static String getExpectedIndex1(String sheet, int row, int col) {
		String data = getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[1];
	}

	/**
	 * @Author: Manu Kakkar
	 * Description: To read the Data from Property File
	 * @param key
	 * @return
	 * 
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
	 * @param path
	 * @param sheet
	 * @return
	 * 
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
	 * @Author: Manu Kakkar
	 * Description: To read data in the XML file
	 * @param path
	 * @return
	 * @throws IOException
	 * 
	 */

	public static String readXML(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	/**
	 * @Author: Manu Kakkar
	 * Description: To take the ScreenShot of browser
	 * @param driver
	 * @param name
	 * 
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
	 * @Author: Manu Kakkar
	 * Description:To take the ScreenShot of browser by failedtest cases
	 * @param driver
	 * @param path
	 * 
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
	 * @Author: Manu Kakkar
	 * Description: Open New Tab using Robot Class
	 * @throws AWTException
	 */
	public static void newTab() throws AWTException {
		Robot open = new Robot();
		open.keyPress(KeyEvent.VK_CONTROL);
		open.keyPress(KeyEvent.VK_T);
		open.keyRelease(KeyEvent.VK_CONTROL);
		open.keyRelease(KeyEvent.VK_T);
	}

	public static WebDriver driver;

	/**
	 * Author: Manu Kakkar
	 * Description: Method to capture x,y coordinate of element on page
	 * @param elempath
	 */

	public static void getLocation(WebElement elempath){
		int x=elempath.getLocation().getX();
		int y=elempath.getLocation().getY();

		System.out.println("X Coordinate"+x);
		System.out.println("Y Coordinate"+y);
	}

	/**
	 * Author: Manu Kakkar
	 * Description: Method to navigate to location on page
	 * @param x
	 * @param y
	 */

	public static void scrollToElem(int x, int y){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy("+x,y+")");

	}
}