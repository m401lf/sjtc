package com.automationteststore.testCases.register;

import com.github.javafaker.Faker;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.util.Locale;

@Listeners(base.Listeners.class)

public class RegistrationTest extends BaseTest {
    TopMenuNavigationPage naviPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;
    Faker faker = new Faker(Locale.UK);
    String randomEmail = faker.internet().emailAddress();


    @Test(description = "Registration Test Using Faker Input")
    public void RegistrationTestUsingFakerInput() throws IOException, InterruptedException {
        naviPage = new TopMenuNavigationPage(driver);
        loginPage = naviPage.clickOnLoginOrRegisterLink();
        //AssertionHelper.updateTestStatus(loginPage.assertPageBreadCrumbMenuDisplayedContains("Login"));
        register = loginPage.navigateToRegisterPage();
        register.enterFirstName(faker.name().firstName());
        register.enterLastName(faker.name().lastName());
        register.enterEmail(randomEmail);
        register.enterTelephoneNumber(faker.phoneNumber().cellPhone());
        register.enterFaxNumber(faker.phoneNumber().cellPhone());
        register.enterCompanyName(faker.company().name());
        register.enterAddress1(faker.address().streetAddress());
        register.enterAddress2(faker.address().streetAddress());
        register.enterCity(faker.address().city());
        register.selectRegionOrState("Lancashire");
        register.enterPostalOrZipCode(faker.address().zipCode());
        AssertionHelper.updateTestStatus(register.getCountrySelectedByIPGeoLocationText().contains("United Kingdom"));
        register.inputUniqueLoginName();
        register.enterPassword(p.getProperty("password"));
        register.enterPasswordConfirm(p.getProperty("password"));
        register.tickOnSubscribeAsYes();
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
        successPage = register.clickContinueButtonInRegisterPage();
        //AssertionHelper.updateTestStatus(successPage.assertPageBreadCrumbMenuDisplayedContains("Success"));
        //AssertionHelper.updateTestStatus(successPage.assertPageHeaderIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.assertCongratulationsAccountSuccessfullyCreatedTextIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.getYourAccountHasBeenCreatedText().equalsIgnoreCase("Your Account Has Been Created!"));
        AssertionHelper.updateTestStatus(successPage.getCongratulationsAccountSuccessfullyCreatedText().contains("Congratulations! Your new account has been successfully created!"));
        AssertionHelper.updateTestStatus(successPage.getContinueButtonText().contains("Continue"));
        AssertionHelper.updateTestStatus(successPage.assertContinueButtonIsEnabledAndDisplayed());

    }


}
