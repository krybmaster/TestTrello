package envorinment.page;

import envorinment.driver.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected AppiumDriver driver;
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver trelloAndroidDriver) {
        this.driver = trelloAndroidDriver.getDriver();
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    public abstract boolean isLoad();

    protected void goBack() {
        driver.navigate().back();
    }

    protected void waitElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean elementIsVisible(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            waitElement(element);
            return element.isDisplayed();
        }
    }

    protected boolean checkThatFieldFilledCorrectly(WebElement element, String sting) {
        return element.getText().equals(sting);
    }
}
