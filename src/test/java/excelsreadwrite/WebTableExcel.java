package excelsreadwrite;

import lib.BaseTest;
import lib.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExcel extends BaseTest {

    @Test
    public void TC_01() {

        driver.get("https://www/amazon.in");
        List<WebElement> countList = driver.findElements(By.xpath("//*[@id=\"navFooter\"]/div[4]/ul/li[1]/a"));

        List<WebElement> amazonList = driver.findElements(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[5]/ul/li/a"));

        int countlen = countList.size();
        int amazonlen = amazonList.size();

        ExcelUtil.setExcelFileSheet("TestData");
        ExcelUtil.setCellData("Hi",1,1);




    }
}
