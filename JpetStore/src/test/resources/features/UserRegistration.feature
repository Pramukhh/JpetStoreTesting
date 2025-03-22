Feature: User Registration and Authentication

Background:
  Given I navigate to the login page
#@Sc1
#Scenario: Create a new account
#  Given I navigate to the user registration page
#  When I enter valid registration details and submit
#  Then my account should be created successfully
@Sc2
Scenario: Login with valid credentials
  When I enter valid credentials "<username>" and "<password>"
  Then I should be logged in successfully
  
  Examples:
  |username|password|
  |kamal2002|kamses2002|
#@Sc3
#Scenario: Login with invalid credentials
#  When I enter invalid credentials "user" and "password"
#  Then I should see an error message "Invalid username or password"
#@Sc4
#Scenario: Login with empty fields
#  When I try to log in with empty username and password fields "" and ""
#  Then I should see error message "Please enter your username and password"
#@Sc5
#Scenario: Password recovery
#  Given I navigate to the password recovery page
# When I enter my registered email and submit the request
#  Then I should receive a password reset link in my email
