package application.pageobject.pages;

import framework.browser.PropertyManager;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class QuestionsPage {
    private static String XPATH_OF_QUESTION_PAGE = "//div[@class='ng-scope']//h3";
    private static String XPATH_ADD_QUESTION_BTN = "//a[@id='addNewTestButton']";
    private static String XPATH_ADD_QUESTION_FROM = "//a[text()='Добавить вопросы из другого теста']";
    private static String XPATH_TABLE = "//td[@class='ng-binding'][2]";
    private static String XPATH_OF_QUESTION_NAME = "//tbody[@id='sortable']//td[2][contains(text(),'%s')]";
    private static String XPATH_EDIT_BTN = "/..//i[@class='fa fa-edit fa-1x']";
    private static String XPATH_DELETE_BTN = "/..//i[@class='fa fa-trash-o fa-2x']";
    private static String XPATH_BACK_TO_TESTS = "//a[@data-ng-href='#/tests']";

    public boolean isQuestionPage() {
        Label testLabel = new Label(By.xpath(XPATH_ADD_QUESTION_BTN), "Question test label");
        return testLabel.isDisplay();
    }

    public void addQuestion() {
        new Button(By.xpath(XPATH_ADD_QUESTION_BTN), "Question btn").click();
    }

    public void addQuestionFromClick() {
        new Button(By.xpath(XPATH_ADD_QUESTION_FROM), "Add question from another test btn").click();
    }

    public void editQuestion(String questionName) {
        Button editButton = new Button(By.xpath(String.format(XPATH_OF_QUESTION_NAME, questionName) + XPATH_EDIT_BTN), "Edit btn");
        editButton.click();
    }

    public void deleteQuestion() {
        Button deleteBtn = new Button(By.xpath(String.format(XPATH_OF_QUESTION_NAME,
                PropertyManager.getProperties().getProperty("cats.tests.questions.edit.name")) + XPATH_DELETE_BTN), "Delete btn");
        deleteBtn.click();
    }

    public void backToTest() {
        new Button(By.xpath(XPATH_BACK_TO_TESTS), "back arrow").click();
    }
}
