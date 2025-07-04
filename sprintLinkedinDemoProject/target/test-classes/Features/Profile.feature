Feature: MessagingModule
  @tc01
  Scenario: Login to LinkedIn with valid credentials
    #Given I open the LinkedIn login page
    #When I login using username "User1" and password "Pass1"
    Then I should see my home pageA
    
    @tc02
    Scenario: Verify Messaging icon visibility
    When user checks for messaging icon
    Then Messaging icon should be visible
    
    @tc03
    Scenario: Click the messaging icon
    When user click on messaging icon
    Then messaging window should be open