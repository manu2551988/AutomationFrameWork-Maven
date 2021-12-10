package lib;

import init.IAutoConstant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ElementUtils extends BaseTest {


    /**
     * @param expectedPT
     * @Author: Manu Kakkar Description: Method to verify the page titles
     * Description: Method to validate the Page Title
     */
    public static void chkPageTitle(String expectedPT) {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, 10);
        wait.until(ExpectedConditions.titleContains(expectedPT));

        String actualPT = BaseTest.driver.getTitle();
        if (actualPT.equals(expectedPT)) {
            System.out.println("Expected Page is Displayed-->" + actualPT);
        } else {
            System.out.println("Expected Page is NOT Displayed-->" + actualPT);
        }
    }

    /**
     * @param driver
     * @param name
     * @Author: Manu Kakkar
     * Description: To take the ScreenShot of browser
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
     * @param driver
     * @param path
     * @Author: Manu Kakkar
     * Description:To take the ScreenShot of browser by failed test cases
     */

    public static void takeScreenShotResult(WebDriver driver, String path) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            Reporter.log("Taking the ScreenShot");
            File desc = new File(path);
            FileUtils.copyFile(src, desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Author: Manu Kakkar
     * Description : Method to TakeScreenShot using Dynamic name for Fail Test Script
     *
     * @param fileName
     * @throws IOException
     */

    public static void getScreenShotFail(String fileName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
        Date date = new Date();
        File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(IAutoConstant.failScreenShotPath + fileName +
                "-" + dateFormat.format(date) + ".png"));
    }

    /**
     * Author: Manu Kakkar
     * Description: Method to TakeScreenShot using Dynamic name for Pass Test Script
     *
     * @param fileName
     * @throws IOException
     */
    public static void getScreenShotPass(String fileName) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
        Date date = new Date();
        File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(IAutoConstant.failScreenShotPath + fileName +
                "-" + dateFormat.format(date) + ".png"));
    }

    /**
     * Author: Manu Kakkar
     * Description: Method to TakeScreenShot at Random Point
     *
     * @param filename
     * @throws IOException
     */
    public static void getScreenShotRandom(String filename) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
        Date date = new Date();
        File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(IAutoConstant.screenShotPath + filename +
                "-" + dateFormat.format(date) + ".png"));
    }

    /**
     * Author: Manu Kakkar
     * Description: Method to TakeScreenShot of an WebElement
     *
     * @param element
     * @param fileName
     */
    public static void takeWebElementScreenShot(WebElement element, String fileName) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
        Date date = new Date();

        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File desFile = new File(IAutoConstant.screenShotPathWebElement + fileName +
                "-" + dateFormat.format(date) + ".png");
        try {
            FileUtils.copyFile(srcFile, desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
