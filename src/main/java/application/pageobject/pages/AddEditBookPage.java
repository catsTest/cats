package application.pageobject.pages;

import framework.browser.PropertyManager;
import framework.elements.Button;
import framework.elements.SelectField;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class AddEditBookPage {
    private static String XPATH_OF_NAME_FILED = "//input[@id='Name']";
    private static String XPATH_OF_SELECTOR = "//select[@id='SelectedSubjectId']";
    private static String XPATH_SELECT_OPTION = "//select[@id='SelectedSubjectId']//option[1]";
    private static String XPATH_SAVE_BUTTON = "//a[@id='saveButton']";

    public boolean isAddBookPage() {
        TextBox nameBox = new TextBox(By.xpath(XPATH_OF_NAME_FILED), "name field");
        return nameBox.isDisplay();
    }

    public void fillInfoAndClickCreate() {
        TextBox nameBox = new TextBox(By.xpath(XPATH_OF_NAME_FILED), "name field");
        nameBox.fillField(PropertyManager.getProperties().getProperty("cats.eumk.book.create.name"));
        Button selector = new Button(By.xpath(XPATH_OF_SELECTOR), "Selector for subject");
        selector.click();
        Button selectedButton = new Button(By.xpath(XPATH_SELECT_OPTION), "select first option");
        selectedButton.click();
        Button saveButton = new Button(By.xpath(XPATH_SAVE_BUTTON), "save button");
        saveButton.click();
    }

    public boolean isEditDialogOpen() {
        TextBox name = new TextBox(By.xpath(XPATH_OF_NAME_FILED), "Old name filed");
        return name.getText().equals(PropertyManager.getProperties().getProperty("cats.eumk.book.create.name"));
    }

    public void editBookAndSave() {
        TextBox nameField = new TextBox(By.xpath(XPATH_OF_NAME_FILED), "Name filed");
        nameField.clear();
        nameField.fillField(PropertyManager.getProperties().getProperty("cats.eumk.book.edit.name"));
        Button saveButton = new Button(By.xpath(XPATH_SAVE_BUTTON), "save edit button");
        saveButton.click();
    }
}
