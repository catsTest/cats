package application.pageobject.pages;

import framework.elements.Button;
import org.openqa.selenium.By;

public class PassTestPage {
    private static String XPATH_BTN_NEXT = "//button[@ng-click='nextButtonClicked()']";
    private static String XPATH_OF_ANSWER = "//input[@name='answers']";
    private static String XPATH_OF_ANSWER_BTN = "//button[@id='answerButton']";
    private static String XPATH_OF_BACK_TO_TEST = "//a[@href='#/tests']";

    public  void clickNext() {
        new Button(By.xpath(XPATH_BTN_NEXT), "next btn").click();
    }

    public void answerOnQuestions() {
        Button answer = new Button(By.xpath(XPATH_OF_ANSWER_BTN), "btn answer");
        while(answer.isDisplay()) {
            new Button(By.xpath(XPATH_OF_ANSWER), "check btn of answer").click();
            answer.click();
        }
    }

    public void backToTest() {
        new Button(By.xpath(XPATH_OF_BACK_TO_TEST), "back to test btn").click();
    }
}
