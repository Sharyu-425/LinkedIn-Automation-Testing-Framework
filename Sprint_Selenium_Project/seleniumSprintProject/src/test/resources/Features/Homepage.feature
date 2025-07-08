@LinkedIn
Feature: LinkedIn Functional

  #Background:
  #Given User launches the browser
  #When User logs into LinkedIn with valid credentials
  #Then User is navigated to the Homepage
  #
  #@Search @TS_LinkedIn_01
  #Scenario: Verify profile seach using LinkedIn search bar
  #When User enters a valid keyword in the seach bar and presses Enter
  #And User clicks on the first profile result
  #And User follows the selected profile
  #Then User should see the profile as followed
  #
  #@Search @TS_LinkedIn_02
  #Scenario: verify system response when searching with an invalid keyword
  #When User performs profile search with an invalid keyword
  #And User selects the Jobs filter
  #Then System should display a No matching jobs found message
  #
  #
  #@HomePage @TS_LinkedIn_03
  #Scenario: Verify that user can successfully post content on LinkedIn
  #When User click on the post textbox on the homepage
  #And User enters valid content into the field and clicks on post button
  #Then the post should be successfully shared on the feed
  #
  #
  #@HomePage @TS_LinkedIn_04
  #Scenario: Verify system shows error when user tries to post duplicate content
  #When User attemps to post the same content again
  #Then Duplicate post warning should be displayed
  
  
  #@HomePage @TS_LinkedIn_05
  #Scenario: Verify that user can enable Dark Mode from settings
    #When User clicks on the profile dropdown in the header
    #And User navigates to Settings & Privacy
    #And User enables Dark Mode from display preferances
    #Then the system should apply Dark Mode theme to the UI
    
    @HomePage @TS_LinkedIn_05
    Scenario: Verify that user can toggle Dark Mode preferance
    When User navigates to Dark Mode in Settings & Privacy page 
    And User switches the mode to the opposite of the current selection
    Then New Dark Mode setting should be applied
