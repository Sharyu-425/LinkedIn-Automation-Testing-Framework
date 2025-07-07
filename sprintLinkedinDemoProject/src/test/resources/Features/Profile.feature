Feature: MessagingModule
  @tc01
  Scenario: Login to LinkedIn with valid credentials
    #Given I open the LinkedIn login page
    #When I login using username "User1" and password "Pass1"
    Then I should see my home pageA
    @tc02
    Scenario: Verify Messaging icon visibility and click messaging
    When user checks for messaging icon
    Then Messaging icon should be visible
    @tc03
    Scenario: Send Mesage to connection
    When user click on messaging icon
    Then messaging window should be open
    When user click on compose message button
    And enter "<connection>" in the search field
    And user type "<message>" into the message box
    And User click the Send button
    Then The message should appear in the chat thread
    Examples:
    |connection    | message      |
    |Raghav Sharma | Hello Raghav |
    @tc04
    Scenario: Select 'Archieved' from Focused dropdown in messaging
    When user is on the messaging window
    And user clicks on the Focused dropdown
    And user selects Archieved from the dropdown options
    Then Archieved messages should be displayed
    @tc05
    Scenario: Update visibility setting from three dots menu
    When user clicks on messaging icon
    And user clicks on the three dots menu
    And user selects Manage settings option
    #And user clicks on "visibility"
    #And user clicks on "Page visit visibility"
    #And user clicks on yhe "Off" toggle button
    