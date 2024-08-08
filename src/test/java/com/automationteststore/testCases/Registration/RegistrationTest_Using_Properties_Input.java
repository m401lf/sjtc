package com.automationteststore.testCases.register;


import helper.assertion.AssertionHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SuccessPage;
import pages.TopMenuNavigationPage;

import java.io.IOException;

@Listeners(base.Listeners.class)

public class RegistrationTest_Using_Properties_Input extends BaseTest {
    TopMenuNavigationPage naviPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;

    @Test(description = "RegistrationTest Using Properties Input")
    public void RegistrationTestUsingFakerInput() throws IOException {
        naviPage = new TopMenuNavigationPage(driver);
        loginPage = naviPage.clickOnLoginOrRegisterLink();
        AssertionHelper.updateTestStatus(loginPage.assertPageBreadCrumbMenuDisplayedContains(p.getProperty("loginBreadcrumbs")));
        register = loginPage.clickOnContinueButtonInAccountLoginPage();
        register.enterFirstName(p.getProperty("firstName"));
        register.enterLastName(p.getProperty("lastName"));
        register.enterEmailAddress();
        register.enterTelephoneNumber(p.getProperty("telephone"));
        register.enterFaxNumber(p.getProperty("fax"));
        register.enterCompanyName(p.getProperty("companyName"));
        register.enterAddress1(p.getProperty("address1"));
        register.enterAddress2(p.getProperty("address2"));
        register.enterCity(p.getProperty("city"));
        register.selectRegionOrState(p.getProperty("province"));
        register.enterPostalOrZipCode(p.getProperty("postalCode"));
        AssertionHelper.updateTestStatus(register.getCountrySelectedByIPGeoLocationText().contains(p.getProperty("country")));
        register.inputUniqueLoginName();
        register.enterPassword(p.getProperty("password"));
        register.enterPasswordConfirm(p.getProperty("password"));
        register.tickOnSubscribeAsYes();
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
        successPage = register.clickContinueButtonInRegisterPage();
        AssertionHelper.updateTestStatus(successPage.assertPageBreadCrumbMenuDisplayedContains(p.getProperty("successBreadcrumbs")));
        AssertionHelper.updateTestStatus(successPage.assertPageHeaderIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.assertCongratulationsAccountSuccessfullyCreatedTextIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.getYourAccountHasBeenCreatedText().equalsIgnoreCase(p.getProperty("accountCreatedHeading")));
        AssertionHelper.updateTestStatus(successPage.getCongratulationsAccountSuccessfullyCreatedText().contains(p.getProperty("congratulationsMessage")));
        AssertionHelper.updateTestStatus(successPage.getContinueButtonText().contains(p.getProperty("continueButton")));
        AssertionHelper.updateTestStatus(successPage.assertContinueButtonIsEnabledAndDisplayed());

    }


}
