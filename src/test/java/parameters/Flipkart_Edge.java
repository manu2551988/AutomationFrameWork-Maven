package parameters;

import lib.BaseTestPara;
import org.testng.annotations.Test;
import pages.Flipkart_Home;
import pages.Flipkart_ItemPage;

import java.io.IOException;

public class Flipkart_Edge extends BaseTestPara {

    @Test
    public void TC01() throws IOException, InterruptedException {

        driver.get("https://www.flipkart.com");

        Flipkart_Home home = new Flipkart_Home(driver);
        home.Flip_Login();
		home.Flip_Search();
		
		Flipkart_ItemPage items=new Flipkart_ItemPage(driver);
		items.sel_Item();
		items.switchWin();
		items.Order_Item();
		
		
	}
	

}
