package com.tyss.project.init;

public interface IAutoConstant {
	
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./driver/chromedriver.exe";
	
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE="./driver/geckodriver.exe";
	
	String EDGE_KEY="webdriver.edge.driver";
	String EDGE_VALUE="./driver/msedgedriver.exe";
	
	String URL = "http://localhost/login.do";
	
	long ITO = 10;
	long ETO = 10;
	long PTO = 20;
}
