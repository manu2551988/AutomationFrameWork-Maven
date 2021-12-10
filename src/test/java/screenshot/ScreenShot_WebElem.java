package screenshot;

import lib.BaseTest;
import lib.BaseTestMulti;
import lib.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Base64;

public class ScreenShot_WebElem extends BaseTestMulti {

    @Test
    public void TakesScreenshotAs_WebElem(){

        driver.get("https://www.google.com");
        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("Asus Gaming Laptop", Keys.ENTER);

        WebElement clkLink=driver.findElement(By.xpath("//span[contains(.,'Latest ASUS Gaming Laptops')]"));
        ElementUtils.takeWebElementScreenShot(clkLink,"Asus Laptop");

    }
}
