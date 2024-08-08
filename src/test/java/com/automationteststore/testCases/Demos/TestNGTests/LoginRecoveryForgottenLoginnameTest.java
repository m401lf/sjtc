package com.automationteststore.testCases.Demos.TestNGTests;


import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.LoginPage;
import com.automationteststore.pages.MyAccountPage;
import com.automationteststore.pages.TopMenuPage;
import helpers.assertion.AssertionHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.io.IOException;

public class LoginRecoveryForgottenLoginnameTest extends BaseTest {
    BasePage basePage;
    TopMenuPage topMenuPage;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage accountPage;

    @Test
    public void loginForgottenPasswordTest() throws IOException {

        topMenuPage = new TopMenuPage();
        loginPage = topMenuPage.navigateToLoginPage();
        basePage = PageFactory.initElements(driver, BasePage.class);
        boolean status_url = basePage.getThisPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);

        boolean status_title = basePage.getThisPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);
        //loginPage = homePage.c();

        boolean status_returningCustomer = loginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);

        boolean status_newCustomer = loginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);

        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getWrongPassword());
        accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();

        boolean status = loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg());
        AssertionHelper.updateTestStatus(status);

//        boolean status_forgot_your_password = loginPage.getForgotYourPasswordLinkTxt().trim().contains(GlobalVars.getForgotYourPasswordTxt());
//        AssertionHelper.updateTestStatus(status_forgot_your_password);
//
//        boolean status_forgot_your_loginname = loginPage.getForgotYourLoginLinkTxt().contains(GlobalVars.getForgotYourLoginnameTxt());
//        AssertionHelper.updateTestStatus(status_forgot_your_loginname);
//
//        forgottenLoginnamePage = loginPage.clickForgetYourLoginLink();
//
//        boolean result = forgottenLoginnamePage.isHintHeaderDisplayed();
//        AssertionHelper.updateTestStatus(result);
//
//        boolean result_hintText = forgottenLoginnamePage.isHintHeaderDisplayed();
//        AssertionHelper.updateTestStatus(result_hintText);
//
//        forgottenLoginnamePage.enterLastName(GlobalVars.getRecoveryLoginnameLastName());
//        forgottenLoginnamePage.enterEmail(GlobalVars.getEmailPassword());
//        loginPage = forgottenLoginnamePage.clicksOnContinueBtn();
//
//        boolean result_success = loginPage.getSuccessMsg().contains(GlobalVars.getRecoveryLoginnameAlertSuccessMsg());
//        AssertionHelper.updateTestStatus(result_success);


    }

}