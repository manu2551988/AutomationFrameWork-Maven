package certificatebypass;

import lib.BaseTestMulti;
import org.testng.annotations.Test;

public class CertiByPass extends BaseTestMulti {

    @Test
    public void TC_01() throws InterruptedException {

        driver.get("https://iptorrents.com/login.php");

        Thread.sleep(8000);
    }

}
