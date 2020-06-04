package application.pageobject.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

import static framework.browser.PropertyManager.getProperties;

public class DeletePage {
    private static String XPATH_OF_TASK_NAME = "//div[@class='bootbox-body']";
    private static String XPATH_DELETE_BUTTON = "//button[@data-bb-handler='confirm']";
    private static String XPATH_OF_DELETE_LABEL = "//*[text()='Удаление']";

    public boolean isDeletePage() {
        Label deleteLabel = new Label(By.xpath(XPATH_OF_DELETE_LABEL), "Header label");
        return deleteLabel.isDisplay();
    }

    public boolean isOutTest() {
        return new Label(By.xpath(XPATH_OF_TASK_NAME), "Confirm text").getText().contains(getProperties().getProperty("cats.tests.edit.name"));
    }

    public void clickDelete() {
        new Button(By.xpath(XPATH_DELETE_BUTTON), "Confirm delete button").click();
    }
}
