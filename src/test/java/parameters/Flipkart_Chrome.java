package parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.scorpiontech.project.lib.BaseTestPara;
import com.scorpiontech.project.pages.Flipkart_Home;
import com.scorpiontech.project.pages.Flipkart_ItemPage;

public class Flipkart_Chrome extends BaseTestPara {

	@Test
	public void TC01() throws IOException, InterruptedException {

		driver.get("https://www.flipkart.com");

		Flipkart_Home home=new Flipkart_Home(driver);
		home.Flip_Login();
		home.Flip_Search();



		Flipkart_ItemPage items=new Flipkart_ItemPage(driver);
		WebElement element = driver.findElement(By.xpath("//div[.='APPLE iPhone 12 Pro (Gold, 128 GB)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(15000);
		items.sel_Item();

		Set<String> sessionID = driver.getWindowHandles();
		System.out.println(sessionID);

		ArrayList<String> array=new ArrayList<String>(sessionID);

		for (String string : array) {
			System.out.println(string);

		}

		driver.switchTo().window(array.get(1));
		String currentIDs = driver.getWindowHandle();
		System.out.println(currentIDs);

		items.Order_Item();


	}


}
