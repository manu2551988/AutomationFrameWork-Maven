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
import java.util.Set;

/**
 * Sample: Demonstrates frames, windows/tabs, and iframe handling.
 */
public class FrameAndWindowTest extends BaseTest {

    private static final String PRACTICE_URL = "https://the-internet.herokuapp.com";

    @Test(description = "Switch between iframes")
    public void testIframeHandling() {
        driver.get(PRACTICE_URL + "/iframe");

        WebDriverDriverUtilies.switchToFrame(driver, "mce_0_ifr");

        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Typed inside iframe");

        Assert.assertEquals(editor.getText(), "Typed inside iframe");
        Reporter.log("Successfully typed inside iframe", true);

        WebDriverDriverUtilies.switchToDefaultContent(driver);
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }

    @Test(description = "Handle nested frames")
    public void testNestedFrames() {
        driver.get(PRACTICE_URL + "/nested_frames");

        WebDriverDriverUtilies.switchToFrame(driver, "frame-top");
        WebDriverDriverUtilies.switchToFrame(driver, "frame-middle");

        String text = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(text, "MIDDLE");
        Reporter.log("Nested frame content: " + text, true);

        WebDriverDriverUtilies.switchToDefaultContent(driver);
    }

    @Test(description = "Handle multiple windows")
    public void testMultipleWindows() {
        driver.get(PRACTICE_URL + "/windows");

        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        WebDriverDriverUtilies.switchToNewWindow(driver);
        Assert.assertEquals(driver.getTitle(), "New Window");
        Reporter.log("New window title: " + driver.getTitle(), true);

        driver.close();
        driver.switchTo().window(parentHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }

    @Test(description = "Handle dynamic content loading")
    public void testDynamicLoading() {
        driver.get(PRACTICE_URL + "/dynamic_loading/1");

        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        Assert.assertEquals(result.getText(), "Hello World!");
        Reporter.log("Dynamic content loaded: " + result.getText(), true);
    }
}
