package com.scopiontech.project.init;

public interface IAutoConstant {

	String DirPath = System.getProperty("user.dir");

	String CHROME_KEY = "webdriver.chrome.driver";

	String CHROME_VALUE = "./driver/chromedriver.exe";

	String GECKO_KEY = "webdriver.gecko.driver";

	String GECKO_VALUE = "./driver/geckodriver.exe";

	String EDGE_KEY = "webdriver.edge.driver";

	String EDGE_VALUE = "./driver/msedgedriver.exe";

	String CHROME = "chrome";

	String FIREFOX = "firefox";

	String EDGE = "edge";

	String PfilePath = DirPath + "/src/main/resources/propertfiles/data.properties";

	String EfilePath = DirPath + "/src/test/resources/excel/TestCases_Actitime.xlsx";

	String screenShotPath = DirPath + "/ScreenShots/";

	String URL = "http://localhost/login.do";

	long ITO = 10;

	long ETO = 10;

	long PTO = 20;
}
