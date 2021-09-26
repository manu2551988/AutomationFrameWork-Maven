package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.GenericLib;

public class Flipkart_Home {

	//Declaration of WebElements
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	private WebElement inputEmail;

	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	private WebElement inputPass;	

	@FindBy(xpath="(//span[.='Login'])[3]")
	private WebElement clkLogin;

	@FindBy(name="q")
	private WebElement inputSearch;

	//Initializate the WebElements
	public Flipkart_Home(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	//Utilization of WebElements
	public void Flip_Login() {
		
		try {
			Thread.sleep(4000);
			inputEmail.sendKeys(GenericLib.getExcelDataByPath("./src/test/resources/Data/data.xlsx", "Sheet1", 2, 0));
			inputPass.sendKeys(GenericLib.getExcelDataByPath("./src/test/resources/Data/data.xlsx", "Sheet1", 2, 1));
			clkLogin.click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void Flip_Search() {
		try {
			Thread.sleep(2000);
			inputSearch.sendKeys(GenericLib.getExcelDataByPath("./src/test/resources/Data/data.xlsx", "Sheet1", 5, 0),Keys.ENTER);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
