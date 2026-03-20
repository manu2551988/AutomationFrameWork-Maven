# AutomationFrameWork-Maven

A Selenium-based test automation framework built with Java, Maven, TestNG, and Page Object Model (POM) design pattern. Covers UI automation, REST API testing, data-driven testing, and reporting.

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 11 | Language |
| Selenium WebDriver | 4.27.0 | Browser automation |
| TestNG | 7.10.2 | Test runner & assertions |
| REST Assured | 5.5.0 | API testing |
| Apache POI | 5.4.0 | Excel read/write |
| Extent Reports | 5.1.2 | HTML test reports |
| Cucumber | 7.20.1 | BDD support |
| Maven | - | Build & dependency management |

## Project Structure

```
src/
├── main/java/
│   ├── init/
│   │   └── IAutoConstant.java          # Constants (paths, timeouts, browser keys)
│   ├── lib/
│   │   ├── BaseTest.java               # Base test class (browser setup/teardown, reporting)
│   │   ├── BaseTestPara.java           # Parameterized browser base test
│   │   ├── BaseTestMulti.java          # Multi-browser base test
│   │   ├── ElementUtils.java           # Explicit waits, screenshots, page title checks
│   │   ├── WebDriverDriverUtilies.java # Dropdowns, alerts, frames, windows, scrolling, JS
│   │   ├── GenericLib.java             # Excel R/W, property files, scrolling, Robot class
│   │   ├── Xls_Reader.java            # Full-featured Excel reader/writer (POI 5.x)
│   │   ├── ExcelReader.java           # Simple Excel reader
│   │   ├── ExcelUtil.java             # Excel utility methods
│   │   ├── ExcelWriteByColn.java      # Excel column writer
│   │   └── BrowserSimple.java         # Simple browser launcher
│   └── pages/
│       ├── BasePage.java               # Abstract base for all Page Objects
│       ├── LoginPage.java              # Login page (fluent API)
│       ├── Flipkart_Home.java          # Flipkart home page
│       └── Flipkart_ItemPage.java      # Flipkart item page
│
├── test/java/
│   ├── samples/                        # ★ Sample tests demonstrating framework usage
│   │   ├── GoogleSearchTest.java       # Basic search & title verification
│   │   ├── FormInteractionTest.java    # Dropdowns, checkboxes, JS alerts, hover
│   │   ├── FrameAndWindowTest.java     # iframes, nested frames, multi-window, dynamic load
│   │   ├── TableAndActionsTest.java    # Table extraction, sorting, keyboard, drag-drop
│   │   ├── DataDrivenTest.java         # @DataProvider driven login & search tests
│   │   └── RestApiTest.java            # REST API: GET/POST/PUT/DELETE with RestAssured
│   ├── dropdown/                       # Dropdown handling examples
│   ├── frames/                         # Frame/iframe switching
│   ├── popups/                         # Alert, file upload/download, notification popups
│   ├── keyboardandmouseactions/        # Mouse hover, right-click, drag-drop, composite actions
│   ├── scrolltoele/                    # Scroll-to-element techniques
│   ├── synchronization/                # Implicit/explicit wait examples
│   ├── xpath/                          # XPath locator strategies
│   ├── screenshot/                     # Screenshot capture examples
│   ├── excelsreadwrite/                # Excel data read/write
│   ├── switchwindow/                   # Window/tab switching
│   ├── parameters/                     # TestNG parameterized tests
│   ├── extentreportsbasic/             # Extent Reports standalone
│   ├── extentreportstestng/            # Extent Reports with TestNG
│   ├── test_scripts/                   # Login page test scripts (POM)
│   └── ...                             # Additional practice modules
│
├── test/resources/
│   ├── Data/                           # Test data files (Excel)
│   ├── ScreenShots/                    # Runtime screenshots
│   ├── Pass-Results/                   # Passed test screenshots
│   ├── Fail-Results/                   # Failed test screenshots
│   └── Result_Report.xlsx              # Pass/fail count report
│
├── Test-Ext-Report/                    # Generated Extent HTML reports
├── testng.xml                          # TestNG suite configuration
├── crossbrowser.xml                    # Cross-browser test suite
└── pom.xml                             # Maven dependencies & build config
```

## Getting Started

### Prerequisites

- Java 11+
- Maven 3.6+
- Chrome / Firefox / Edge browser installed

### Run Tests

```bash
# Run all tests via TestNG suite
mvn clean test

# Run a specific test class
mvn test -Dtest=samples.GoogleSearchTest

# Run only API tests (no browser needed)
mvn test -Dtest=samples.RestApiTest
```

### Run with a specific browser

Update `testng.xml` to pass a browser parameter:

```xml
<test name="Chrome-Test">
    <parameter name="browser" value="chrome"/>
    <classes>
        <class name="samples.GoogleSearchTest"/>
    </classes>
</test>
```

Supported values: `chrome`, `firefox`, `edge`

## Framework Features

- **Page Object Model** — `BasePage` provides reusable `click()`, `type()`, `getText()` with built-in explicit waits
- **Thread-safe WebDriver** — `ThreadLocal<WebDriver>` in `BaseTest` enables parallel test execution
- **Auto screenshots** — Pass/fail screenshots captured automatically after each test
- **Extent Reports** — HTML reports generated per suite in `Test-Ext-Report/`
- **Data-driven** — TestNG `@DataProvider` and Excel-based test data via Apache POI
- **REST API testing** — RestAssured integration for API validation
- **Cross-browser** — Chrome, Firefox, Edge support via TestNG parameters
- **Excel utilities** — Read/write test data, results tracking in `Result_Report.xlsx`

## Key Classes

| Class | Description |
|-------|-------------|
| `BaseTest` | Extend this for UI tests. Handles browser lifecycle, reporting, screenshots |
| `BasePage` | Extend this for page objects. Provides wait-wrapped element interactions |
| `ElementUtils` | Static helpers: `waitForClickable()`, `waitForVisible()`, `takeScreenShot()` |
| `WebDriverDriverUtilies` | Static helpers: dropdowns, alerts, frames, windows, scroll, JS click |
| `GenericLib` | Excel read/write, property file reader, scroll utilities |
| `Xls_Reader` | Full Excel operations: read/write cells, add/remove sheets & columns, hyperlinks |
