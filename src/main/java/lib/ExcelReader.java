package lib;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ExcelReader {

    private Workbook workbook;
    private FileInputStream fin;
    private Sheet sheet;
    private Cell cell;
    private Row row;
    private CellStyle cellStyle;
    private Map<String, Integer> columns = new HashMap<>();
    private String excelPath;

    public static void main(String[] args) {
        ExcelReader excel = new ExcelReader();
        excel.setExcelFile("./src/test/resources/ContactUs.xlsx", "ContactUS");
        System.out.println(excel.getCellData("Subject Heading", 1));
        System.out.println(excel.getCellData("Message", 1));
        System.out.println(excel.getCellData("Order Ref", 1));
        System.out.println(excel.getCellData("Email", 1));
    }

    /**
     * @param ExcelPath
     * @param sheetName
     * @Author: Manu Kakkar
     * Description: Method to set Excel Path
     */
    public void setExcelFile(String ExcelPath, String sheetName) {
        try {
            FileInputStream fin = new FileInputStream(ExcelPath);
            workbook = WorkbookFactory.create(fin);
            sheet = workbook.getSheet(sheetName);
            this.excelPath = ExcelPath;
            sheet.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param rowNum
     * @param colNum
     * @return
     * @Author: Manu Kakkar
     * Description: Method to get Excel Data by different datatype
     */
    public String getCellData(int rowNum, int colNum) {

        try {
            cell = sheet.getRow(rowNum).getCell(colNum);
            String cellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    cellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellData = String.valueOf(cell.getDateCellValue());
                    } else {
                        cellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellData = "";
                    break;
            }
            return cellData;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @param colName
     * @param rowNum
     * @return
     * @Author: Manu Kakkar
     * Description: Method to get Excel Data using Column name
     */
    public String getCellData(String colName, int rowNum) {
        return getCellData(rowNum, columns.get(colName));
    }

}
