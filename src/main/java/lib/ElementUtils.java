package lib;

import init.IAutoConstant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Utility class for common WebDriver element operations:
 * screenshots, waits, page title verification.
 */
public class ElementUtils implements IAutoConstant {

    private static WebDriver driver() {
        return BaseTest.getDriver() != null ? BaseTest.getDriver() : BaseTest.driver;
    }

    // --- Explicit Wait Helpers ---

    public static WebElement waitForClickable(WebElement element) {
        return new WebDriverWait(driver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisible(WebElement element) {
        return new WebDriverWait(driver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForPresence(By locator) {
        return new WebDriverWait(driver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForTitle(String expectedTitle) {
        return new WebDriverWait(driver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.titleContains(expectedTitle));
    }

    // --- Page Title Verification ---

    public static void chkPageTitle(String expectedPT) {
        waitForTitle(expectedPT);
        String actualPT = driver().getTitle();
        if (actualPT.contains(expectedPT)) {
            Reporter.log("Expected Page is Displayed --> " + actualPT, true);
        } else {
            Reporter.log("Expected Page is NOT Displayed --> " + actualPT, true);
        }
    }

    // --- Screenshot Methods ---

    public static void takeScreenShot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(SCREENSHOT_PATH + name + ".png"));
            Reporter.log("Screenshot taken: " + name, true);
        } catch (Exception e) {
            Reporter.log("Screenshot failed: " + e.getMessage(), true);
        }
    }

    public static void takeScreenShotResult(WebDriver driver, String path) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            Reporter.log("Screenshot failed: " + e.getMessage(), true);
        }
    }

    public static void takeWebElementScreenShot(WebElement element, String fileName) {
        String timestamp = new SimpleDateFormat("dd-MM-yy_hh-mm-ss_aa").format(new Date());
        try {
            File src = element.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(WEB_ELEM_SCREENSHOT_PATH + fileName + "-" + timestamp + ".png"));
        } catch (IOException e) {
            Reporter.log("Element screenshot failed: " + e.getMessage(), true);
        }
    }

    public static String takeScreenShotAsBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
