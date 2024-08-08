package com.automationteststore.testCases.register;


import com.github.javafaker.Faker;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SuccessPage;
import pages.TopMenuNavigationPage;

import java.io.IOException;
import java.util.Locale;

@Listeners(base.Listeners.class)

public class RegistrationTest_Using_Faker_Input extends BaseTest {
    TopMenuNavigationPage naviPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;
    Faker faker = new Faker(Locale.UK);

    @Test(description = "Registration Test Using Faker Input")
    public void RegistrationTestUsingFakerInput() throws IOException {
        naviPage = new TopMenuNavigationPage(driver);
        loginPage = naviPage.clickOnLoginOrRegisterLink();
        AssertionHelper.updateTestStatus(loginPage.assertPageBreadCrumbMenuDisplayedContains("Login"));
        register = loginPage.clickOnContinueButtonInAccountLoginPage();
        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmailAddress();
        register.enterTelephoneNumber(faker.phoneNumber().cellPhone());
        register.enterFaxNumber(faker.phoneNumber().cellPhone());
        register.enterCompanyName(faker.company().name());
        register.enterAddress1(faker.address().streetAddress());
        register.enterAddress2(faker.address().streetAddress());
        register.enterCity(faker.address().city());
        register.selectRegionOrState("Lancashire");
        register.enterPostalOrZipCode(faker.address().zipCode());
        register.enterEmail(faker.internet().emailAddress());
        register.inputLoginName(faker.internet().uuid());
        register.enterPassword("Password");
        register.enterPasswordConfirm("Password");
        register.tickOnSubscribeAsYes();
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
        successPage = register.clickContinueButtonInRegisterPage();
        AssertionHelper.updateTestStatus(successPage.assertPageBreadCrumbMenuDisplayedContains("Success"));
        AssertionHelper.updateTestStatus(successPage.getCongratulationsAccountSuccessfullyCreatedText().contains("Congratulations! Your new account has been successfully created!"));

    }


}
