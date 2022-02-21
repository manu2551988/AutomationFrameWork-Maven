package excelsreadwrite;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoCreateExcelData {

    public static Workbook wb;

    public static void createSheet(String path, String sheetName) {
        try {
            wb = WorkbookFactory.create(new FileInputStream(path));
		 wb.createSheet(sheetName);
		 
		 wb.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void createRow(String path,String sheetName,int rowNo)
	{
		try
		{
		 wb = WorkbookFactory.create(new FileInputStream(path));
		 wb.getSheet(sheetName).createRow(rowNo);
		 
		 wb.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void createCell(String path,String sheetName,int rowNo,int cellNo,String data)
	{
		try
		{
		 wb = WorkbookFactory.create(new FileInputStream(path));
		 Cell c = wb.getSheet(sheetName).getRow(rowNo).createCell(cellNo);
		 c.setCellValue(data);
		 
		 wb.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException
	{		
//		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/input.xlsx"));
//		createSheet("./data/input.xlsx","Suni");	
//		createRow("./data/input.xlsx","Suni",0);
		createCell("./data/input.xlsx","Suni",0,0,"SUNIL KUMAR");
		
		
	}

}
