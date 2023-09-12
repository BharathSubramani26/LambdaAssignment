package lambdaAssignmentPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.*;

public class LambdaAssignmentClass1 extends BaseTest{
	boolean status = false;
	String expectedURL="https://www.lambdatest.com/integrations";
	@Test
    public void testSimple() throws Exception {
       try {
    	   RemoteWebDriver driver=DesiredCapabailitiesSetup(browser, version, platform);
    	   driver.get("https://www.lambdatest.com");
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); 
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("__next")));
            WebElement lnkSeeAllIntegration=driver.findElement(By.xpath("//*[@class=\"clearfix\"]//div//div//a"));
            // Javascript executor
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lnkSeeAllIntegration);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", lnkSeeAllIntegration);
            Set<String> windows = driver.getWindowHandles();
            System.out.print("Totale Number of windows"+windows.size());
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL,"Failed! Actual URL is not matched with Expected URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }

}
