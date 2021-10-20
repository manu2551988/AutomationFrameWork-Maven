package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import init.IAutoConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest implements IAutoConstant {

    public static int passCount = 0, failCount = 0;
    public static WebDriver driver;

    static {
        System.setProperty(CHROME_KEY, CHROME_VALUE);
        System.setProperty(GECKO_KEY, GECKO_VALUE);
        System.setProperty(EDGE_KEY, EDGE_VALUE);
    }

    public ExtentReports extent;

    @BeforeSuite
    public void extentReportStart() {

        DateFormat dateFormat = new SimpleDateFormat("dd-M-yy hh-mm-ss aa");
        Date date = new Date();

//        String className = this.getClass().getSuperclass().getName();
//        String className = this.getClass().getCanonicalName();
        String className = this.getClass().getSimpleName();

        // start reporters
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Test-Ext-Report/" + className + " " +
                dateFormat.format(date) + ".html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    /*@BeforeClass
    //@Parameters("browser")
    public void setUpBrowser() {
        String browser = "chrome";

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("incognito");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("browser.privatebrowsing.autostart", true);
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else {
            Reporter.log("No Browser Configuration Found", true);
        }

        driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PTO, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }*/

    @BeforeMethod
    public void openApp() {

        String browser = "chrome";

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("incognito");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("browser.privatebrowsing.autostart", true);
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else {
            Reporter.log("No Browser Configuration Found", true);
        }

        driver.get("https://www.flipkart.com/");

        driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PTO, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void getStatus(ITestResult res) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int status = res.getStatus();
        String methodName = res.getName();
        if (status == 1) {
            passCount++;
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
            Date date = new Date();
            String Photo_Path = passScreenShotPath + methodName + " " + dateFormat.format(date) + ".png";
            GenericLib.takeScreenShotResult(driver, Photo_Path);
        } else {
            failCount++;
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh-mm-ss aa");
            Date date = new Date();
            String Photo_Path = failScreenShotPath + methodName + " " + dateFormat.format(date) + ".png";
            GenericLib.takeScreenShotResult(driver, Photo_Path);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String parentwh = driver.getWindowHandle();
        String parentTitle = driver.getTitle();

        Set<String> whs = driver.getWindowHandles();
        int count = whs.size();
        System.out.println("Tab opened Count:" + count);

        for (String w : whs) {
            driver.switchTo().window(w);
            String s = driver.getTitle();
            if (s.equals(parentTitle)) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.close();
            } else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.quit();
            }
        }


    }

    /*@AfterClass
    public void tearDown() {

        String parentwh = driver.getWindowHandle();
        String parentTitle = driver.getTitle();

        Set<String> whs = driver.getWindowHandles();
        int count = whs.size();
        System.out.println("Tab opened Count:" + count);

        for (String w : whs) {
            driver.switchTo().window(w);
            String s = driver.getTitle();
            if (s.equals(parentTitle)) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.close();
            } else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.quit();
            }
        }
    }*/

    @AfterSuite
    public void printReport() {

        Reporter.log("PassCount:" + passCount, true);
        Reporter.log("FailCount:" + failCount, true);
        GenericLib.createCell(RfilePath, "Sheet1", 1, 0, passCount);
        GenericLib.createCell(RfilePath, "Sheet1", 1, 1, failCount);

        extent.flush();
    }


}
