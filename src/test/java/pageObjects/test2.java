package pageObjects;

import org.testng.annotations.Test;
import utils.Keywords;

public class test2 {
	Keywords key = new Keywords();
	
	
	@Test
	public void test(){
		
		key.openBrowser("chrome");
		key.getUrl("http://google.com");
		key.captureScreenShotWithUrl();
	}

}
