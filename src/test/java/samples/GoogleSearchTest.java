package samples;

import lib.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Sample: Google search automation demonstrating basic Selenium operations.
 */
public class GoogleSearchTest extends BaseTest {

    @Test(description = "Verify Google search returns results")
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Selenium WebDriver"), "Title should contain search term");
        Reporter.log("Search results page title: " + title, true);
    }

    @Test(description = "Verify Google homepage title")
    public void testGoogleTitle() {
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        Reporter.log("Google homepage title: " + title, true);
        Assert.assertNotNull(title, "Title should not be null");
    }
}
