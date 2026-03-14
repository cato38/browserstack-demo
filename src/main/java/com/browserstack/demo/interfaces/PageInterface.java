package com.browserstack.demo.interfaces;

public interface PageInterface {
    void clickElementByXpath(String xpath);
    void hoverElementByXpath(String xpath);
    void waitByXpath(String xpath);
    void waitEditableByXpath(String xpath);
    void enterTextByXpath(String xpath, String text);
    String getTextOfElement(String xpath);
    boolean isElementExist(String xpath);
    boolean isFirstElementExist(String xpath);
}
