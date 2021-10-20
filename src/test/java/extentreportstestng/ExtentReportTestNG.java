package extentreportstestng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExtentReportTestNG {


    public ExtentReports extent;

    @BeforeSuite
    public void extentReportStart() {

        // start reporters
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Test-Extent-Report/Spark.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }


    @Test
    public void TC_01() {
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");

        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");

    }

    @AfterSuite
    public void extentReportEnd() {
        extent.flush();
    }

}
