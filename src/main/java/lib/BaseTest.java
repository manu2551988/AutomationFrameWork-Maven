package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Base test class providing browser setup/teardown, thread-safe WebDriver,
 * and Extent Reports integration.
 *
 * Usage: Extend this class in your test classes.
 * Browser can be set via testng.xml parameter or defaults to "chrome".
 */
public abstract class BaseTest implements IAutoConstant {

    // Thread-safe WebDriver for parallel execution
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Keep static reference for backward compatibility with existing tests
    public static WebDriver driver;

    public static int passCount = 0, failCount = 0;
    public ExtentReports extent;
    protected ExtentTest extentTest;

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeSuite
    public void extentReportStart() {
        String timestamp = new SimpleDateFormat("dd-M-yy_hh-mm-ss_aa").format(new Date());
        String className = this.getClass().getSimpleName();

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                "./Test-Ext-Report/" + className + "-" + timestamp + ".html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName(className);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void openApp(@Optional("chrome") String browser, Method method) {
        WebDriver wd = createDriver(browser);
        driverThreadLocal.set(wd);
        driver = wd; // backward compat

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        wd.manage().window().maximize();

        extentTest = extent.createTest(method.getName());
        Reporter.log("Browser launched: " + browser, true);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        WebDriver wd = getDriver();
        if (wd == null) return;

        String methodName = result.getName();
        String timestamp = new SimpleDateFormat("dd-MM-yy_hh-mm-ss_aa").format(new Date());

        if (result.getStatus() == ITestResult.SUCCESS) {
            passCount++;
            ElementUtils.takeScreenShotResult(wd, PASS_SCREENSHOT_PATH + methodName + "-" + timestamp + ".png");
            if (extentTest != null) extentTest.pass("Test passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            failCount++;
            ElementUtils.takeScreenShotResult(wd, FAIL_SCREENSHOT_PATH + methodName + "-" + timestamp + ".png");
            if (extentTest != null) extentTest.fail(result.getThrowable());
        } else {
            if (extentTest != null) extentTest.skip("Test skipped");
        }

        wd.quit();
        driverThreadLocal.remove();
    }

    @AfterSuite
    public void printReport() {
        Reporter.log("PassCount:" + passCount, true);
        Reporter.log("FailCount:" + failCount, true);
        GenericLib.createCell(RESULT_FILE_PATH, "Sheet1", 1, 0, passCount);
        GenericLib.createCell(RESULT_FILE_PATH, "Sheet1", 1, 1, failCount);
        extent.flush();
    }

    private WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addPreference("dom.webnotifications.enabled", false);
                return new FirefoxDriver(ffOptions);
            case "edge":
                return new EdgeDriver(new EdgeOptions());
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications", "--start-maximized");
                return new ChromeDriver(chromeOptions);
        }
    }
}
