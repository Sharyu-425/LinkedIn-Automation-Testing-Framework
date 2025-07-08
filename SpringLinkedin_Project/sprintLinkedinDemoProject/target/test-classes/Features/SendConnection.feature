Feature: Send Connection Request from 'People You May Know'

  @SendConnection @UsePQR
  Scenario: Verify sending connection request from 'People You May Know'
    Given user launches the browser
    When I login with user from Excel
    And user navigates to My Network section
    And user scrolls to 'People You May Know'
    And user clicks on Connect for the first suggested profile
    Then connection status should change to Pending
    And screenshot is captured
    And browser is closed