package com.browserstack.demo;

import com.browserstack.demo.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    // Set BROWSERSTACK_USERNAME and BROWSERSTACK_ACCESS_KEY as environment variables.
    // Never commit credentials to source control.
    private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String HUB_URL =
            "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("name", "BrowserStack Demo Test");

        driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://testing-axp-career.proxify.io");

        mainPage = new MainPage(driver);
        mainPage.waitUntilPageLoad();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
