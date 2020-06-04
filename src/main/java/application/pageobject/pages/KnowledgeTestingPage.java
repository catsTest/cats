package application.pageobject.pages;

import framework.browser.Browser;
import framework.browser.BrowserManager;
import framework.elements.Button;
import framework.elements.TextBox;
import framework.utils.LoggerMes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static framework.browser.PropertyManager.*;

public class KnowledgeTestingPage {
    private static String XPATH_OF_TESTS_LINK = ".//a[@href='#/tests']";
    private static String XPATH_OF_CREATE_TEST = ".//a[@id='addNewTestButton']";
    private static String XPATH_GET_ALL_TESTS_TABLES = ".//section[@class='content']//div[@class='table-responsive ng-scope']";
    private static String XPATH_TEST_NAME = "//td[@class='ng-binding']";
    private static String XPATH_SEARCH_BOX = "//input[@data-ng-model='query']";

    public boolean isKnowledgePage() {
        Button testsButton = new Button(By.xpath(XPATH_OF_TESTS_LINK), "Tests link button");
        return testsButton.isDisplay();
    }

    public boolean isEditedTest() {
        String name = getProperties().getProperty("cats.tests.edit.name");
        List<String> names = findAllTests().stream().map(WebElement::getText).collect(Collectors.toList());
        return names.contains(name) && !isTestCreated();
    }

    public void createTestClick() {
        Button createTestButton = new Button(By.xpath(XPATH_OF_CREATE_TEST), "Create test Button");
        if (createTestButton.isDisplay()) {
            createTestButton.click();
        }
    }

    public void findTest() {
        String testName = getProperties().getProperty("cats.tests.create.name");
        WebElement ourTest = findMyTest(testName);
        WebElement changeButton = ourTest.findElement(By.xpath("..//a[@data-tooltip='Редактировать тест']"));
        changeButton.click();
    }

    public boolean isTestCreated() {
        String name = getProperties().getProperty("cats.tests.create.name");
        List<String> names = findAllTests().stream().map(WebElement::getText).collect(Collectors.toList());
        return names.contains(name);
    }

    private List<WebElement> findAllTests() {
        WebDriver driver = BrowserManager.getDriver();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return new ArrayList<>(driver.findElements(By.xpath(XPATH_TEST_NAME)));
    }

    private WebElement findMyTest(String testName) {
        List<WebElement> test = findAllTests();
        return test.stream().filter(webElement -> webElement.getText().equals(testName)).findAny().orElse(null);
    }

    private List<WebElement> findAllTestTables() {
        LoggerMes.log("find all tables");
        WebDriver driver = BrowserManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return new ArrayList<>(driver.findElements(By.xpath(XPATH_GET_ALL_TESTS_TABLES)));
    }

    public void goToQuestions() {
        String testName = getProperties().getProperty("cats.tests.edit.name");
        WebElement ourTest = findMyTest(testName);
        WebElement changeButton = ourTest.findElement(By.xpath("..//a[@data-tooltip='Перейти к вопросам']"));
        changeButton.click();
    }

    public void deleteTest() {
        String testName = getProperties().getProperty("cats.tests.edit.name");
        WebElement ourTest = findMyTest(testName);
        WebElement deleteButton = ourTest.findElement(By.xpath("..//a[@data-tooltip='Удалить тест']"));
        deleteButton.click();
    }

    public void fillSearchString() {
        String testName = getProperties().getProperty("cats.tests.edit.name");
        TextBox searchBox = new TextBox(By.xpath(XPATH_SEARCH_BOX), "Search box");
        searchBox.fillField(testName);
    }

    public boolean isTestFindAndClear() {
        String testName = getProperties().getProperty("cats.tests.edit.name");
        boolean isFind = findMyTest(testName).isEnabled();
        new TextBox(By.xpath(XPATH_SEARCH_BOX), "Serach box").clear();
        return isFind;
    }

    public void startTest() {
        String testName = getProperties().getProperty("cats.tests.edit.name");
        WebElement ourTest = findMyTest(testName);
        WebElement changeButton = ourTest.findElement(By.xpath("..//a[@data-tooltip='Пройти тест']"));
        changeButton.click();
    }

    public void goToMain() {
        new Button(By.xpath("//a[@href='/Lms']"), "go to main page btn").click();
    }
}
