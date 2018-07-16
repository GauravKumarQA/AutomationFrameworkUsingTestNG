package utils;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	private static ExtentReports report = null;

	private ExtentReport() {

	}

	// initialize the report and return it to the classes
	public static ExtentReports getInstance() {
		
		//so that threads are executed one by one
		 synchronized(ExtentReport.class) {
		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Listen.file);
			String configFileDir = System.getProperty("user.dir");
			htmlReporter.loadXMLConfig(new File(configFileDir+"\\config.xml"));
			htmlReporter.setAppendExisting(true);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Host Name", "Test Machine");
			report.setSystemInfo("Environment", "Automation");
		}

		// System.out.println(report);
		return report;
	}
}
}
