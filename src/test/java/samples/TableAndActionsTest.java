package samples;

import lib.BaseTest;
import lib.WebDriverDriverUtilies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Sample: Demonstrates tables, keyboard/mouse actions, and scrolling.
 */
public class TableAndActionsTest extends BaseTest {

    private static final String PRACTICE_URL = "https://the-internet.herokuapp.com";

    @Test(description = "Read data from HTML table")
    public void testTableDataExtraction() {
        driver.get(PRACTICE_URL + "/tables");

        List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tbody tr"));
        Assert.assertFalse(rows.isEmpty(), "Table should have rows");

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String lastName = cells.get(0).getText();
            String firstName = cells.get(1).getText();
            String email = cells.get(2).getText();
            Reporter.log(String.format("Name: %s %s, Email: %s", firstName, lastName, email), true);
        }
    }

    @Test(description = "Sort table by column")
    public void testTableSorting() {
        driver.get(PRACTICE_URL + "/tables");

        WebElement lastNameHeader = driver.findElement(By.cssSelector("#table1 thead tr th:first-child"));
        lastNameHeader.click();

        List<WebElement> cells = driver.findElements(By.cssSelector("#table1 tbody tr td:first-child"));
        for (int i = 0; i < cells.size() - 1; i++) {
            String current = cells.get(i).getText();
            String next = cells.get(i + 1).getText();
            Assert.assertTrue(current.compareTo(next) <= 0,
                    "Table should be sorted: " + current + " <= " + next);
        }
        Reporter.log("Table sorted by last name successfully", true);
    }

    @Test(description = "Keyboard actions with Actions class")
    public void testKeyboardActions() {
        driver.get(PRACTICE_URL + "/key_presses");

        WebElement input = driver.findElement(By.id("target"));
        new Actions(driver).click(input).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).perform();

        Assert.assertEquals(input.getAttribute("value"), "HELLO");
        Reporter.log("Shift+type produced uppercase text", true);
    }

    @Test(description = "Drag and drop interaction")
    public void testDragAndDrop() {
        driver.get(PRACTICE_URL + "/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        WebDriverDriverUtilies.dragAndDrop(driver, source, target);
        Reporter.log("Drag and drop performed", true);
    }

    @Test(description = "Scroll to element and verify visibility")
    public void testScrollToElement() {
        driver.get(PRACTICE_URL + "/large");

        WebElement bottomElement = driver.findElement(By.id("page-footer"));
        WebDriverDriverUtilies.scrollToElement(driver, bottomElement);

        Assert.assertTrue(bottomElement.isDisplayed(), "Footer should be visible after scroll");
        Reporter.log("Scrolled to page footer successfully", true);
    }
}
