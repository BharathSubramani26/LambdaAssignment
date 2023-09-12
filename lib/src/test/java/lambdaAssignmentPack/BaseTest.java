package lambdaAssignmentPack;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	String username="bharath.subramaniaspiresys";
	String accessKey="yhJxW9jv7GAT9qr10cfFcA42b6hz7lHYFiWTvUgxtQHNFPzyli";
	String browser;
	String version;
	String platform;

	@BeforeTest
	public void lambdatest(ITestContext context) throws InterruptedException {
		browser = context.getCurrentXmlTest().getParameter("browser");
		version = context.getCurrentXmlTest().getParameter("version");
		platform = context.getCurrentXmlTest().getParameter("platform");
	}

	public RemoteWebDriver DesiredCapabailitiesSetup(String browser, String browserversion, String platform) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", browserversion);
		capabilities.setCapability("platform", platform);
		capabilities.setCapability("visual", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("selenium_version", "4.8.0");
		capabilities.setCapability("w3c", true);
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":"
					+ accessKey+ gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL : Unable to lanuch the URL");
		}
		return driver;
	}
	
	  
	/*
	 * @BeforeClass public void ConfigureSelenium() throws MalformedURLException {
	 * 
	 * ChromeOptions browserOptions = new ChromeOptions();
	 * browserOptions.setPlatformName("Windows 10");
	 * browserOptions.setBrowserVersion("117.0"); HashMap<String, Object> ltOptions=
	 * new HashMap<String, Object>();
	 * ltOptions.put("username","bharath.subramaniaspiresys");
	 * ltOptions.put("accessKey",
	 * "yhJxW9jv7GAT9qr10cfFcA42b6hz7lHYFiWTvUgxtQHNFPzyli");
	 * ltOptions.put("project", "LambdaTest Auto Assignment");
	 * ltOptions.put("selenium_version", "4.8.0"); ltOptions.put("w3c", true);
	 * browserOptions.setCapability("LT:Options", ltOptions); driver = new
	 * RemoteWebDriver(new URL("https://" + ltOptions.get("username") + ":" +
	 * ltOptions.get("accessKey") + gridURL), browserOptions);
	 * 
	 * }
	 */
	  
	 
}
