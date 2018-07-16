package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

public class ExtentLoging {
	
	  int i=0;
	  static String currentTestStep="";
	  static ExtentReports report;
	  static ExtentTest logger;
	  ScreenShot ss = new ScreenShot();

	
	//to put pass logs
	public void passLog(String testStep,ExtentReports report,ExtentTest logger)
	{
		//currentTestStep = testStep;
		logger.log(Status.PASS, "Step: "+(++i)+" "+testStep );
		//report.flush();
	}
	
	//to put information logs
	public void infoLog(String testStep,ExtentReports report,ExtentTest logger)
	{
		//currentTestStep = testStep;
		logger.log(Status.INFO, "Step: "+(++i)+" "+testStep );
		//report.flush();
	}
	
	//update the test step for logging
	public void updateTestStep(String teststep,ExtentReports r,ExtentTest l,WebDriver driver)
	{
		currentTestStep=teststep;

	}
	
	//takes screenshot on failure and logs it as failure along with test-step
	public void sendScreenShotOnFailure(String testStepName,ExtentReports r,ExtentTest l,WebDriver driver) throws Exception {
	  
	String screenshot_path = ss.captureScreenshotReturnPath(driver, testStepName);
	
			try {
				report=r;
				logger=l;
				logger.fail("Failed test Step: "+testStepName,MediaEntityBuilder.createScreenCaptureFromPath(screenshot_path).build());
				report.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	
	//takes a normal screenshot and logs it as info along with test step
	public void takeScreenshotAndLog(WebDriver driver,String testStepName,ExtentReports report,ExtentTest logger) throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd,HH-mm-ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
		String screenshot_path = ss.captureScreenshotReturnPath(driver, testStepName+"-"+strDate);
		
		MediaEntityModelProvider mediaModel;
		try {
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshot_path).build();
			logger.pass("Step: "+(++i)+" "+testStepName, mediaModel);
		} catch (IOException e) {
			e.printStackTrace();
		}
			//report.flush();
	}
}
	
