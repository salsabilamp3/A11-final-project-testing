Feature: Menu
  As a logged-in user
  I want to be able to interact with the sidebar menu
  So that I can navigate through the application and perform actions like logging out

  Background:
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  @menuTest
  Scenario: Displaying sidebar menu
    When The user clicks the sidebar button
    Then The sidebar menu should be displayed

  @menuTest
  Scenario: Closing sidebar menu
    Given The sidebar menu is displayed
    When The user clicks the 'X' button
    Then The sidebar menu should be closed

  @menuTest
  Scenario: Clicking the Logout button
    Given The sidebar menu is displayed
    When The user clicks the 'Logout' button
    Then The user should be logged out
    And The login page should be displayed

