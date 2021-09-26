package test_scripts;

import org.testng.annotations.Test;

import lib.BaseTest;
import lib.GenericLib;
import pages.LoginPage;

public class TestInvalidLoginpage extends BaseTest{
	
	@Test
	public void test_InvalidLogin()throws InterruptedException 
	{
		String URL="http://localhost/login.do";
		driver.get(URL);
		int rowcount = GenericLib.read_XL_RowCount(EfilePath, "Sheet1");
		
		LoginPage lp=new LoginPage(driver);
		
		for(int i=1; i<=rowcount;i++)
		{
			String un = GenericLib.getExcelData("Sheet1", 13,0);
			String pw = GenericLib.getExcelData("Sheet1", 13,1);
			lp.setUsername(un);
			lp.setPassword(pw);
			lp.clickOnLoginBTN();
			Thread.sleep(500);
			lp.verifyErrMSg(driver);
			
		}
		
	}

}
