package utils;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import basePackage.GetBrowserInstance;

public class Keywords extends GetBrowserInstance{
	
	WebDriver driver ;
	
	public void openBrowser(String BrowserName){
	GetBrowserInstance browser = new GetBrowserInstance();
	this.driver = browser.openLocalBowser(BrowserName);		
	}
//=============================================================================	
	ScreenShot src = new ScreenShot();
	public void DriverGet(String URL){
		driver.get(URL);
	}
	public void FindEelementClick(By locator){
		driver.findElement(locator).click();
	}
	
	public void FindEelementClear(By locator){
		driver.findElement(locator).clear();
	}
	
	public void FindEelemtSenKey(By locator , String SendkeyData){
		driver.findElement(locator).sendKeys(SendkeyData);
	}
	
	public WebElement FindEelement(By locator){
	 return	driver.findElement(locator);
	}
	
	public void captureScreenShot() throws IOException{
		
		src.captureScreenshot(driver);
	}
	
	
}
