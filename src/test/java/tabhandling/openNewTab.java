package tabhandling;

import lib.BaseTestMulti;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class openNewTab extends BaseTestMulti {

    @Test
    public void OpenTab(){

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("iPhone 13 Pro", Keys.ENTER);


    }
}
