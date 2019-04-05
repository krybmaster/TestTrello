package envorinment.page;

import envorinment.driver.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index=2]")
    private WebElement addBoardButton;

    @AndroidFindBy(id = "board_name")
    private WebElement creatingBoardNameField;

    @AndroidFindBy(id = "button1")
    private WebElement creatingBoardCreateButton;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoad() {
        waitElement(addBoardButton);
        return elementIsVisible(addBoardButton);
    }

    public void addBoard() {
        waitElement(addBoardButton);
        addBoardButton.click();
    }

    public void creatingBoardScreenIsOpen() {
        waitElement(creatingBoardNameField);
        if (!creatingBoardNameField.isDisplayed()){
            //throw todo
        }
    }

    public void fillBoardName(String name) {
        if (name == null) {
            name = RandomString.make(6);
        }
        creatingBoardNameField.sendKeys(name);
        checkThatFieldFilledCorrectly(creatingBoardNameField, name);
        //saveInStorage(new TrelloBoard(name));
    }


    public void createBoard() {
        waitElement(creatingBoardCreateButton);
        if (creatingBoardCreateButton.isEnabled()) {
            creatingBoardCreateButton.click();
        } else {
            //throw todo
        }
    }
}
