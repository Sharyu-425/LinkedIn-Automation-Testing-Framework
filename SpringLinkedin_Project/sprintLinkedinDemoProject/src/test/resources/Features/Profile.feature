Feature: LinkedIn Connection Management

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
  
 @SearchAndConnect
Scenario: Verify searching for professionals and sending connection requests
  Given user launches the browser
  When I login with user from Excel
  And user searches for a person from property file
  And user clicks on the People filter
  And user clicks on Connect for the selected profile
  And user clicks on Send without a note in confirmation box
  Then connection status should get changed to Pending
  And screenshot is captured
  And browser is closed

@ViewConnections
Scenario: Verify viewing current connections list
  Given user launches the browser
  When I login with user from Excel
  And user navigates to My Network section
  When user clicks on Connections tab
  And user scrolls through the connections list
  And screenshot is captured
  And browser is closed
 
@MutualConnections
Scenario Outline: Validate that mutual connections are displayed on profile view
 Given user launches the browser
  When I login with user from Excel
  And user navigates to My Network section
  When user clicks on Connections tab
  And user selects the profile "<profileUrl>" to check mutual
  Then click on mutual connections  link
  And list of mutual connections is appears
  And screenshot is captured
  And browser is closed

Examples:
  | profileUrl                                       |                          
  | https://www.linkedin.com/in/satyamkharote/       |
    
                   
    
    
    