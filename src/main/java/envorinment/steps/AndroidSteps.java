package envorinment.steps;

import envorinment.driver.AndroidDriver;
import envorinment.page.BoardPage;
import envorinment.page.MainPage;
import envorinment.page.WelcomePage;

public class AndroidSteps {

    private AndroidDriver driver;
    private WelcomePage welcomePage;
    private MainPage mainPage;
    private BoardPage boardPage;

    public static final String LOGIN = "karatel-dead2@mail.ru";
    public static final String PASSWORD = "Zikfrid82654";

    public AndroidSteps(AndroidDriver driver) {
        //entity = (AndroidEntity) driver.entity;
        this.driver = driver;
        welcomePage = new WelcomePage(driver);
        mainPage = new MainPage(driver);
        boardPage = new BoardPage(driver);
    }

    public void activityIsLoad(String activity) {
        switch (activity) {
            case "welcome":
                assert welcomePage.isLoad(); //TODO
                break;
            case "main":
                assert mainPage.isLoad();
                break;
            case "board":
                assert boardPage.isLoad();
                break;
        }
    }

    public void clickOnButton(String button) {
        switch (button) {
            case "login":
                welcomePage.login();
                break;
            case "authenticate":
                welcomePage.authentication();
                break;
            case "add board":
                mainPage.addBoard();
                break;
            case "create board":
                mainPage.createBoard();
                break;
            case "settings":
                boardPage.openSettings();
                break;
            case "ok":
                boardPage.confirmBoardRenaming();
                break;
            case "confirm":
                boardPage.confirmListRenaming();
                break;
        }
    }

    public void clickOnField(String field) {
        switch (field) {
            case "board settings":
                boardPage.openBoardSettings();
                break;
            case "board name":
                boardPage.openRenameBoardScreen();
                break;
            case "list name":
                boardPage.openListNameEditField();
                break;
        }
    }

    public void fill(String parameter) {
        switch (parameter) {
            case "login":
                welcomePage.fillLogin(LOGIN);
                break;
            case "password":
                welcomePage.fillPassword(PASSWORD);
                break;
            case "board name":
                mainPage.fillBoardName(null);
                break;

        }
    }
/*
    public void fillName(String element) {
        switch (element) {
            case "board":
                boardPage.fillNewBoardName(null);
                break;
            case "list":
                boardPage.fillNewListName(null);
                break;
        }
    }
*/
    public void screenIsOpen(String screen) {
        switch (screen) {
            case "login":
                welcomePage.loginScreenIsOpen();
                break;
            case "board":
                mainPage.creatingBoardScreenIsOpen();
                break;
            case "settings":
                boardPage.settingsScreenIsOpen();
                break;
            case "rename board":
                boardPage.renameBoardScreenIsOpen();
                break;
        }
    }

    public void clickOnBackground(String activity) {
        switch (activity) {
            case "board":
                boardPage.backToActivity();
                break;
        }
    }
/*
    public void checkThatNameChanged(String field) {
        switch (field) {
            case "board":
                String newBoardName = boardPage.getBoardName();
                assert !newBoardName.equals(storage.getBoardName()); //todo
                break;
            case "list":
                String newListName = boardPage.getFirstListName();
                assert !newListName.equals(storage.getListName()); //todo
                break;
        }
    }
*/
    public void checkDefaultList() {
        boardPage.checkThatDefaultListExist();
    }

    public void login() {
        welcomePage.isLoad();
        welcomePage.login();
        welcomePage.loginScreenIsOpen();
        welcomePage.fillLogin(LOGIN);
        welcomePage.fillPassword(PASSWORD);
        welcomePage.authentication();
        mainPage.isLoad();
    }

    public void generateBoard() {
        login();
        mainPage.isLoad();
        mainPage.addBoard();
        mainPage.creatingBoardScreenIsOpen();
        mainPage.fillBoardName(null);
        mainPage.createBoard();
        boardPage.isLoad();
    }

    public void closeAndroid() {
        driver.getDriver().closeApp();
    }


}
