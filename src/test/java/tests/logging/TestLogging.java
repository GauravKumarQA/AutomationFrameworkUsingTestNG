package tests.logging;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import basePackage.GetBrowserInstance;
import pageObjects.TestLoggingPO;
import utils.ExtentLoging;
import utils.ExtentReport;


@Listeners(utils.Listen.class)
public class TestLogging {

//initialization
  WebDriver driver;
  GetBrowserInstance gbi = new GetBrowserInstance();
  ExtentLoging el = new ExtentLoging();
  TestLoggingPO obj = new TestLoggingPO();
 
  ExtentReports report;
  ExtentTest logger;
  
  // Variables Defined
  String testCaseName = "TestLogging";
  String testStep;

  @BeforeClass
  // open the browser
  public void openBrowser() {
      // Created a Singleton object because we need to work on a single report.
      report = ExtentReport.getInstance();

      // logger of a singleton report with a unique name
      logger = report.createTest(testCaseName);

      // PropertyConfigurator.configure("Log4j.properties");
      testStep = " Opening Browser";

      // Driver name is unique in every test case
      driver = gbi.openLocalBowser();
      // ExtentLoging.passLog(testStep,report,logger);
  }
  
  
  @Test
  public void performTest() throws Exception {
  
  try {
    testStep = " Getting the specific url";
    obj.getUrl(driver);
    el.passLog(testStep, report, logger);

    testStep = " Writing data in the text box";
    obj.sendkeysToSearchField(driver, "Hello");
    el.passLog(testStep, report, logger);

    
} catch (Exception e) {
    el.updateTestStep(this.testStep, this.report, this.logger, driver);
    el.sendScreenShotOnFailure(this.testStep, this.report, this.logger, driver);
    Assert.fail();
}
}

@AfterClass
// close the browser
public void closeBrowser() {
testStep = "Closing the browser";
driver.close();
driver.quit();
}

}
