package src.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import src.main.interfaces.PageInterface;

import java.util.concurrent.TimeUnit;

public class PageObject implements PageInterface {

    private WebDriver driver;
    private Wait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver , 30);
    }
    @Override
    public void clickElementByXpath(String xpath) {
        waitByXpath(xpath);
        By by = By.xpath(xpath);
        WebElement webElement = this.driver.findElement(by);
        webElement.click();

    }

    @Override
    public void hoverElementByXpath(String xpath) {
        waitByXpath(xpath);
        Actions actions = new Actions(driver);
        By by = By.xpath(xpath);
        WebElement webElement = this.driver.findElement(by);
        actions.moveToElement(webElement).perform();
    }

    @Override
    public void waitByXpath(String xpath) {
    }

    @Override
    public By wait2(String xpath) {

        return null;
    }

    @Override
    public void waitEditableByXpath(String xpath) {

    }

    @Override
    public void enterTextByXpath(String xpath, String txt) {
        waitByXpath(xpath);
        By by = By.xpath(xpath);
        WebElement webElement = this.driver.findElement(by);
        webElement.sendKeys(txt);

    }

    @Override
    public String getTextOfElement(String xpath) {
        waitByXpath(xpath);
        By by = By.xpath(xpath);
        WebElement webElement = this.driver.findElement(by);
        String txt = webElement.getText();
        return txt;
    }

    @Override
    public Boolean isElementExist(String xpath) {
        try{
            this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if(this.driver.findElement(By.xpath(xpath)).isDisplayed()){
                return true;

            }
        }catch (Exception e){
            Assert.fail(String.format("%s xpath is not visible, %s", xpath, e.getMessage()));
        }
        return  false;
    }

    @Override
    public Boolean isFirstElementExist(String xpath) {
        try{
            By waitBy = wait2(xpath);
            WebElement existingElements = null;
            for(WebElement elements:driver.findElements(waitBy)){
                existingElements = elements;
            }
            if(existingElements.isDisplayed()){
                return true;
            }

        }catch (Exception e){
            Assert.fail("couldn't find element");
        }
        return false;
    }
}
