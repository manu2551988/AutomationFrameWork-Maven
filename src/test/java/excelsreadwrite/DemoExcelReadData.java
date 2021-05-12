package excelsreadwrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Read the String Data
 * @author Sunil
 *
 */
public class DemoExcelReadData {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
//		Workbook wb = WorkbookFactory.create(new FileInputStream());
//		Sheet s = wb.getSheet("sheet1");
//		Row r = s.getRow(1);
//		Cell c = r.getCell(0);
//		String data = c.getStringCellValue();
//		System.out.println(data);
		
//		Cell c = wb.getSheet("sheet1").getRow(1).getCell(1);
//		String s = c.getStringCellValue();
//		System.out.println(s);
		
//		String s = wb.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
//		System.out.println(s);

	}

}
