package envorinment.page;

import envorinment.driver.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BoardPage extends BasePage {

    @AndroidFindBy(id = "add_list_button")
    @FindBy
    private WebElement addListButton;

    @AndroidFindBy(id = "board_sections")
    private WebElement settingsButton;

    @AndroidFindBy(id = "settings_button")
    private WebElement boardSettingsField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.trello:id/drawer_container']//android.widget.FrameLayout//android.widget.FrameLayout[1]")
    private WebElement boardNameButton;

    @AndroidFindBy(id = "edit")
    private WebElement boardNameEditField;

    @AndroidFindBy(id = "button1")
    private WebElement okButton;

    @AndroidFindBy(id = "toolbar_title")
    private WebElement boardNameField;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout")
    private List<WebElement> lists;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.widget.EditText[1]")
    private WebElement firstListName;

    @AndroidFindBy(id = "confirm")
    private WebElement confirmButton;

    public BoardPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoad() {
        waitElement(boardNameField);
        return elementIsVisible(boardNameField);
    }

    public void openSettings() {
        waitElement(settingsButton);
        settingsButton.click();
    }

    public void openBoardSettings() {
        waitElement(boardSettingsField);
        boardSettingsField.click();
    }

    public void openRenameBoardScreen() {
        waitElement(boardNameButton);
        boardNameButton.click();
    }

    public void openListNameEditField() {
        waitElement(firstListName);
        firstListName.click();
        waitElement(confirmButton);
        assert elementIsVisible(confirmButton);

    }

    public void settingsScreenIsOpen() {
        waitElement(boardSettingsField);
        if (!boardSettingsField.isDisplayed()) {
            //throw todo
        }
    }

    public void renameBoardScreenIsOpen() {
        waitElement(boardNameEditField);
        if (!boardNameEditField.isDisplayed()) {
            //throw todo
        }
    }
/*
    public void fillNewBoardName(String name) {
        if (name == null) {
            name = RandomString.make(6);
        }
        boardNameEditField.clear();
        boardNameEditField.sendKeys(name);
        assert checkThatFieldFilledCorrectly(boardNameEditField, name); //todo

        TrelloBoard board = storage.getBoard();
        board.setNewName(name);
        storage.saveBoard(board);
    }

    public void fillNewListName(String name) {
        if (name == null) {
            name = RandomString.make(8);
        }
        firstListName.click();
        firstListName.sendKeys(name);
        assert checkThatFieldFilledCorrectly(firstListName, name); //todo

        TrelloList list = storage.getList() != null ? storage.getList() : new TrelloList(getFirstListName());
        list.setNewName(name);
        storage.saveOrUpdateList(list);
    }*/

    public void confirmBoardRenaming() {
        waitElement(okButton);
        okButton.click();
    }

    public void confirmListRenaming() {
        waitElement(confirmButton);
        confirmButton.click();
    }

    public void backToActivity() {
        goBack();
    }

    public String getBoardName() {
        return boardNameField.getText();
    }

    public String getFirstListName() {return firstListName.getText();}

    public void checkThatDefaultListExist() {
        assert lists.size() > 0; //todo
    }
}
