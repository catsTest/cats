package application.pageobject.pages;

import framework.browser.PropertyManager;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.internal.MouseAction;

public class EumkPage {
    private static String XPATH_OF_PAGE = "//*[text()='Список ЭУМК']";
    private static String XPATH_OF_ADD_BUTTON = "//a[@id='addNewComplexMaterial']";
    private static String XPATH_OF_BOOK = "//*[text()='%s']";
    private static String XPATH_OF_EDIT_BUTTON = "//a[@id='editSelectedItem']";
    private static String XPATH_OF_DELETE_BUTTON = "//a[@id='deleteSelectedItem']";

    public boolean isOurPage() {
        Label checkLabel = new Label(By.xpath(XPATH_OF_PAGE), "Test buttin for page");
        return checkLabel.isDisplay();
    }

    public void addBookClick() {
        Button addButton = new Button(By.xpath(XPATH_OF_ADD_BUTTON), "add button");
        addButton.click();
    }

    public boolean isBookCreated() {
        return new Button(By.xpath(String.format(XPATH_OF_BOOK, PropertyManager.getProperties()
                .getProperty("cats.eumk.book.create.name"))), "search book").isDisplay();
    }

    public void selectBookAndClickEdit() {
        Button book = new Button(By.xpath(String.format(XPATH_OF_BOOK, PropertyManager.getProperties()
                .getProperty("cats.eumk.book.create.name"))), "search book");
        book.click();
        Button editButton = new Button(By.xpath(XPATH_OF_EDIT_BUTTON), "Edit book button");
        editButton.click();
    }

    public boolean isBookEdit() {
        Button editedBook = new Button(By.xpath(String.format(XPATH_OF_BOOK, PropertyManager.getProperties()
                .getProperty("cats.eumk.book.edit.name"))), "EditedBook");
        return editedBook.isDisplay();
    }

    public void selectBookAndDelete() {
        Button editedBook = new Button(By.xpath(String.format(XPATH_OF_BOOK, PropertyManager.getProperties()
                .getProperty("cats.eumk.book.edit.name"))), "EditedBook");
        editedBook.click();
        Button deleteButton = new Button(By.xpath(XPATH_OF_DELETE_BUTTON), "delete button");
        deleteButton.click();
    }
}
