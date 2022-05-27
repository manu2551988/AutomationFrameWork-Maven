package lib;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelWriteByColn {

    private Workbook workbook;
    private FileInputStream fin;
    private Sheet sheet;
    private Cell cell;
    private Row row;
    private CellStyle cellStyle;
    private Map<String, Integer> columns = new HashMap<>();
    private String excelPath;


    /**
     * @param ExcelPath
     * @param sheetName
     * @Author: Manu Kakkar
     * Description: Method to set Excel Path
     */
    public void setExcelFile(String ExcelPath, String sheetName,int row,int cellNum) {
        try {
            FileInputStream fin = new FileInputStream(ExcelPath);
            workbook = WorkbookFactory.create(fin);
            sheet = workbook.getSheet(sheetName);
            this.excelPath = ExcelPath;
            sheet.getRow(row).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
