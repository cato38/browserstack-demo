package src.main.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import src.main.pages.MainPage;
import src.main.util.WebDriverFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String USERNAME ="cagataytomu_ZliY1D";

    public static final String KEY ="yoDXsXJZc6zyausxFKM3";

    public static final String URL = "https://"+USERNAME+":"+KEY+"@hub-cloud.browserstack.com/wd/hub";
    protected static WebDriver driver;
    protected static MainPage mainPage;


    @BeforeMethod
    public static void setUpSuite() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("borwser" , "chrome");
        capabilities.setCapability("browser_version", "100");

        WebDriver bDriver = new RemoteWebDriver(new URL(URL), capabilities);
        bDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        bDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        bDriver.get("https://testing-axp-career.proxify.io");
        bDriver.manage().window().maximize();

        mainPage = new MainPage(bDriver);

    }

    }
