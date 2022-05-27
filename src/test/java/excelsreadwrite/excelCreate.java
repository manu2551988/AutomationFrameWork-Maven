package excelsreadwrite;

import lib.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class excelCreate extends BaseTest {

    @Test
    public void TC_01(){

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> countList = driver.findElements(By.xpath("//*[@id=\"navFooter\"]/div[4]/ul/li[1]/a"));

        int len=countList.size();

        for(int i=0;i<len;i++) {

            String data =countList.get(i).getText();

            try {
                FileInputStream fis = new FileInputStream("/Users/manukakk/Documents/test.xlsx");
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet("test");
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(2);
                cell.setCellValue(data);
                FileOutputStream fos = new FileOutputStream("/Users/manukakk/Documents/test.xlsx");
                wb.write(fos);
                fos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

