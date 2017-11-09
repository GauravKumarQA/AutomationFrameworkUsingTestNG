package pageObjects;


import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Keywords;

public class test {

	
	
	@BeforeClass
	public void openBrowser(){
	key.openBrowser(Constants.browser);
	}
			
	Keywords key = new Keywords();
	@Test
	public void testjs(){
	try {
		key.DriverGet(Constants.url);
		key.captureScreenShot();
		key.FindEelemtSenKey(By.xpath(".//*[@id='email']"), "gaurav.choudhary45@yahoo.in");
		key.captureScreenShot();
		key.FindEelemtSenKey(By.xpath(".//*[@id='pass']"), "Gaurav@12");
		key.captureScreenShot();
		key.FindEelementClick(By.xpath(".//button[@id='loginbutton']"));
		key.captureScreenShot();
		
	} catch (IOException e) {
			e.printStackTrace();
			System.out.println("RunTimeError");
			Assert.fail();
		}
		
	}
	
}
