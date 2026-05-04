Feature: Login Functionality

Scenario: Valid Login
  Given User is on login page
  When User enters valid credentials
  Then User should see homepage

Scenario: Invalid Login
  Given User is on login page
  When User enters invalid credentials
  Then Error message should be displayed
