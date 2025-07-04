Feature: Validate LinkedIn Profile
 
Background:
           Given user is logged in
      
#Scenario: Validate edit intro icon and its fields with invalid data
#When user clicks on profile
#And user clicks on edit intro icon
#And user enters invalid fields
#And user clicks on save button
#Then it should give error message

#Scenario: Validate edit intro icon and its fields with valid data
#When user clicks on profile
#And user clicks on edit intro icon
#And user enters valid fields
#And user clicks on save button
#Then it should navigate us to profile page

Scenario: Validate Add profile section and its fields with valid data
When user clicks on profile
And user clicks on add profile section button
And user clicks on add about button
And user enters valid data in about field
And user clicks on save button
Then it should navigate us to profile page
 
