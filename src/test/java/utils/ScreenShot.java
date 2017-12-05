package utils;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public void captureScreenshot(WebDriver driver) throws IOException{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
		String formatedDateAndTime = now.format(format);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\" + formatedDateAndTime.toString() +" captured.png"));
		
	}
	
	
	//================================================
	
	//================================================
			
			
		}
