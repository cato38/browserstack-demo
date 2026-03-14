package com.browserstack.demo.pages;

import com.browserstack.demo.constants.MainPageXPathConstants;
import com.browserstack.demo.interfaces.MainPageInterface;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageObject implements MainPageInterface {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageLoad() {
        waitByXpath(MainPageXPathConstants.APPLY_BUTTON);
    }

    @Override
    public void clickApplyNow() {
        clickElementByXpath(MainPageXPathConstants.APPLY_BUTTON);
    }
}
