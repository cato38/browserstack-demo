package com.browserstack.demo.pages;

import com.browserstack.demo.interfaces.PageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PageObject implements PageInterface {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    @Override
    public void waitByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    @Override
    public void waitEditableByXpath(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    @Override
    public void clickElementByXpath(String xpath) {
        waitEditableByXpath(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void hoverElementByXpath(String xpath) {
        waitByXpath(xpath);
        WebElement element = driver.findElement(By.xpath(xpath));
        new Actions(driver).moveToElement(element).perform();
    }

    @Override
    public void enterTextByXpath(String xpath, String text) {
        waitEditableByXpath(xpath);
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Override
    public String getTextOfElement(String xpath) {
        waitByXpath(xpath);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    @Override
    public boolean isElementExist(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            Assert.fail(String.format("XPath not visible: %s — %s", xpath, e.getMessage()));
            return false;
        }
    }

    @Override
    public boolean isFirstElementExist(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
            List<WebElement> elements = driver.findElements(By.xpath(xpath));
            return !elements.isEmpty() && elements.get(0).isDisplayed();
        } catch (Exception e) {
            Assert.fail(String.format("No elements found for XPath: %s — %s", xpath, e.getMessage()));
            return false;
        }
    }
}
