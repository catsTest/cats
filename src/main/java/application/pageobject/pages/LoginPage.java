package application.pageobject.pages;


import framework.browser.PropertyManager;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import framework.utils.LoggerMes;
import org.openqa.selenium.By;

public class LoginPage {
    private static String XPATH_LOGIN_FIELD = ".//input[@id=\"UserName\"]";
    private static String XPATH_PASSWORD_FILED = ".//input[@id=\"Password\"]";
    private static String XPATH_SIGN_IN_BTN = ".//input[@class=\"btn bg-blue btn-block\"]";
    private static String XPATH_OF_LOGIN_TABLE = "//div[@class=\"login-wrap\"]";

    private void clickLoginFiled() {
        new TextBox(By.xpath(XPATH_LOGIN_FIELD), "login field").click();
        LoggerMes.log("click login ok");
    }

    private void feelLogin() {
        new TextBox(By.xpath(XPATH_LOGIN_FIELD), "login field").fillField(PropertyManager.getProperties().getProperty("login"));
        LoggerMes.log("feel login");
    }

    private void clickPassword() {
        new TextBox(By.xpath(XPATH_PASSWORD_FILED), "Password field").click();
    }

    private void feelPassword() {
        new TextBox(By.xpath(XPATH_PASSWORD_FILED), "password field").fillField(PropertyManager.getProperties().getProperty("password"));
    }

    private void clickSignIn() {
        new Button(By.xpath(XPATH_SIGN_IN_BTN), "SignIn btn").click();
    }

    public void login() {
        clickLoginFiled();
        feelLogin();
        clickPassword();
        feelPassword();
        clickSignIn();
    }

    public boolean isLoginPage() {
        return new Label(By.xpath(XPATH_OF_LOGIN_TABLE), "Login table").isDisplay();
    }
}
