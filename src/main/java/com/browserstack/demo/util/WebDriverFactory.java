package com.browserstack.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverFactory {

    public RemoteWebDriver createRemoteWebDriver(URL url, DesiredCapabilities capabilities) {
        return new RemoteWebDriver(url, capabilities);
    }

    public WebDriver createLocalChromeDriver() {
        String chromedriverPath = System.getProperty("user.dir") + "/chromedriver_mac64/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return new ChromeDriver(options);
    }
}
