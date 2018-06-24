package org.automation.all.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.Keywords;

public class TestLoggingPO {
  Keywords key = new Keywords();
  
  // Locators:
  public By searchFieldXpath = By.xpath("Hello World");
  
  // Functions
  public void getUrl(WebDriver driver)
  {
      key.getUrl(driver,Constants.url);
  }
  
  
  public void sendkeysToSearchField(WebDriver driver, String enterText) throws Exception  {
      key.findElementSendKey(driver,searchFieldXpath,enterText);
  }
}
