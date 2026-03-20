package lib;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Utility class for common WebDriver interactions:
 * dropdowns, mouse actions, frames, alerts, windows, scrolling, JS execution.
 */
public class WebDriverDriverUtilies {

    // --- Dropdown ---

    public static void selectByVisibleText(WebElement ele, String text) {
        new Select(ele).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement ele, String value) {
        new Select(ele).selectByValue(value);
    }

    public static void selectByIndex(WebElement ele, int index) {
        new Select(ele).selectByIndex(index);
    }

    public static List<String> getDropdownOptions(WebElement ele) {
        List<String> options = new ArrayList<>();
        new Select(ele).getOptions().forEach(opt -> options.add(opt.getText()));
        return options;
    }

    // --- Mouse Actions ---

    public static void mouseHover(WebDriver driver, WebElement ele) {
        new Actions(driver).moveToElement(ele).perform();
    }

    public static void rightClick(WebDriver driver, WebElement ele) {
        new Actions(driver).contextClick(ele).perform();
    }

    public static void doubleClick(WebDriver driver, WebElement ele) {
        new Actions(driver).doubleClick(ele).perform();
    }

    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    // --- Frames ---

    public static void switchToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToFrame(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public static void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // --- Alerts ---

    public static void acceptAlert(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public static void sendKeysToAlert(WebDriver driver, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    // --- Window / Tab Handling ---

    public static void switchToNewWindow(WebDriver driver) {
        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }

    public static void switchToWindowByTitle(WebDriver driver, String title) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) return;
        }
    }

    public static void closeAllExceptParent(WebDriver driver, String parentHandle) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
    }

    // --- Scrolling ---

    public static void scrollBy(WebDriver driver, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    // --- JavaScript Utilities ---

    public static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red'", element);
    }

    // Backward compat instance methods
    public void dropDown(WebElement ele, String text) { selectByVisibleText(ele, text); }
    public void mouseHover(WebElement ele) { mouseHover(BaseTest.driver, ele); }
    public void scrollBar(WebDriver driver, int x, int y) { scrollBy(driver, x, y); }
}
