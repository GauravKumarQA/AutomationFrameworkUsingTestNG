package utils;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.GetBrowserInstance;



public class Keywords extends GetBrowserInstance{
	
	WebDriver driver ;

//===Open browser with BrowserName=============================================>
	
	public void openBrowser(String BrowserName){
	GetBrowserInstance browser = new GetBrowserInstance();
	this.driver = browser.openLocalBowser(BrowserName);		
	}
	
//=============================================================================>	
	
	ScreenShot src = new ScreenShot();
	
	public void getUrl(String URL){//====open url =====>
		driver.get(URL);
	}
	
	
	public void findEelementClick(By locator){//==Find element and click=====>
		waitElementUntilDisplayed(locator);
		driver.findElement(locator).click();
	}
	
	public void findEelementClear(By locator){//==Find element and Clear====>
		waitElementUntilDisplayed(locator);
		driver.findElement(locator).clear();
	}
	
	public void findEelemtSenKey(By locator , String SendkeyData){//==Find element and send keys====>
		waitElementUntilDisplayed(locator);
		driver.findElement(locator).sendKeys(SendkeyData);
	}
	
	public WebElement findEelement(By locator){//===Find element and return element=====>
		waitElementUntilDisplayed(locator);
		return	driver.findElement(locator);
	}
	
	public String getText(WebDriver driver, By locator){//==Return String as data==>
		waitElementUntilDisplayed(locator);
		return	driver.findElement(locator).getText();	
		}
	
	public int findElementsCount(WebDriver driver, By locator) {//==Find elements counts and returns Integer value==>
		List<WebElement> listOfElement = driver.findElements(locator);
		return listOfElement.size();
	}
	
	public void waitElementUntilDisplayed(By locator){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitElementUntilClickable(By locator){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//=========================ScreenShots===========================================>
	public void captureScreenShot() throws IOException{//==Capture screenShots===>
		src.captureScreenshot(driver);
	}
	public void captureScreenShotWithUrl() {//==Capture screenShots with url on screenshot===>
		
	try{src.addurlToScreenShot(driver,driver.getCurrentUrl());}catch(Throwable e){e.printStackTrace();}
	}
	public void captureScreenShotReTurnPath() throws IOException{//==Capture screenShots===>
		src.captureScreenshotReturnPath(driver);
	}
	//=============================================================================>
	
	//================Switch to Frames via String/Integer/default======>
	
		public void SwitchToframe(WebDriver driver,String frame){
			driver.switchTo().frame(frame);
		}
		public void SwitchToframe(WebDriver driver, int  frame){
			driver.switchTo().frame(frame);
		}
		public void switchToDefault(WebDriver driver){
			driver.switchTo().defaultContent();
		}
	//================================================================>
		
	//===================Scroll functions=============================================>
		public void scrollDownScreen(WebDriver driver){
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,500)", "");
		}
		
		
		public void scrollUpScreen(WebDriver driver){
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,-500)", "");
		}
		
		public void ScrollToElementLocation(WebDriver driver,By locator){	
		String location =driver.findElement(locator).getLocation().toString();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo"+location+"", "");
		}
	//================================================================>
	
		
}
