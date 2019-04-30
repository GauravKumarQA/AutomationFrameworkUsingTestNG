/*
 * This class will contains one function per keyword. Every function should 
 * have proper comments explaining what that function do.
 */
package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Keywords {

	WebElement element = null;

	
	/*
	 *This functions open the URL which you pass as
	 *a parameter.We need to pass driver and url as a string
	 */
	public void getUrl(WebDriver driver ,String URL){
		driver.get(URL);
	}
	
		
	/*
	 *This functions use to find a attribute value which is present in DOM.
	 *It returns a String value
	 */
	public String getAttributeValue(WebDriver driver, By locator, String attributeKey) {
		return driver.findElement(locator).getAttribute(attributeKey);
	}
	
	
	
	/*
	 *This functions use to verify the downloaded file is present or not.
	 *It returns a boolean value as true or false.
	 *We need to provide a file dir path as a parameter
	 *And if file is present are deleting the same file
	 */
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			System.out.println(downloadPath);
			System.out.println(dirContents[i].getName());
			if (dirContents[i].getName().equals(fileName)) {

				// File has been found, it can now be deleted:
				dirContents[i].delete();

				return true;
			}
		}
		return false;
	}
	
	
	/*
	 *This functions use to click an element.
	 *This function wait first for elementy to be clickable
	 *Parameter which we need to pass is web driver and a locator type By
	 */
	public void findElementClick(WebDriver driver ,By locator){
		waitElementUntilClickable(driver, locator);
		driver.findElement(locator).click();
	}
	
	
	/*
	 *This functions use to click an element.
	 *This function directly click.
	 *Parameter which we need to pass is web driver and a locator type By.
	 */
	public void findElementJustClick(WebDriver driver ,By locator){
		driver.findElement(locator).click();
	}
	
	
	/*
	 *This functions use to click an element.
	 *This function click element by java script executor.
	 *Parameter which we need to pass is web driver and a locator type By.
	 */
	public void clickByjs(WebDriver driver,By locator) {
		WebElement ele = driver.findElement(locator);
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", ele);
	}

	
	
	/*
	 *This functions use to clear an element/field.
	 *Parameter which we need to pass is web driver and a locator type By.
	 */
	public void findElementClear(WebDriver driver ,By locator){
		waitElementUntilDisplayed(driver, locator);
		driver.findElement(locator).clear();
	}


	
	/*
	 *This functions use to send a string data an element/field.
	 *This function will wait for element to be displayed
	 *Parameter which we need to pass is web driver and a locator type By.
	 */
	public void findElementSendKey(WebDriver driver ,By locator , String sendkeyData){//==Find element and send keys====>
		waitElementUntilDisplayed(driver, locator);
		driver.findElement(locator).sendKeys(sendkeyData);
	}
	
	
	/*
	 *This functions use to send a Keyboad keys an element/field.
	 *This function will wait for element to be displayed
	 *Parameter which we need to pass is web driver and  Keys.
	 */
	public void findElementSendKey(WebDriver driver, By locator, Keys keys) {	
		waitElementUntilDisplayed(driver, locator);
		driver.findElement(locator).sendKeys(keys);
	}

	

	/*
	 *This functions use to find an element in DOM.
	 *And return a webelement.
	 */
	public WebElement findEelement(WebDriver driver ,By locator){
		waitElementUntilDisplayed(driver, locator);
		return	driver.findElement(locator);
	}

	
	
	/*
	 *This functions use to find an element in DOM.
	 *If element is present in DOM it will return true
	 *otherwise return false
	 */
	public  boolean isElementPresent(WebDriver driver ,By locator){
		try {
			waitElementUntilDisplayed(driver, locator);
			return true;
		}catch(Exception e) {
			return false;
		}

	}
	
	
	/*
	 *This functions use to find an element in DOM.
	 *If element is present in DOM it will retur true
	 *otherwise return false
	 *The difference is you can pass time as a parameter
	 *i.e how much time you want to wait
	 */
	public  boolean isElementPresent(WebDriver driver ,By locator,int timmer){
		try {
			waitElementUntilDisplayed(driver, locator,timmer);
			return true;
		}catch(Exception e) {
			//System.out.println(locator + " Not found");
			System.out.println(e);
			return false;
		}

	}

	
	/*
	 *This functions use to find an element and gets its innerHTML string value
	 *And retur as a string value
	 */
	public String getText(WebDriver driver, By locator){
		waitElementUntilDisplayed(driver, locator);
		return	driver.findElement(locator).getText();	
	}

	
	public int findElementsCount(WebDriver driver, By locator) {
		List<WebElement> listOfElement = driver.findElements(locator);
		return listOfElement.size();
	}

	public void waitElementUntilDisplayed(WebDriver driver ,By locator){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitElementUntilDisplayed(WebDriver driver ,By locator, int timer){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,timer);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public void waitElementUntilClickable(WebDriver driver ,By locator){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitUntillInvisible(WebDriver driver,By locator){
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitUntillInvisible(WebDriver driver,By locator,int timmer){
		WebDriverWait wait = new WebDriverWait(driver,timmer);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitUntillElementCount(WebDriver driver,By locator,int number){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
	}


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

	public void threadsleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void falseFailure(WebDriver driver){
		//this is only for failing condition 
		driver.findElement(By.xpath(".//input[just an error]"));
	}

	public void falseFailure(WebDriver driver,String testStep){
		//this is only for failing condition 
		System.out.println("This is failed by false failure in testStep-->"+testStep);
		driver.findElement(By.xpath(".//input[just an error]"));
	}

	public String getAttributeByJse(WebDriver driver, By locator, String attributeName){

		JavascriptExecutor je = (JavascriptExecutor) driver;
		String attribute = je.executeScript("return arguments[0].getAttribute('" + attributeName + "')",driver.findElement(locator)).toString();
		return attribute;

	}

	public void setAttributeByJse(WebDriver driver, By locator, String AttributeName,String AttributeValue ){	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].setAttribute('" + AttributeName + "','" + AttributeValue + "')",driver.findElement(locator));

	}

	public String getElementPropertyByJse(WebDriver driver, By locator, String propertyName){

		JavascriptExecutor je = (JavascriptExecutor) driver;
		String attribute = je.executeScript("return arguments[0]."+ propertyName,driver.findElement(locator)).toString();
		return attribute;

	}



	public void waitElementsUntilDisplayed(WebDriver driver ,By locator, int count){//===Wait for elements until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.numberOfElementsToBe(locator,count));
	}


	public void uploadFileByRobotAfterClickBrowseButton(WebDriver driver, String filePath) throws AWTException{
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	public void clickByAction(WebDriver driver , By locator) {

		Actions    action = new Actions(driver);
		WebElement we     = driver.findElement(locator);
		action.moveToElement(we).perform();
		action.click().build().perform();
	}


	public void sendKeysByAction(WebDriver driver, By locator, String data){
		Actions    action = new Actions(driver);
		WebElement we     = driver.findElement(locator);
		action.moveToElement(we);
		action.click();
		action.sendKeys(data);
		action.build().perform();

	}



	/*This function should be used to select dropdown
	 * following arguments are required.
	 * @elementIdentifier: Type of element we require to wait
	 * @elementValue: Value of that element
	 * @dropdownType: Dropdown argument
	 * @dropDownValue: value to select
	 */	
	public void selectFromDropDown(WebDriver driver, By locator, String dropdownType, String dropDownValue)
	{	
		WebElement element = findEelement(driver, locator);
		Select dropdown = new Select(element);
		//select based on the type
		if(dropdownType.equalsIgnoreCase("Text"))
			dropdown.selectByVisibleText(dropDownValue);
		else if(dropdownType.equalsIgnoreCase("Value"))
			dropdown.selectByValue(dropDownValue);
		else if(dropdownType.equalsIgnoreCase("Index"))			
			dropdown.selectByIndex(Integer.parseInt(dropDownValue));
	}



	public void clickAlertOK(WebDriver driver){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}


	public void printCaseInfo(String packageName, String release, String environment, String requirement, String testCase, int i){
		System.out.println("############## TESTDATA INFO ################");
		System.out.println("TestData Line running: " + i);
		System.out.println("TestCase running: " + testCase);
		System.out.println("Package: " + packageName);
		System.out.println("Release: " + release);
		System.out.println("Environment: " + environment);
		System.out.println("Requirement: " + requirement);
		System.out.println("#############################################");
	}

	public String getDate(int daysToAdd, String formatDate) throws ParseException{
		String timeStamp = new SimpleDateFormat(formatDate).format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	public String getHour(int hoursToAdd, String format, int yearsToAdd, int daysToAdd) throws ParseException{
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, hoursToAdd); // adds one hour
		cal.add(Calendar.YEAR, yearsToAdd);
		cal.add(Calendar.DAY_OF_MONTH, daysToAdd);
		Date hour = cal.getTime();
		DateFormat df = new SimpleDateFormat(format);
		String reportDate = df.format(hour);
		return  reportDate;
	}

	public void waitUntilPageLoad(final WebDriver driver){
		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState"
						).equals("complete");
			}
		});
	}

	public void dismissAlert(WebDriver driver){

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String isAlertPresent(WebDriver driver) {

		String presentFlag = "";

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = "TRUE";
			// if present consume the alert
			alert.accept();
			//( Now, click on ok or cancel button )

		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}
		System.out.println("ALERT");
		return presentFlag;
	}

	public List<WebElement> findElements(WebDriver driver, By locator) {//==Find elements and return List<WebElement>==>
		waitElementUntilDisplayed(driver, locator);
		List<WebElement> listOfElement = driver.findElements(locator);
		return listOfElement;
	}

	
	/*This function will take format type like "dd/mm/yy" etc and the expected future date
	  * as input and will return the date in a desired format as output
	  * */
	 public static String getFutureDate(WebDriver driver, String format, int futureDays){
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
	  LocalDate localDate = LocalDate.now();  
	  return dtf.format(localDate.plusDays(futureDays));
	 }
	 
	 /*This function will take format type like "dd/mm/yy" etc and the expected Past
	  * as input and will return the date in a desired format as output
	  * */
	 public String getPastDate(WebDriver driver, String format, int futureDays){
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
	  LocalDate localDate = LocalDate.now();
	  return dtf.format(localDate.minusDays(futureDays));
	 }
	 
	 	//This method will wait until all AJAX call complete.It requires jquery enabled
		public static void wait_Until_Requests_to_Complete(WebDriver driver) {
			System.out.println("WAITING FOR AJAX CALLS TO COMPLETE.");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(new Function<WebDriver,Boolean>() {
				public Boolean apply(WebDriver driver) {
					JavascriptExecutor je = (JavascriptExecutor) driver;
					return Boolean.parseBoolean(String.valueOf(je.executeScript(" return jQuery.active === 0")));
				}
			});	
			System.out.println("ALL CALLS COMPLETED");
		}

}
