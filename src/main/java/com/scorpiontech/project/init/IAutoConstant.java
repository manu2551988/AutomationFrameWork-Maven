package com.scorpiontech.project.init;

public interface IAutoConstant {

	String DirPath = System.getProperty("user.dir");

	String CHROME_KEY = "webdriver.chrome.driver";

	String CHROME_VALUE = "./src/test/resources/driver/chromedriver.exe";

	String GECKO_KEY = "webdriver.gecko.driver";

	String GECKO_VALUE = "./src/test/resources/driver/geckodriver.exe";

	String EDGE_KEY = "webdriver.edge.driver";

	String EDGE_VALUE = "./src/test/resources/driver/msedgedriver.exe";

	String CHROME = "chrome";

	String FIREFOX = "firefox";

	String EDGE = "edge";

	String PfilePath = DirPath + "/src/main/resources/propertfiles/data.properties";

	String EfilePath = DirPath + "/src/test/resources/TestCases_Actitime.xlsx";
	
	String RfilePath = DirPath + "/src/test/resources/Result_Report.xlsx";

	String screenShotPath = DirPath + "/src/test/resources/ScreenShots/";
	
	String passScreenShotPath = DirPath + "/src/test/resources/Pass-Results/";
	
	String failScreenShotPath = DirPath + "/src/test/resources/Fail-Results/";

	String URL = "http://localhost/login.do";

	long ITO = 10;

	long ETO = 10;

	long PTO = 20;
}
