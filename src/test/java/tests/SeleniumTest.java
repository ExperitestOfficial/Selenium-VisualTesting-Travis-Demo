package tests;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;


public class SeleniumTest {

    private static final String CLOUD_ACCESS_KEY = System.getenv("CLOUD_ACCESS_KEY");
    private static final String VISUAL_ACCESS_KEY = System.getenv("VISUAL_ACCESS_KEY");
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws Exception {

        url = new URL("https://sales.experitest.com:443/wd/hub");
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        dc.setCapability(CapabilityType.VERSION, "Any");
        dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        dc.setCapability("accessKey", CLOUD_ACCESS_KEY);
        dc.setCapability("testName", "Quick Start Chrome Browser Demo");
        dc.setCapability("seleniumScreenShot", true);
        driver = new RemoteWebDriver(url, dc);
    }


    @Test
    public void testExperitest() {
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
        // you should one time set your access key:
        in.Visual.setAccessKey(VISUAL_ACCESS_KEY);
        boolean result = in.Visual.verify(driver, "GoogleTest");
        System.out.println("**" + in.Visual.getLastResultUrl() + "**");
        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}