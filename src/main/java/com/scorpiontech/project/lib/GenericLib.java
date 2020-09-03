package com.scorpiontech.project.lib;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.scopiontech.project.init.IAutoConstant;

public class GenericLib {

	public static Workbook workbook;

	/**
	 * Author: Manu Kakkar Description: To read the Data from Excel Sheet
	 * 
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
	 * Author: Manu Kakkar Description: To read the Data from Excel Sheet from a
	 * specific path of file
	 * 
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
	 * @Author:Manu Kakkar Description: To write the Data in Excel Sheet
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * 
	 */

	public static void createCell(String path, String sheetName, int rowNo, int cellNo, String data) {
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
	 * @Author:Manu Kakkar Description:To read expected result from the Excel file
	 *              by splitting the input
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

	public static String getExpectedIndex1(String sheet, int row, int col) {
		String data = getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[1];
	}

	/**
	 * Author: Manu Kakkar Description: To read the total number of Rows in Excel
	 * Sheet
	 * 
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
	 * @Author:Manu Kakkar Description:To read Data from the Excel file of any kind
	 *              by converting it String
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
	 * @Author:Manu Kakkar Description:To read the Data from Property File
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
	 * @Author:Manu Kakkar Description:To take the ScreenShot of browser
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
		}

	}

	/**
	 * @Author:Manu Kakkar Description:To take the ScreenShot of browser by failed
	 *              test cases
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
	 * @Author:Manu Kakkar Description: To read data in the XML file
	 * @param path
	 * @return
	 * @throws IOException
	 * 
	 */

	public static String readXML(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}