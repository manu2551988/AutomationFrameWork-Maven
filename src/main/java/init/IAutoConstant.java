package init;

public interface IAutoConstant {

    String DIR_PATH = System.getProperty("user.dir");

    // Browser constants
    String CHROME = "chrome";
    String FIREFOX = "firefox";
    String EDGE = "edge";

    // File paths
    String PROP_FILE_PATH = DIR_PATH + "/src/main/resources/propertfiles/data.properties";
    String EXCEL_FILE_PATH = DIR_PATH + "/src/test/resources/TestCases_Actitime.xlsx";
    String RESULT_FILE_PATH = DIR_PATH + "/src/test/resources/Result_Report.xlsx";
    String SCREENSHOT_PATH = DIR_PATH + "/src/test/resources/ScreenShots/";
    String WEB_ELEM_SCREENSHOT_PATH = DIR_PATH + "/src/test/resources/WebElemScreeShot/";
    String PASS_SCREENSHOT_PATH = DIR_PATH + "/src/test/resources/Pass-Results/";
    String FAIL_SCREENSHOT_PATH = DIR_PATH + "/src/test/resources/Fail-Results/";

    // Timeouts (seconds)
    long IMPLICIT_WAIT = 20;
    long EXPLICIT_WAIT = 10;
    long PAGE_LOAD_TIMEOUT = 30;

    // Backward compatibility aliases
    String DirPath = DIR_PATH;
    String PfilePath = PROP_FILE_PATH;
    String EfilePath = EXCEL_FILE_PATH;
    String RfilePath = RESULT_FILE_PATH;
    String screenShotPath = SCREENSHOT_PATH;
    String screenShotPathWebElement = WEB_ELEM_SCREENSHOT_PATH;
    String passScreenShotPath = PASS_SCREENSHOT_PATH;
    String failScreenShotPath = FAIL_SCREENSHOT_PATH;
    long ITO = IMPLICIT_WAIT;
    long ETO = EXPLICIT_WAIT;
    long PTO = PAGE_LOAD_TIMEOUT;
}
