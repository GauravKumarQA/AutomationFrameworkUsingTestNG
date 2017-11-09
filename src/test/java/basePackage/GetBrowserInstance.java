package basePackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import utils.runFile;

public class GetBrowserInstance {
	
	public WebDriver openLocalBowser(String browserName){
		
		if(browserName.equalsIgnoreCase("chrome")){
			return chromeInit();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			return firefoxInit();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			return ieInit();
		}
		else if (browserName.equalsIgnoreCase("phantomjs")){
			return phantomInit();
		}
		else{
			System.out.println("Enter Correct Browser name");
			return null;
		}
	}

	private WebDriver phantomInit() {
		
		
		File src = new File(System.getProperty("user.dir")+"\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();
		return driver;
	}

	private WebDriver ieInit() {
		
		return null;
	}

	private WebDriver firefoxInit() {
		
		return null;
	}

	private WebDriver chromeInit() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);
		
		// Issue in using this with incognito window  
		//driver.manage().window().maximize();
		
		return driver;
		
	}
	@Test
	public void gridBrowser(){	
		runFile runf = new runFile();
		runf.OpenFile("grid.bat", System.getProperty("user.dir")+"\\drivers\\grid");
		
	}
	
}
