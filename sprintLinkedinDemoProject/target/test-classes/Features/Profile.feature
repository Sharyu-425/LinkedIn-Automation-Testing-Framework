Feature: Login Feature

  Scenario: Login to LinkedIn with valid credentials
    Given I open the LinkedIn login page
    When I login using username "User1" and password "Pass1"
    Then I should see my home pageA