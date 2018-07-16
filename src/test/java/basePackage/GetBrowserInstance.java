/*
 * @Author-Gaurav Kumar and Aakash Gupta
 * Automation frame work Base Browser handling class.
 * Configured for Chrome, Firefox, IE, and PhantomJS.
 *Remote webDriver is also present.
 * 
 * */


package basePackage;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Constants;


public class GetBrowserInstance {
	String browserName = Constants.browser;
	public WebDriver openLocalBowser(){
		
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
	
/*	@Test
	public void gridBrowser() throws IOException, InterruptedException{	
		
		
		
		Runtime rt = Runtime.getRuntime();
		//rt.exec(new String[]{"cmd.exe","/c","start"});
		
		rt.exec("cmd.exe /c cd  \""+"D:\\TESTING\\TPworkSpace\\SampleProject\\drivers\\grid\\"+"\" & start cmd.exe /k \"java -jar selenium-server-standalone-3.6.0.jar -role hub -port 4445");
		
		Thread.sleep(10000);
		
		//rt.exec("cmd.exe /c cd  \""+"D:\\TESTING\\TPworkSpace\\SampleProject\\drivers\\grid\\"+"\" & start cmd.exe /k \"java -jar selenium-server-standalone-3.6.0.jar -role webdriver -hub http://192.168.1.7:4445/grid/register -port 4446");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome\\chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		
		try {
			WebDriver browser = new RemoteWebDriver(new URL("http://192.168.1.7:4445/wd/hub"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	
 		
	}*/
	
}
