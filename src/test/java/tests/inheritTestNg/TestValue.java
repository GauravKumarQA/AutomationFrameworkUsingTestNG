package tests.inheritTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestValue {

  @Test
  public void testuif() {
    System.out.println(System.getProperty("environment") + "----" + System.getProperty("browser"));
    Assert.fail();
  }

}
