package application.pageobject.pages;

import framework.browser.PropertyManager;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class CreateEditTestPage {
    private static String XPATH_EMAIL = ".//input[@id='inputEmail']";
    private static String XPATH_DESCRIPTION = ".//textarea[@id='textArea']";
    private static String XPATH_TIME = ".//input[@data-ng-model='test.TimeForCompleting']";
    private static String XPATH_QUESTIONS_NUMBER = ".//input[@id='countOfQuestions']";
    private static String XPATH_SAVE_BUTTON = ".//button[@id='saveButton']";

    public boolean isFillTestPageOpen() {
        TextBox name = new TextBox(By.xpath(XPATH_EMAIL), "Test name box");
        return name.isDisplay();
    }

    public void fillPageAndClick() {
        new TextBox(By.xpath(XPATH_EMAIL), "Test name box").fillField(PropertyManager.getProperties().getProperty("cats.tests.create.name"));
        new TextBox(By.xpath(XPATH_DESCRIPTION), "Test description box").fillField(PropertyManager.getProperties().getProperty("cats.tests.create.description"));
        new TextBox(By.xpath(XPATH_TIME), "Test time box").fillField(PropertyManager.getProperties().getProperty("cats.tests.create.time"));
        new TextBox(By.xpath(XPATH_QUESTIONS_NUMBER), "Test number questions").fillField(PropertyManager.getProperties().getProperty("cats.tests.create.count"));
        new Button(By.xpath(XPATH_SAVE_BUTTON), "Create test button").click();
    }

    public void EditTestAndSave() {
        TextBox nameField = new TextBox(By.xpath(XPATH_EMAIL), "Test name box");
        nameField.clear();
        nameField.fillField(PropertyManager.getProperties().getProperty("cats.tests.edit.name"));
        new Button(By.xpath(XPATH_SAVE_BUTTON), "Edit test button").click();
    }
}
