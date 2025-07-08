Feature: Validate LinkedIn Profile
 
Background:
           Given user is logged in
#@InvalidIntro      
#Scenario Outline: Validate edit intro icon and its fields with invalid data
#When user clicks on profile
#And user clicks on edit intro icon
#And user enters invalid "<firstName>" and "<lastName>" fields
#And user clicks on save button
#Then it should give error message
#
#Examples:
      #| firstName     | lastName  |
      #| 00            | 10        |
#
#@ValidIntro
#Scenario Outline: Validate edit intro icon and its fields with valid data
#When user clicks on profile
#And user clicks on edit intro icon
#And user enters valid "<firstname>" and "<lastname>" fields
#And user clicks on save button
#Then it should navigate us to profile page
#
#Examples:
      #| firstname     | lastname   |
      #| 20            | 30         |
@InvalidUserAbout     
#Scenario: Validate Add profile section and its fields with invalid data 
#When user clicks on profile
#And user clicks on add profile section button
#And user clicks on add about button
#And user enters invalid data in about field using datatable
#|about   |     5     |
#|skills  |     6     |
#And user clicks on save button
#Then it should display an error message

@ValidUserAbout
Scenario: Validate Add profile section and its fields with valid data
When user clicks on profile
And user clicks on add profile section button
And user clicks on add about button
And user enters valid data in about field using datatable
| about  | 4,0 |
| skills | 5,1 |
And user clicks on save button
Then it should navigate us to profile page

@Project
#Scenario: Validate Add projects field in Add profile section
#When user clicks on profile
#And user clicks on add profile section button
#And user clicks on recommended dropdown
#And user clicks on add projects button
#And user enters valid data in required fields using datatable
#|projectName    |     70     |
#|description    |     80     |
#|skills         |     60     |
#|title          |     90     |
#|linkDecription |     72     |
#|contributors   |     61     |
#And user clicks on save button
#And user clicks on skip
#And user scrolls down to projects section in profile
#Then a new project is added in users profile

@VolExp
#Scenario: Validate Add volunteer experience in Add profile section
#When user clicks on profile
#And user clicks on add profile section button
#And user clicks on additional dropdown
#And user clicks on add volunteer experience button
#And user enters valid data in fields using datatable
#And user clicks on save button
#Then a new volunteer experience is added in users profile

