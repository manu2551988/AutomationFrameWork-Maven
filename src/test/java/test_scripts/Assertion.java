package test_scripts;

import lib.GenericLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashSet;

public class Assertion {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
	}
	
	@Test
	public void arrayAssertion() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
		
		String val1 = driver.findElement(By.id("headerContainer")).getText();
		
		HashSet actual=new HashSet();
		actual.add(val1);
		actual.add("Manu Kakkar");
		
		HashSet expect=new HashSet();
		expect.add(GenericLib.getExcelData("Sheet1", 11, 2));
		expect.add("Please identify yourself");
		
		SoftAssert soft=new SoftAssert();
//		Assert.assertEquals(actual, expect);
		soft.assertEquals(actual, expect);
		soft.assertNotNull(expect);
//		Assert.assert
		
		driver.close();
		
		soft.assertAll();
		
	}

}
