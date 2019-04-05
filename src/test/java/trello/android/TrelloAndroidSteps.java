package trello.android;

import cucumber.api.java8.En;
import envorinment.EnvironmentFactory;
import envorinment.driver.AndroidDriver;
import envorinment.steps.AndroidSteps;

public class TrelloAndroidSteps implements En {

    private AndroidSteps steps;

    public TrelloAndroidSteps() {

        Before(() -> {
            steps = initAndroid();
        });

        Before(new String[]{"@Login"}, () -> {
            steps.login();
        });

        Before(new String[]{"@GenerateBoard"}, () -> {
            steps.generateBoard();
        });

        Given("^user on '(welcome|main|board)' activity$", (String activity) -> {
            steps.activityIsLoad(activity);
        });
        Then("^he click on '(login|authenticate|add board|create board|settings|ok|confirm)' button$", (String button) -> {
            steps.clickOnButton(button);
        });
        Then("^he click on '(board settings|board name|list name)'$", (String field) -> {
            steps.clickOnField(field);
        });
        And("^he fill '(login|password|board name|new board name)'$", (String parameter) -> {
            steps.fill(parameter);
        });
        And("^he fill new '(board|list)' name$", (String element) -> {
            //steps.fillName(element);
        });
        And("^'(login|board|settings|rename board)' screen is open$", (String screen) -> {
            steps.screenIsOpen(screen);
        });
        Then("^he click on background in '(board)' activity$", (String activity) -> {
            steps.clickOnBackground(activity);
        });
        And("^check that '(board|list)' name changed$", (String field) -> {
            //steps.checkThatNameChanged(field);
        });
        And("^he check that default list exist$", () -> {
            steps.checkDefaultList();
        });
        After(() -> {
            steps.closeAndroid();
        });
    }

    private AndroidSteps initAndroid() throws Exception {
        return new AndroidSteps(new AndroidDriver());
    }

}
