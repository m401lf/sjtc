package com.automationteststore.stepDefinitions;


import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.*;
import helpers.alert.AlertHelper;
import helpers.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class loginSteps extends BaseTest {
    BasePage basePage;
    TopMenuPage topMenuPage;
    SuccessPage successPage;

    CheckoutCartPage checkoutCartPage;
    LoginPage loginPage;
    AsideWidgetPage asideWidgetPage;
    MyAccountPage accountPage;
    RegisterPage register;
    SuccessPage success;
    CheckoutSuccessPage checkoutSuccessPage;
    LogoutPage logoutPage;
    HomePage homePage;
    AlertHelper alertHelper;

    @DataTableType
    public LoginModel convertLoginModel(Map<String, String> entry) {
        return LoginModel.createLoginModel(entry);
    }

    @When("I should see in the login page as follows:")
    public void i_should_see_in_page_in_the_login_page(DataTable dataTable) {
        this.basePage = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(this.basePage.getThisPageUrl().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.basePage.getThisPageTitle().contains(dataTable.cell(1, 1)));
        AssertionHelper.updateTestStatus(this.basePage.getPageHeaderText().contains(dataTable.cell(1, 2)));
    }

    @When("I can see {string} and {string}")
    public void i_can_see_and(String newCustomerText, String returnCustomerText) {
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        AssertionHelper.updateTestStatus(this.loginPage.getNewCustomerTxt().contains(newCustomerText));
        AssertionHelper.updateTestStatus(this.loginPage.getReturningCustomerTxt().contains(returnCustomerText));

    }

    @When("I can see {string} is checked by default")
    public void i_can_see_is_checked_by_default(String accountRegisterText) {
        AssertionHelper.updateTestStatus(this.loginPage.getRegisterAccountRadioButtonTxt().contains(accountRegisterText));
        AssertionHelper.updateTestStatus(this.loginPage.assertRegisterAccountRadioButtonChecked());

    }

    @When("can see {string} and {string}")
    public void can_see_and(String forgetPasswordLink, String forgetYourLoginLink) {
        AssertionHelper.updateTestStatus(this.loginPage.getForgotYourPasswordLinkTxt().contains(forgetPasswordLink));
        AssertionHelper.updateTestStatus(this.loginPage.getForgotYourLoginLinkTxt().contains(forgetYourLoginLink));
    }

    @Given("I login application with loginname {string} and password {string}")
    public void i_login_application_with_loginname_and_password(String loginname, String password) throws IOException {
        this.loginPage.enterLoginName(loginname);
        this.loginPage.enterPassword(password);
        accountPage = this.loginPage.clickOnLoginButtonInAccountLoginPage();
    }

    @Given("I enter invalid loginname {string} and password {string}")
    public void i_enter_invalid_loginname_and_password(String loginname, String password) {
        this.loginPage.enterLoginName(loginname);
        this.loginPage.enterPassword(password);

    }

    @When("I click on login button in login page")
    public void i_click_on_login_button_in_login_page() {
        this.loginPage.clickLoginButtonInAccountLoginPage();
    }


    @When("I click on continue button")
    public void i_click_on_continue_button_in_login_page() {
        register = this.loginPage.clickOnContinueButtonInLoginPage();
    }

    @When("I tap {string} button in login page")
    public void i_tap_continue_button_in_login_page(String continueBtnText) {
        Assert.assertEquals(this.loginPage.getContinueButtonTxt(), continueBtnText);
        register = this.loginPage.clickOnContinueButtonInLoginPage();
    }

    @Then("should be presented with the following error validation message {string}")
    public void should_be_presented_with_the_following_error_validation_message_as(String loginErrorValidationMessage) {
        Assert.assertTrue(this.loginPage.getErrorAlertDangerLoginMessage().trim().contains(loginErrorValidationMessage));
    }

    @When("I login with the following credentials:")
    public void i_fill_in_the_following_login_credentials(DataTable dataTable) throws IOException {
        this.loginPage.enterLoginName(dataTable.cell(1, 0));
        this.loginPage.enterPassword(dataTable.cell(1, 1));
        accountPage = this.loginPage.clickOnLoginButtonInAccountLoginPage();
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_login_credentials(List<LoginModel> loginModelList) {
        this.loginPage.createLoginModel(loginModelList.stream().findFirst().get());
        accountPage = this.loginPage.clickOnLoginButtonInAccountLoginPage();
    }

    @When("I login with valid credentials:")
    public void i_login_with_credentials(DataTable dataTable) {
        accountPage = this.loginPage.clickOnLoginButtonInAccountLoginPage();
    }

    @When("I login in login page as a returning customer")
    public void i_login_in_login_page_as_a_returning_customer(DataTable dataTable) {
        this.loginPage.enterLoginName(dataTable.cell(1, 0));
        this.loginPage.enterPassword(dataTable.cell(1, 1));
    }

    @When("I login in login page")
    public void i_login_in_login_page(DataTable dataTable) {
        loginPage.enterLoginName(dataTable.cell(1, 0));
        loginPage.enterPassword(dataTable.cell(1, 1));

    }

    @When("I can see:")
    public void i_can_see(DataTable dataTable) {
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        AssertionHelper.updateTestStatus(this.loginPage.getNewCustomerTxt().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.loginPage.getReturningCustomerTxt().contains(dataTable.cell(1, 0)));

    }

    @And("I should see basePage url and title in the My account basePage:")
    public void iShouldSeeUrlAndTitleInMyAccountPage(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.basePage.getThisPageUrl().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.basePage.getThisPageTitle().contains(dataTable.cell(1, 1)));
        AssertionHelper.updateTestStatus(this.basePage.getPageHeaderText().contains(dataTable.cell(1, 2)));

    }

}
