package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage
{
		
	//declaration of variable
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement chkBOX;
	
	@FindBy(xpath="//div[text()='Login ']")
    private WebElement lognBTN;
	
	@FindBy(xpath="//span[contains(text(),'invalid.')]")
	private WebElement errMSG;
	
	//initialize the Elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization of WebElements
	
	public void clickOnKeepMeLoggedInCheckBox()
	{
		chkBOX.click();
	}
	public void clickOnLoginBTN()
	{
		lognBTN.click();
	}
	public void login()
	{
		unTB.sendKeys("admin");
		pwTB.sendKeys("manager");
		chkBOX.click();
		lognBTN.click();
	}
	public void login(String un,String pw)
	{
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		chkBOX.click();
		lognBTN.click();
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void verifyErrMSg(WebDriver driver)
	{
	   Assert.assertTrue(errMSG.isDisplayed());
	   Reporter.log("Error Msg Is Displayed"+errMSG.getText(),true);
	}
	

}
