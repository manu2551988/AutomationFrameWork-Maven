package test_scripts;

import org.testng.annotations.Test;

import lib.BaseTest;
import lib.GenericLib;
import pages.LoginPage;

public class TestValidLoginPage extends BaseTest {

	@Test
	public void validlogin_Test() throws InterruptedException
	{	
		String URL="http://localhost/login.do";
		driver.get(URL);
    	String un = GenericLib.getExcelData("Sheet1", 12,0);
		String pw = GenericLib.getExcelData("Sheet1", 12,1);
	
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(un);
		lp.setPassword(pw);
		lp.clickOnLoginBTN();
		Thread.sleep(500);
		//lp.verifyErrMSg(driver);

	}

}
