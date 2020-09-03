package com.scorpiontech.project.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtils {

	public static void chkPageTitle(WebDriver driver, String expectedPT) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(expectedPT));

		String actualPT = driver.getTitle();
		if (actualPT.equals(expectedPT)) {
			System.out.println("Expected Page is Displayed-->" + expectedPT);
		} else {
			System.out.println("Expected Page is NOT Displayed-->" + actualPT);
		}
	}

}
