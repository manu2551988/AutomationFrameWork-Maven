package screenshot;

import init.IAutoConstant;
import lib.BaseTest;
import lib.BaseTestMulti;
import lib.ElementUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot_WebPage extends BaseTestMulti {

    @Test
    public void TakesScreenshot_WebPage(){


        driver.get("https://www.google.com");
        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("Asus Gaming Laptop", Keys.ENTER);

        String fileName=this.getClass().getSimpleName();
        DateFormat dateFormat=new SimpleDateFormat("dd-mm-yy hh-mm-ss aa");
        Date date=new Date();

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File des=new File(IAutoConstant.screenShotPath+fileName+"-"+dateFormat.format(date)+".png");
        try {
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
