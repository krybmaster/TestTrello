package envorinment.page;

import envorinment.driver.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {

    @AndroidFindBy(id = "log_in_button")
    private WebElement loginButton;

    @AndroidFindBy(id = "user_layout")
    private WebElement loginField;

    @AndroidFindBy(id = "password")
    private WebElement passwordField;

    @AndroidFindBy(id = "authenticate")
    private WebElement authenticateButton;

    public WelcomePage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoad() {
        waitElement(loginButton);
        return elementIsVisible(loginButton);
    }

    public void login() {
        waitElement(loginButton);
        loginButton.click();
    }

    public void fillLogin(String login) {
        waitElement(loginField);
        loginField.sendKeys(login);
        checkThatFieldFilledCorrectly(loginField, login);
    }

    public void fillPassword(String password) {
        waitElement(passwordField);
        passwordField.sendKeys(password);
        checkThatFieldFilledCorrectly(passwordField, password);
    }

    public void authentication() {
        waitElement(authenticateButton);
        if (authenticateButton.isEnabled()) {
            authenticateButton.click();
        } else {
            //throw todo
        }
    }

    public void loginScreenIsOpen() {
        waitElement(loginField);
        if (!loginField.isDisplayed()){
            //throw todo
        }
    }
}

