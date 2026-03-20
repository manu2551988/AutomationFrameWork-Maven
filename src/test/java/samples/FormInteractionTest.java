package samples;

import lib.BaseTest;
import lib.WebDriverDriverUtilies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * Sample: Demonstrates dropdown, checkbox, radio button, and form interactions.
 */
public class FormInteractionTest extends BaseTest {

    private static final String PRACTICE_URL = "https://the-internet.herokuapp.com";

    @Test(description = "Handle dropdown selection")
    public void testDropdown() {
        driver.get(PRACTICE_URL + "/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        WebDriverDriverUtilies.selectByVisibleText(dropdown, "Option 1");

        List<String> options = WebDriverDriverUtilies.getDropdownOptions(dropdown);
        Reporter.log("Available options: " + options, true);
        Assert.assertTrue(options.contains("Option 1"));
    }

    @Test(description = "Handle checkboxes")
    public void testCheckboxes() {
        driver.get(PRACTICE_URL + "/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement cb : checkboxes) {
            if (!cb.isSelected()) cb.click();
        }

        checkboxes.forEach(cb -> Assert.assertTrue(cb.isSelected(), "All checkboxes should be selected"));
        Reporter.log("All checkboxes selected successfully", true);
    }

    @Test(description = "Handle JavaScript alerts")
    public void testJSAlert() {
        driver.get(PRACTICE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        WebDriverDriverUtilies.acceptAlert(driver);

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
        Reporter.log("Alert handled: " + result, true);
    }

    @Test(description = "Handle JavaScript confirm dialog")
    public void testJSConfirm() {
        driver.get(PRACTICE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        WebDriverDriverUtilies.dismissAlert(driver);

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test(description = "Handle JavaScript prompt")
    public void testJSPrompt() {
        driver.get(PRACTICE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        WebDriverDriverUtilies.sendKeysToAlert(driver, "Hello Selenium");

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: Hello Selenium");
    }

    @Test(description = "Handle hover actions")
    public void testMouseHover() {
        driver.get(PRACTICE_URL + "/hovers");

        List<WebElement> figures = driver.findElements(By.className("figure"));
        WebDriverDriverUtilies.mouseHover(driver, figures.get(0));

        WebElement caption = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(
                        figures.get(0).findElement(By.className("figcaption"))));

        Assert.assertTrue(caption.isDisplayed(), "Caption should appear on hover");
        Reporter.log("Hover caption: " + caption.getText(), true);
    }
}
