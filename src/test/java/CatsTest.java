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
    public void testKnowledge() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPage(), "U're reached not main page");
        mainPage.goToKnowledgeTesting();
        mainPage.clickGoToTest();
        KnowledgeTestingPage knowledgePage = new KnowledgeTestingPage();
        Assert.assertTrue(knowledgePage.isKnowledgePage(), "U're reached not knowledge testing page. Check locator pls.");

        knowledgePage.createTestClick();
        CreateEditTestPage createPage = new CreateEditTestPage();
        Assert.assertTrue(createPage.isFillTestPageOpen(), "U're reached not create test page. Pls check locator");
        createPage.fillPageAndClick();
//        Assert.assertTrue(knowledgePage.isTestCreated(), "Error with create test.");

        //edit Test
        knowledgePage.findTest();
        CreateEditTestPage editTestPage = new CreateEditTestPage();
        editTestPage.EditTestAndSave();
//        Assert.assertTrue(knowledgePage.isEditedTest(), "Error with edit test.");

//        //questions
        knowledgePage.goToQuestions();
        QuestionsPage questionsPage = new QuestionsPage();
//        Assert.assertTrue(questionsPage.isQuestionPage(), "Error, u're reached not question page");

        //add question from another test
        questionsPage.addQuestionFromClick();
        AddQuestionFromAnotherPage addPage = new AddQuestionFromAnotherPage();
        String questionName = addPage.selectAll();

        //edit question
        questionsPage.editQuestion(questionName);
        CreateEditQuestionPage createEditQuestionPage = new CreateEditQuestionPage();
        createEditQuestionPage.editQuestionAndSave();

        //delete question
        questionsPage.deleteQuestion();
        DeletePage deletePage = new DeletePage();
        deletePage.clickDelete();

        //add question
        questionsPage.addQuestion();
        Assert.assertTrue(createEditQuestionPage.isCreateEditPage(), "Error. u're reached not create page");
        createEditQuestionPage.fillQuestionName();
        createEditQuestionPage.fillDescription();
        createEditQuestionPage.fillAnswer();
        createEditQuestionPage.clickSave();

        questionsPage.backToTest();
        knowledgePage.startTest();

        PassTestPage passTestPage = new PassTestPage();
        passTestPage.clickNext();
        passTestPage.answerOnQuestions();
        passTestPage.backToTest();

        //search task
        knowledgePage.fillSearchString();
        Assert.assertTrue(knowledgePage.isTestFindAndClear(), "Error. test not found! pls check locators and logic.");
//
        //delete task
        knowledgePage.deleteTest();
        deletePage.clickDelete();

        knowledgePage.goToMain();

        mainPage.logOut();
    }

    @Test
    public void testEUMK() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPage(), "U're reached not main page");
        mainPage.goToEUMK();
        mainPage.clickToEumk();

        EumkPage eumkPage = new EumkPage();
        Assert.assertTrue(eumkPage.isOurPage(), " U're reached not eumk page! Pls check ur locator");

        //add
        eumkPage.addBookClick();
        AddEditBookPage addEditBookPage = new AddEditBookPage();
        Assert.assertTrue(addEditBookPage.isAddBookPage(), "U're reached not add dialog. pls, check u'r url");
        addEditBookPage.fillInfoAndClickCreate();
        //add eumk, edit eumk, delete eumk, add

        //edit
        eumkPage.isBookCreated();
        eumkPage.selectBookAndClickEdit();
        addEditBookPage.isEditDialogOpen();
        addEditBookPage.editBookAndSave();
        eumkPage.isBookEdit();

        //delete
        eumkPage.selectBookAndDelete();
        DeletePage deletePage = new DeletePage();
        deletePage.isDeletePage();
        deletePage.clickDelete();

    }

//    @AfterTest
//    public void after() {
//        Browser.quit();
//    }
}