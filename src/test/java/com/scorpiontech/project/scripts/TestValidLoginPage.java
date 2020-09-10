package com.scorpiontech.project.scripts;

import org.testng.annotations.Test;

import com.scorpiontech.project.lib.BaseTest;
import com.scorpiontech.project.lib.GenericLib;
import com.scorpiontech.project.pages.LoginPage;

public class TestValidLoginPage extends BaseTest {

	@Test
	public void validlogin_Test() throws InterruptedException
	{	
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
