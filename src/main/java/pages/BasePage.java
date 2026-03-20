package pages;

import lib.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all Page Objects.
 * Provides common page operations and initializes PageFactory.
 */
public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void click(WebElement element) {
        ElementUtils.waitForClickable(element).click();
    }

    protected void type(WebElement element, String text) {
        WebElement el = ElementUtils.waitForVisible(element);
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return ElementUtils.waitForVisible(element).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return ElementUtils.waitForVisible(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
