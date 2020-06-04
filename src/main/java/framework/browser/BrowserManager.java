package framework.browser;

import framework.utils.LoggerMes;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserManager {
    private static WebDriver driver = null;

    private BrowserManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (PropertyManager.getProperties().getProperty("browser")) {
                case "chrome":
                    ChromeOptions option = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("safebrowsing.enabled", "false");
                    option.addArguments("--disable-extensions");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(option);
                    break;
                case "fireFox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalNameOfBrowserException();
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25 ,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        return driver;
    }

}
