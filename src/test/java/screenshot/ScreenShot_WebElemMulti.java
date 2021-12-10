package screenshot;

import lib.BaseTestMulti;
import lib.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScreenShot_WebElemMulti extends BaseTestMulti {

    @Test
    public void TakesScreenshotAs_WebElemMulti_1(){

        driver.get("https://app.hubspot.com/signup-hubspot/crm?hubs_signup-url=www.hubspot.com%2Fproducts%2Fget-started&hubs_signup-cta=getstarted-growth&hubs_content=www.hubspot.com%2F&hubs_content-cta=homepage-nav&_conv_v=vi%3A1*sc%3A1*cs%3A1635325720*fs%3A1635325720*pv%3A2*seg%3A%7B10031564.1%7D*exp%3A%7B%7D&_conv_s=si%3A1*sh%3A1635325720259-0.7484675780612497*pv%3A2&_ga=2.73528474.985869069.1635325728-1342411001.1635325728&step=landing_page");

        WebElement captForm=driver.findElement(By.cssSelector(".FlowStep"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ElementUtils.takeWebElementScreenShot(captForm,"Form1");

    }

    @Test
    public void TakesScreenshotAs_WebElemMulti_2(){

        driver.get("https://app.hubspot.com/signup-hubspot/crm?hubs_signup-url=www.hubspot.com%2Fproducts%2Fget-started&hubs_signup-cta=getstarted-growth&hubs_content=www.hubspot.com%2F&hubs_content-cta=homepage-nav&_conv_v=vi%3A1*sc%3A1*cs%3A1635325720*fs%3A1635325720*pv%3A2*seg%3A%7B10031564.1%7D*exp%3A%7B%7D&_conv_s=si%3A1*sh%3A1635325720259-0.7484675780612497*pv%3A2&_ga=2.73528474.985869069.1635325728-1342411001.1635325728&step=landing_page");

        WebElement captForm=driver.findElement(By.cssSelector(".FlowStepMessage"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ElementUtils.takeWebElementScreenShot(captForm,"Form2");

    }

}
