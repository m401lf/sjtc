@RegistrationDataTableTransformer
Feature: Verification of Registration functionality

  Background: common steps among scenarios
    Given I landed on Ecommerce website
    And I should see in current page "<page-Title>" and "<page-url>"
    When I tap on "Login or register" to navigate to login page
    And I can see current page breadcrumb "Login"
    And I can see "I AM A NEW CUSTOMER." and "RETURNING CUSTOMER"
    And I can see "Register Account" is checked by default
    And I click on continue button
    And I can see page title "Create Account" and page header "CREATE ACCOUNT"
    And I can see current page breadcrumb "Register"
    And I should see "If you already have an account with us, please login at the login page."
    And I can see input sections as follows:
      | Your Personal Details |
      | Your Address          |
      | Login Details         |
      | Newsletter            |
    And I can see labels 16 first label "First Name:" and last "Subscribe:"

  Scenario Outline:: should be able to registration with valid credentials
    And I enter the following details in input fields
      | firstName | lastName | telephoneNumber | faxNumber     | companyName | address_One    | address_Two    | city_name  | region_or_state | zip_code | user_password | user_confirm_password |
      | Firstname | Lastname | 074000000000    | 0740000000011 | ABC Ltd     | Address Street | South Gorton 2 | Manchester | Lancashire      | M9 5TF   | Password@123  | Password@123          |
    And I enter unique email address and login name
    And I can see Subscribe Yes is checked
    And I tick on subscription option "Yes"
    And I can see Subscribe "Yes" is checked
    And I tick on "Privacy Policy" radio button
    And I can see "Privacy Policy" is ticked
    And I tap on "Continue" button in register page
    And I can see current page breadcrumb "Success"
    Then I should see "YOUR ACCOUNT HAS BEEN CREATED!" in Account success page
    And I can see "Congratulations!" Your new account has been successfully created!
    And I should see in current page "<page-Title>" and "<page-url>"
    Then I should see "<page-header>" and "<registerValidationMessage>" message
    And logoff application
    Examples:
      | page-Title                     | page-url        | page-header                    | registerValidationMessage |
      | Your Account Has Been Created! | account/success | YOUR ACCOUNT HAS BEEN CREATED! | Congratulations           |

