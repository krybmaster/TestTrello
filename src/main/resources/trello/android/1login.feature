@Androidрегулярные выражения
Feature: Login to Trello

  Scenario: Login to Trello and check that login is successful

    #№1. Login in Trello
    Given user on 'welcome' activity
    Then he click on 'login' button
    And 'login' screen is open

    And he fill 'login'
    And he fill 'password'
    And he click on 'authenticate' button
    Then user on 'main' activity

    Given user on 'main' activity
    Then he click on 'add board' button
    And 'board' screen is open

    Then he fill 'board name'
    And he click on 'create board' button
    Then user on 'board' activity
