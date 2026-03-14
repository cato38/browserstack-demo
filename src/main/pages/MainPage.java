package src.main.pages;

import org.openqa.selenium.WebDriver;
import src.main.constants.MainPageXPathConstants;
import src.main.interfaces.MainPageInterface;

public class MainPage extends PageObject implements MainPageInterface {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageLoad() {
        super.waitByXpath(MainPageXPathConstants.APPLY_BUTTON);
    }

    @Override
    public void clickApplyNow() {
        super.clickElementByXpath(MainPageXPathConstants.APPLY_BUTTON);
    }
}
