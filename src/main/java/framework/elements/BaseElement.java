package framework.elements;

import framework.browser.BrowserManager;
import framework.utils.LoggerMes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BaseElement {
    private static String name;
    private static By locator;
    protected static WebElement element;

    public BaseElement(By locator, String name) {
        LoggerMes.log("create new element");
        this.name = name;
        this.locator = locator;
        WebDriver driver = BrowserManager.getDriver();
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        WebDriverWait myWait = new WebDriverWait(driver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        this.element = driver.findElement(locator);
    }

    public String getText() {
        LoggerMes.log("get element text");
        return element.getText();
    }

    public void click() {
        LoggerMes.log("click on element");
        element.click();
    }

    public boolean isDisplay() {
        LoggerMes.log("check is element display");
        return element.isDisplayed();
    }

    public void moveToElement() {
        LoggerMes.log("navigate to element");
        Actions actions = new Actions(BrowserManager.getDriver());
        actions.moveToElement(element).build().perform();
    }
}
