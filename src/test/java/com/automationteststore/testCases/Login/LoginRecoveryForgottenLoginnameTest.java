package com.automationteststore.testCases.Login;


import com.automationteststore.pages.ForgottenLoginnamePage;
import com.automationteststore.pages.LoginPage;
import com.automationteststore.pages.MyAccountPage;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;

public class LoginRecoveryForgottenLoginnameTest extends BaseTest {
    TopMenuNavigationPage naviPage;
    IndexPage indexPage;
    LoginPage loginPage;
    MyAccountPage accountPage;
    ForgottenLoginnamePage forgottenLoginnamePage;


    @Test
    public void loginForgottenPasswordTest() throws IOException {
        naviPage = new TopMenuNavigationPage(driver);
        indexPage = new IndexPage(driver);
        naviPage.navigateToIndexPage();
        boolean status_url = naviPage.getThisPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);

        boolean status_title = naviPage.getThisPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);
        loginPage = naviPage.clickOnLoginOrRegisterLink();

        boolean status_returningCustomer = loginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);

        boolean status_newCustomer = loginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);

        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getWrongPassword());
        accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();

        boolean status = loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg());
        AssertionHelper.updateTestStatus(status);

        boolean status_forgot_your_password = loginPage.getForgotYourPasswordLinkTxt().trim().contains(GlobalVars.getForgotYourPasswordTxt());
        AssertionHelper.updateTestStatus(status_forgot_your_password);

        boolean status_forgot_your_loginname = loginPage.getForgotYourLoginLinkTxt().contains(GlobalVars.getForgotYourLoginnameTxt());
        AssertionHelper.updateTestStatus(status_forgot_your_loginname);

        forgottenLoginnamePage = loginPage.clickForgetYourLoginLink();

        boolean result = forgottenLoginnamePage.isHintHeaderDisplayed();
        AssertionHelper.updateTestStatus(result);

        boolean result_hintText = forgottenLoginnamePage.isHintHeaderDisplayed();
        AssertionHelper.updateTestStatus(result_hintText);

        forgottenLoginnamePage.enterLastName(GlobalVars.getRecoveryLoginnameLastName());
        forgottenLoginnamePage.enterEmail(GlobalVars.getEmailPassword());
        loginPage = forgottenLoginnamePage.clicksOnContinueBtn();

        boolean result_success = loginPage.getSuccessMsg().contains(GlobalVars.getRecoveryLoginnameAlertSuccessMsg());
        AssertionHelper.updateTestStatus(result_success);



    }

}