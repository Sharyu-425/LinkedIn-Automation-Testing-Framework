Feature: MessagingModule

    @tc01
    Scenario: Verify Messaging icon visibility and click messaging
    When user checks for messaging icon
    Then Messaging icon should be visible
    @tc02
    Scenario Outline: Send Mesage to connection
    When user click on messaging icon
    Then messaging window should be open
    When user click on compose message button
    And enter "<connection>" in the search field
    And user type "<message>" into the message box
    And User click the Send button
    Then The message should appear in the chat thread
    Examples:
    |connection    | message      |
    |<connection>  | <message> |
    @tc03
    Scenario: Select 'Archieved' from Focused dropdown in messaging
    When user is on the messaging window
    And user clicks on the Focused dropdown
    And user selects Archieved from the dropdown options
    Then Archieved messages should be displayed
    @tc04
    Scenario: Update visibility setting from three dots menu
    When user clicks on messaging icon
    And user clicks on the three dots menu
    And user selects Manage settings option
   @tc05
   Scenario: Search messages by name in Linkedin messaging panel
   When user is on messaging window
   And user search for following names:
   |Data.xlsx|Sheet1|2|
   @tc_negative
   Scenario: Search with invalid special characters in messaging panel
   When user is on messaging window panel
   And user searches invalid names from excel:
   |Data.xlsx|Sheet1|2|
   @tc06
   Scenario: Expand Linkedin messaging panel from minimized state
   When user is on messaging the window
   And user clicks on the minimized messaging panel
   