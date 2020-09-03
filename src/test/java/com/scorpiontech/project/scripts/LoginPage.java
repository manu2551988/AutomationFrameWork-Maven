package com.scorpiontech.project.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.scorpiontech.project.lib.BaseTest;
import com.scorpiontech.project.lib.GenericLib;
import com.scorpiontech.project.pages.CustomerLoginPage;
import com.scorpiontech.project.pages.HomePage;
import com.scorpiontech.project.pages.MyAccountPage;

public class LoginPage extends BaseTest {

	@Test
	public void tc_01() throws InterruptedException {
		HomePage hm = new HomePage(driver);
		Assert.assertEquals(hm.homePageTitle(), GenericLib.getExpected("Sheet1", 3, 4));
		hm.signInClk();
		Thread.sleep(3000);
		CustomerLoginPage clp = new CustomerLoginPage(driver);
		Assert.assertEquals(clp.customerLoginPageTitle(), GenericLib.getExpected("Sheet1", 5, 4));
		clp.untxtboxEnterData(GenericLib.getExcelData("Sheet1", 6, 3));
		clp.pwtxtboxEnterData(GenericLib.getExcelData("Sheet1", 7, 3));
		clp.loginBtnClick();
		MyAccountPage ma = new MyAccountPage(driver);
		Assert.assertEquals(ma.MyAccountPageTitle(), GenericLib.getExpected("Sheet1", 8, 4));
		GenericLib.takeScreenShot(driver, "MyAccountPageSS");
		Assert.assertTrue(ma.helloNameTxt().contains(GenericLib.getExpected("Sheet1", 9, 4)));

	}
}
