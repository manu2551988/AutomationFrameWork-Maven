package parameters;

import org.openqa.selenium.By;
import org.sikuli.api.robot.Key;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lib.BaseTest;

public class Demo_Parameters extends BaseTest {
	
	
	@Test
	@Parameters({"searchInput"})
	public void TC_01(String searchInput) {

		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys(searchInput,Key.ENTER);
		
	}

}
