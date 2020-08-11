package com.tyss.project.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

//import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.tyss.project.init.IConstants;

public class GenericLib {
	
	/*
	 * 
	 * @Author:Manu Kakkar
	 * 
	 * Description:To read data from ExcelSheet
	 * 
	 */
	
	public static Workbook workbook;
	
	public static String getExcelData(String sheet,int row,int col) 
	{
		String data=null;
		try {
			FileInputStream fin=new FileInputStream(IConstants.EfilePath);
			workbook=WorkbookFactory.create(fin);
			Sheet sht=workbook.getSheet(sheet);
			Cell cl=sht.getRow(row).getCell(col);
			data=cl.getStringCellValue();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return data;
		
	}
	
	/*
	 * 
	 * @Author:Manu Kakkar
	 * 
	 * Description:To write data from ExcelSheet
	 * 
	 */
	
	public static void createCell(String path,String sheetName,int rowNo,int cellNo,String data)
	{
		try
		{
		 workbook = WorkbookFactory.create(new FileInputStream(path));
		 Cell c = workbook.getSheet(sheetName).getRow(rowNo).createCell(cellNo);
		 c.setCellValue(data);
		 
		 workbook.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/*
	 * @Author:Manu Kakkar
	 * 
	 * Description:To read expected result from the Excel file by splitting the input
	 * 
	 */
	
	public static String getExpected(String sheet,int row,int col) {
		String data=getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[0];
	}
	public static String getExpectedIndex1(String sheet,int row,int col) {
		String data=getExcelData(sheet, row, col);
		String[] eData = data.split("-");
		return eData[1];
	}
	
	/*
	 * @Author:Manu Kakkar
	 * 
	 * Description:To read data from the Excel file of any kind by converting it Strong 
	 * 
	 */
	
	
	public static String getCellNumData(String sheet,int row,int col)
	{
		String data=null;
		try {
			FileInputStream fin=new FileInputStream(IConstants.EfilePath);
			Workbook workbook=WorkbookFactory.create(fin);
			Sheet sht=workbook.getSheet(sheet);
			Cell cl=sht.getRow(row).getCell(col);
			data=cl.toString();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return data;		
	}
	
	/*
	 * @Author:Manu Kakkar
	 * 
	 * Description:To read the data from Property File
	 * 
	 */
	
	public static String getPropData(String key) {
		
		String data=null;		
		try {
			Properties prop=new Properties();
			FileInputStream fin=new FileInputStream(IConstants.PfilePath);
			prop.load(fin);
			data=prop.getProperty(key);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	
	/*
	 * @Author:Manu Kakkar
	 * 
	 * Description:To take the ScreenShot of browser
	 *  
	 */
	
	public static void takeScreenShot(WebDriver driver,String name) {
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			Reporter.log("Taking the Screenhot of"+name);
			File desc=new File(IConstants.screenShotPath+name+".png");
			FileUtils.copyFile(src, desc);						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
