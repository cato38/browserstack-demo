package src.main.interfaces;

import org.openqa.selenium.By;

public interface PageInterface {
    void clickElementByXpath(String xpath);
    void hoverElementByXpath(String xpath);
    void waitByXpath(String xpath);
    By wait2(String xpath);
    void waitEditableByXpath(String xpath);
    void enterTextByXpath(String xpath, String txt);
    String getTextOfElement(String xpath);
    Boolean isElementExist(String xpath);
    Boolean isFirstElementExist(String xpath);
}
