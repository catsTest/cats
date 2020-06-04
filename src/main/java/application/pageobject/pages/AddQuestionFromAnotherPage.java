package application.pageobject.pages;

import framework.browser.Browser;
import framework.browser.BrowserManager;
import framework.browser.NoElementsFound;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddQuestionFromAnotherPage {
    private static String XPATH_OF_QUESTION = "//tr[@data-ng-repeat='question in questionsFromBase | filter : query']";
    private static String XPATH_OF_SELECT = "//select//option";
    private static String XPATH_OF_OPTION = "//select//option[%d]";
    private static String XPATH_ADD = "//a[@data-ng-click='add()']";
    private static String XPATH_OF_CHECK = "//input[@type='checkbox']";
    private static String XPATH_OF_NAME = "//td[@class='ng-binding']";
    //*[text()='Не найдено ни одного вопроса']

    public void clickAdd() {
        new Button(By.xpath(XPATH_ADD), "Add question btn").click();
    }

    public String selectAll() {
        WebDriver driver = BrowserManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> options = driver.findElements(By.xpath(XPATH_OF_SELECT));
        new Button(By.xpath(String.format(XPATH_OF_OPTION, options.size())), "Last option").click();
        if (!driver.findElements(By.xpath(XPATH_OF_QUESTION)).isEmpty()) {
            WebElement question = driver.findElements(By.xpath(XPATH_OF_QUESTION)).stream().findFirst().get();
            WebElement checkBox = question.findElement(By.xpath(XPATH_OF_CHECK));
            checkBox.click();
            clickAdd();
            return question.findElement(By.xpath(XPATH_OF_NAME)).getText();
        } else {
            throw new NoElementsFound();
        }
    }
}
