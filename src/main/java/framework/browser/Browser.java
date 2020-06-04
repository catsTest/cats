package framework.browser;

import framework.utils.LoggerMes;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static void maxScreen() {
        BrowserManager.getDriver().manage().window().maximize();
    }

    public static void goToURL(String url) {
//        LoggerMes.log("Open Browser");
        BrowserManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        BrowserManager.getDriver().get(PropertyManager.getProperties().getProperty(url));
    }

    public static void switchLastTab() {
//        LoggerMes.log("switch last tab");
        ArrayList<String> newTab = new ArrayList<String>(BrowserManager.getDriver().getWindowHandles());
        BrowserManager.getDriver().switchTo().window(newTab.get(1));
    }

    public static void switchFirstTab() {
//        LoggerMes.log("switch first tab");
        ArrayList<String> newTab = new ArrayList<String>(BrowserManager.getDriver().getWindowHandles());
        BrowserManager.getDriver().switchTo().window(newTab.get(0));
    }

    public static void quit() {
//        LoggerMes.log("close browser");
        BrowserManager.getDriver().quit();
    }

    public static List<String> elementToString(List<WebElement> list) {
        List<String> listOfCategories = new ArrayList<>();
        for (WebElement e : list) {
            listOfCategories.add(e.getText());
        }
        return listOfCategories;
    }

}
