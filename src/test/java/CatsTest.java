import application.pageobject.pages.*;
import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CatsTest {
    @BeforeTest
    public void before() {
        Browser.goToURL("URL");
        Browser.maxScreen();
    }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLoginPage(), "Error! was opened another page!");
        loginPage.login();

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPage(), "U're reached not an main page");
    }

    @Test
    public void testKnowledge() throws InterruptedException {
//        MainPage mainPage = new MainPage();
//        mainPage.goToKnowledgeTesting();
//        mainPage.clickGoToTest();
//        KnowledgeTestingPage knowledgePage = new KnowledgeTestingPage();
//
//        knowledgePage.createTestClick();
//        CreateEditTestPage createPage = new CreateEditTestPage();
//        createPage.fillPageAndClick();
////        Assert.assertTrue(knowledgePage.isTestCreated(), "Error with create test.");
//
//        //edit Test
//        knowledgePage.findTest();
//        CreateEditTestPage editTestPage = new CreateEditTestPage();
//        editTestPage.EditTestAndSave();
////        Assert.assertTrue(knowledgePage.isEditedTest(), "Error with edit test.");
//
////        //questions
//        knowledgePage.goToQuestions();
//        QuestionsPage questionsPage = new QuestionsPage();
////        Assert.assertTrue(questionsPage.isQuestionPage(), "Error, u're reached not question page");
//
//        //add question from another test
//        questionsPage.addQuestionFromClick();
//        AddQuestionFromAnotherPage addPage = new AddQuestionFromAnotherPage();
//        String questionName = addPage.selectAll();
//
//        //edit question
//        questionsPage.editQuestion(questionName);
//        CreateEditQuestionPage createEditQuestionPage = new CreateEditQuestionPage();
//        createEditQuestionPage.editQuestionAndSave();
//
//        //delete question
//        questionsPage.deleteQuestion();
//        DeletePage deletePage = new DeletePage();
//        deletePage.clickDelete();
//
//        //add question
//        questionsPage.addQuestion();
//        createEditQuestionPage.fillQuestionName();
//        createEditQuestionPage.fillDescription();
//        createEditQuestionPage.fillAnswer();
//        createEditQuestionPage.clickSave();
//
//        questionsPage.backToTest();
//        knowledgePage.startTest();
//
//        PassTestPage passTestPage = new PassTestPage();
//        passTestPage.clickNext();
//        passTestPage.answerOnQuestions();
//        passTestPage.backToTest();
//
//        //search task
//        knowledgePage.fillSearchString();
////
//        //delete task
//        knowledgePage.deleteTest();
//        deletePage.clickDelete();
//
//        knowledgePage.goToMain();
//
//        mainPage.logOut();
        Thread.sleep(210323);
    }

    @Test
    public void testEUMK() throws InterruptedException {
//        MainPage mainPage = new MainPage();
//        mainPage.goToEUMK();
//        mainPage.clickToEumk();
//
//        EumkPage eumkPage = new EumkPage();
//
//        //add
//        eumkPage.addBookClick();
//        AddEditBookPage addEditBookPage = new AddEditBookPage();
//        addEditBookPage.fillInfoAndClickCreate();
//
//        //edit
//        eumkPage.isBookCreated();
//        eumkPage.selectBookAndClickEdit();
//        addEditBookPage.isEditDialogOpen();
//        addEditBookPage.editBookAndSave();
//        eumkPage.isBookEdit();
//
//        //delete
//        eumkPage.selectBookAndDelete();
//        DeletePage deletePage = new DeletePage();
//        deletePage.isDeletePage();
//        deletePage.clickDelete();
        Thread.sleep(57892);
    }

    @AfterTest
    public void after() {
        Browser.quit();
    }
}