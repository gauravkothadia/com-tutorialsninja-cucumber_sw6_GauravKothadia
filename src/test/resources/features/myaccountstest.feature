Feature: My Account Test

  As a user
  I want to check login/logout/register functionality

  Background:
  Given I am on Home page

  @sanity @smoke @regression
  Scenario: User should navigate to register page successfully
    When I click on "My Account" link
    And I call the method selectMyAccountOptions method and pass the parameter "Register"
    Then I should see text "Register Account"

  @smoke @regression
  Scenario: User should navigate to login page successfully
    When I click on "My Account" link
    And I call the method selectMyAccountOptions method and pass the parameter "Login"
    Then I should see text "Returning Customer"

  @regression
  Scenario: User should register account successfully
    When I click on "My Account" link
    And I call the method selectMyAccountOptions method and pass the parameter "Register"
    And I enter First Name "Yogesh"
    And I enter Last Name "Patel"
    And I enter Email "yogeshP1@abc.com"
    And I enter Telephone "07721500015"
    And I enter Password "yogiraj1234"
    And I enter Confirm Password "yogiraj1234"
    And I click on Privacy Policy check box
    And I click on Continue button for registration
    Then I should be see the message "Your Account Has Been Created!"
    And I click on Continue button after registration
    And I click on "My Account" link
    And I call the method selectMyAccountOptions method and pass the parameter "Logout"
    Then I should see the text after logout as "Account Logout"
    And I click on Continue button after logout

  @regression
  Scenario: User should login and logout successfully
    When I click on "My Account" link
    And I call the method selectMyAccountOptions method and pass the parameter "Login"
    And I enter Email "yogeshP1@abc.com", password "yogiraj1234" on login page and click on login button
    And I click on "My Account" link
    And I call the method selectMyAccountOptions method and pass the parameter "Logout"
    Then I should see the text after logout as "Account Logout"
    And I click on Continue button after logout
