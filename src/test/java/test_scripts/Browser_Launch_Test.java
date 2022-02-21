package test_scripts;

import lib.BaseTest;
import org.testng.annotations.Test;


public class Browser_Launch_Test extends BaseTest {

    @Test
    public void TC_01() {
        driver.get("https://www.google.com/");
    }
}
