package framework.elements;

import framework.browser.BrowserManager;
import framework.utils.LoggerMes;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectField {
    public static void selectAndClick(By locator, String date) {
        LoggerMes.log("select data");
        Select selector = new Select(BrowserManager.getDriver().findElement(locator));
        selector.selectByValue(date);
    }
}
