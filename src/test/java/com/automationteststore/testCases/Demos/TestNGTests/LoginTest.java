package com.automationteststore.testCases.Demos.TestNGTests;

import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.*;
import helpers.assertion.AssertionHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import utilities.GlobalVars;

import java.io.IOException;

public class LoginTest extends BaseTest {

    BasePage basePage;
    TopMenuPage topMenuPage;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage accountPage;
    LogoutPage logoutPage;

    EditProfilePage editPage;

    @Test
    public void loginTest() throws IOException, InterruptedException {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        loginPage = topMenuPage.clickOnLoginOrRegisterLink();
        basePage = PageFactory.initElements(driver, BasePage.class);
        boolean status_url = basePage.getThisPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);
        boolean status_title = basePage.getThisPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);


        boolean status_returningCustomer = loginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);

        boolean status_newCustomer = loginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);

        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getPassword());

        accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();
        boolean status_welcomeMsg = accountPage.userProfileInfoMessageTxt().contains("Welcome");
        AssertionHelper.updateTestStatus(status_welcomeMsg);

        editPage = accountPage.clickOnEditAccountDetailsLink();
        AssertionHelper.updateTestStatus(basePage.getThisPageUrl().contains("edit"));

        accountPage = editPage.clickOnContinueEditBtn();
        boolean status_updatedSuccessfully = accountPage.getAccountProfileSuccessfulUpdateMessage().contains(GlobalVars.getUpdatedSuccessfully());
        AssertionHelper.updateTestStatus(status_updatedSuccessfully);

        logoutPage = accountPage.clickOnLogoffBtn();
        boolean status_AccountLogoutHeader = logoutPage.getAccountLogoutText().contains(GlobalVars.getAccountLogoutHeaderTxt());
        AssertionHelper.updateTestStatus(status_AccountLogoutHeader);

        homePage = logoutPage.clickOnLogoutContinueButton();
    }
}