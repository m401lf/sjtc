@RecoveryForgottenPassword
@Forgotten
Feature: Login Page - Recovery password Login Functionality

  Background: common steps in scenarios
    Given I landed on Ecommerce website
    And I can see page properties as follows:
      | page url                         | page title                                  |
      | https://automationteststore.com/ | A place to practice your automation skills! |
    And I can see top menu page properties as follows:
      | Login or register |
      | SPECIALS          |
      | ACCOUNT           |
      | CART              |
      | CHECKOUT          |
    And I verify if links are present:
      | SPECIALS |
      | ACCOUNT  |
      | CART     |
      | CHECKOUT |
    When I tap on "Login or register" to navigate to login page
    And I can see page properties as follows:
      | page url                                                   | page title    |
      | https://automationteststore.com/index.php?rt=account/login | Account Login |
    And I can see current page breadcrumb "Login"
    And I can see page breadcrumb as follows:
      | Home             |
      | Register Account |
      | Login            |
    And I can see:
      | I AM A NEW CUSTOMER. |
      | RETURNING CUSTOMER   |
    And I can see "Register Account" is checked by default
    And I can see "Forgot your password" and "Forgot your login" links
    And I enter invalid loginname "loginName00" and password "password00"
    And I click on login button in login page
    And click on Forgot your password link

  Scenario Outline: should be able to use Forgot your password with valid credentials
    And I enter login name "benazeta70" and email address "benazeta70@gmail.com"
    When I tap on Continue button in recovery forgotten Password Page
    Then I should a see confirmation message "<status>"

    Examples:
      | status                                                             |
      | Success: Password reset link has been sent to your e-mail address. |
