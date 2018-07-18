package org.automation.all.tests.inheritTestNg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.GetBrowserInstance;

public class A {

  
  WebDriver driver;
  GetBrowserInstance gbi = new GetBrowserInstance();
  
  @BeforeClass
  public void initiate() {
    driver = gbi.openLocalBowser();

  }
  
  
  @Test (priority = 1)
  public void t1() {
    System.out.println("t1");
    driver.get("https://www.google.com");
  }
  
  @Test (priority =2)
  public void t2() {
    System.out.println("t2");
    driver.get("https://www.facebook.com");
  }
  
  @AfterClass
  public void tearDown() {
    driver.close();
  }
  
  
}
