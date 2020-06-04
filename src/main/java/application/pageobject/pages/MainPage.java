package application.pageobject.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage {
    private static String XPATH_OF_CALENDAR = ".//div[@class=\"panel-body sheduleContainer\"]";
    private static String XPATH_OF_TESTS = "//*[text()='Тестирование знаний']";
    private static String XPATH_OF_TEST = ".//a[@href='/Tests/KnowledgeTesting?subjectId=4112']";
    private static String XPATH_OF_KNOWLEDGE = "//*[text()='ЭУМК']";
    private static String XPATH_OF_BOOKS = ".//a[@href='/ComplexMaterial?subjectId=4112']";

    public boolean isMainPage() {
        return new Label(By.xpath(XPATH_OF_CALENDAR), "calendar item").isDisplay();
    }

    public void goToKnowledgeTesting() {
        Button knowledge = new Button(By.xpath(XPATH_OF_TESTS), "Knowledge testing button");
        if (knowledge.isDisplay()) {
            knowledge.click();
        }
    }

    public void goToEUMK() {
        Button eumk = new Button(By.xpath(XPATH_OF_KNOWLEDGE), "EUMK button");
        if (eumk.isDisplay()) {
            eumk.click();
        }
    }

    public void clickGoToTest() {
        Button button = new Button(By.xpath(XPATH_OF_TEST), "Try to go Test 'Test predmet'");
        if (button.isDisplay()) {
            button.click();
        }
    }

    public void clickToEumk() {
        Button link = new Button(By.xpath(XPATH_OF_BOOKS), "Try go to EUMK 'Test predmet'");
        if (link.isDisplay()) {
            link.click();
        }
    }
}
