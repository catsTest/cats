package application.pageobject.pages;

import framework.browser.BrowserManager;
import framework.browser.PropertyManager;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateEditQuestionPage {
    private static String XPATH_ADD_VARIANT_BTN = "//a[@id='addNewVariant']";
    private static String XPATH_QUESTION_TEXT = "//input[@placeholder='Текст вопроса']";
    private static String XPATH_QUESTION_BODY = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']";
    private static String XPATH_ADD_ANSWER = ".//a[@id='addNewVariant']";
    private static String XPATH_SAVE_BTN = "//button[@id='saveButton']";
    private static String XPATH_OF_RB = "//input[@name='answer']";
    private static String XPATH_OF_ANSWER = "/../..//td[@style='border: none']//input";

    public boolean isCreateEditPage() {
        return new Button(By.xpath(XPATH_ADD_VARIANT_BTN), "Add variant btn").isDisplay();
    }

    public void fillQuestionName() {
        TextBox textName = new TextBox(By.xpath(XPATH_QUESTION_TEXT), "Question name filed");
        textName.click();
        textName.fillField(PropertyManager.getProperties().getProperty("cats.tests.questions.create.question"));
    }

    public void fillDescription() {
        WebDriver driver = BrowserManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body")));
        WebElement descriptionField = driver.findElement(By.cssSelector("body"));
        descriptionField.click();
        new Actions(driver)
                .sendKeys(PropertyManager.getProperties().getProperty("cats.tests.questions.create.task")).perform();
        driver.switchTo().defaultContent();
    }

    public void fillAnswer() {
        WebDriver driver = BrowserManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Button addVariantBtn = new Button(By.xpath(XPATH_ADD_ANSWER), "add variant btn");
        addVariantBtn.click();
        new Button(By.xpath(XPATH_OF_RB), "answer radio btn").click();
        List<WebElement> answers = driver.findElements(By.xpath(XPATH_OF_RB+XPATH_OF_ANSWER));
        answers.forEach(el -> {
            el.sendKeys("1111");
        });
    }

    public void editQuestionAndSave() {
        TextBox questionName = new TextBox(By.xpath(XPATH_QUESTION_TEXT), "Question name text box");
        questionName.click();
        questionName.clear();
        questionName.fillField(PropertyManager.getProperties().getProperty("cats.tests.questions.edit.name"));
        Button saveBtn = new Button(By.xpath(XPATH_SAVE_BTN), "Btn save");
        saveBtn.click();
    }

    public void clickSave() {
        Button saveBtn = new Button(By.xpath(XPATH_SAVE_BTN), "Btn save");
        saveBtn.click();
    }
}
