package src.main.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverFactory {

        public RemoteWebDriver createRemoteWebDriver(URL url){

            RemoteWebDriver bDriver = null;
            return bDriver;
        }
        public WebDriver createWebDriver(){
            WebDriver driver = null;
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver_mac64/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            driver = new ChromeDriver(chromeOptions);
            return driver;

        }
}
