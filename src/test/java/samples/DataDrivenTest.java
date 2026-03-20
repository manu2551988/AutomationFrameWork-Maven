package samples;

import lib.BaseTest;
import lib.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Sample: Data-driven testing using TestNG DataProvider.
 */
public class DataDrivenTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", true},
                {"invalidUser", "invalidPass", false},
                {"tomsmith", "wrongPassword", false},
        };
    }

    @Test(dataProvider = "loginData", description = "Data-driven login test")
    public void testLogin(String username, String password, boolean shouldPass) {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (shouldPass) {
            wait.until(ExpectedConditions.urlContains("/secure"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/secure"));
            Reporter.log("Login succeeded for: " + username, true);
        } else {
            WebElement flash = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            Assert.assertTrue(flash.getText().contains("invalid"),
                    "Error message should indicate invalid credentials");
            Reporter.log("Login correctly rejected for: " + username, true);
        }
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms() {
        return new Object[][]{
                {"Selenium"},
                {"Java"},
                {"TestNG"},
        };
    }

    @Test(dataProvider = "searchTerms", description = "Data-driven search test")
    public void testSearch(String term) {
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(term);
        searchBox.submit();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains(term));

        Assert.assertTrue(driver.getTitle().contains(term));
        Reporter.log("Search results loaded for: " + term, true);
    }
}
