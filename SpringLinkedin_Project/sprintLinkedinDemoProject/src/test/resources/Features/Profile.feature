Feature: Send Connection Request from 'People You May Know'

  @SendConnection 
  Scenario: Verify sending connection request from 'People You May Know'
    Given user launches the browser
    When I login with user from Excel
    And user navigates to My Network section
    And user scrolls to 'People You May Know'
    And user clicks on Connect for the first suggested profile
    Then connection status should change to Pending
    And screenshot is captured
    And browser is closed
    
  @WithdrawRequest 
 Scenario: Verify withdrawing a pending connection request
    Given user launches the browser
    When I login with user from Excel
    And user navigates to My Network section
    And user opens the Sent Invitations list
    Then user captures screenshot of pending request
    When user clicks on Withdraw for the first pending request
    And user confirms the withdraw in the modal
    Then a success message should be displayed
    And screenshot is captured
    And browser is closed

  
  @AcceptIgnoreRequest 
  Scenario: Verify accepting and ignoring a connection request
  Given user launches the browser
  When I login with user from Excel
  And user navigates to My Network section
  And user opens the Received Invitations list
  Then user captures screenshot of received requests
  And user clicks on Accept for the first request 
  Then user scrolls down till last request
  And user clicks on Ignore for the last request 
  Then screenshot is captured
  And browser is closed
  

   