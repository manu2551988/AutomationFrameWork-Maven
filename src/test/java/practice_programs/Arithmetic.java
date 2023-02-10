package practice_programs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;

public class Arithmetic {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/");

        String s1=driver.findElement(By.xpath("//pre[contains(.,'3.14')]")).getText();
        s1=s1.replace(",","");
        System.out.println(s1);
        double d1=Double.parseDouble(s1);
        System.out.println(d1);
        DecimalFormat df = new DecimalFormat("00.00");
        System.out.println(df.format(d1));
    }
}
