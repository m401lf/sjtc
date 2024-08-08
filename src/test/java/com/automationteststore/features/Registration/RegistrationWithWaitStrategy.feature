@RegistrationWithWaitStrategy
Feature: Verification of Registration functionality

  Scenario: common steps in scenarios
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
    When I tap on "Login or register" to navigate to login page
    And I can see current page breadcrumb "Login"
    And I can see page breadcrumb as follows:
      | Home             |
      | Register Account |
      | Login            |
    And I can see "I AM A NEW CUSTOMER." and "RETURNING CUSTOMER"
    And I can see "Register Account" is checked by default
    And I tap "Continue" button in login page
    And I can see page title "Create Account" and page header "CREATE ACCOUNT"
    And I can see current page breadcrumb "Register"
    And I can see page breadcrumb as follows:
      | Home     |
      | Account  |
      | Register |
    And I should see "If you already have an account with us, please login at the login page."
    And I can see input sections as follows:
      | Your Personal Details |
      | Your Address          |
      | Login Details         |
      | Newsletter            |
    And I can see labels 16 first label "First Name:" and last "Subscribe:"
    And I input firstName "FirstName"
    And I input lastName "LastName"
    And I input unique emailAddress
    And I input telephone "074000000000"
    And I input fax "074000000001"
    And I input company "ABC Company Ltd"
    And I input Address 1 "1 Address Street"
    And I input Address 2 "Gorton South"
    And I input city "Manchester"
    And I select Region or State "Lancashire"
    And I input ZIP Code "M18 7QT"
    #And I select Country "United Kingdom"
    And I select Country name "United Kingdom"
    And I input unique Login name
    And I input Password "password@123"
    And I input Password Confirm "password@123"
    And I tick on subscription option "Yes"
    And I can see Subscribe "Yes" is checked
    And I tick on "Privacy Policy" radio button
    And I can see "Privacy Policy" is ticked
    And I tap on "Continue" button in register page
    And I can see current page breadcrumb "Success"
    And I can see page breadcrumb as follows:
      | Home    |
      | Account |
      | Success |
    Then I should see "YOUR ACCOUNT HAS BEEN CREATED!" in Account success page
    And I can see "Congratulations!" Your new account has been successfully created!
    And I logoff application