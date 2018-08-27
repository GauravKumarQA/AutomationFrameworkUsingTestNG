package tests.priorityTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.GetBrowserInstance;

public class TestClass2 {
  WebDriver driver;
  GetBrowserInstance gbi = new GetBrowserInstance();
  
  @BeforeClass
  public void initiate() {
    driver = gbi.openLocalBowser();

  }
  
  
  @Test (priority = 1)
  public void t3() {
    System.out.println("t3");
    driver.get("https://www.twitter.com");
  }
  
  @Test (priority =2)
  public void t4() {
    System.out.println("t4");
    driver.get("https://www.myntra.com");
  }
  
  @AfterClass
  public void tearDown() {
    driver.close();
  }
  
}
