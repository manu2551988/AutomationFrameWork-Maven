package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Page Object for Login Page.
 * Demonstrates the Page Object Model pattern with BasePage.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameTB;

    @FindBy(name = "pwd")
    private WebElement passwordTB;

    @FindBy(id = "keepLoggedInCheckBox")
    private WebElement keepLoggedInCB;

    @FindBy(xpath = "//div[text()='Login ']")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'invalid.')]")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        type(usernameTB, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordTB, password);
        return this;
    }

    public LoginPage checkKeepLoggedIn() {
        click(keepLoggedInCB);
        return this;
    }

    public void clickLogin() {
        click(loginBtn);
    }

    /**
     * Fluent login: chain username, password, checkbox, and submit.
     */
    public void login(String username, String password) {
        enterUsername(username)
                .enterPassword(password)
                .checkKeepLoggedIn();
        clickLogin();
    }

    public void verifyErrorMessage() {
        Assert.assertTrue(isDisplayed(errorMsg), "Error message should be displayed");
        Reporter.log("Error Msg Displayed: " + getText(errorMsg), true);
    }

    public String getErrorMessageText() {
        return getText(errorMsg);
    }
}
