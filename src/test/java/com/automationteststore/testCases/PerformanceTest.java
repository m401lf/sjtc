package com.automationteststore.testCases;

import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.LoginPage;
import com.automationteststore.pages.RegisterPage;
import com.automationteststore.pages.SuccessPage;
import com.automationteststore.pages.TopMenuPage;
import com.github.javafaker.Faker;
import helpers.assertion.AssertionHelper;
import helpers.logger.LoggerHelper;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.utils.ExcelUtility;

import java.util.Locale;

//@Listeners(base.Listeners.class)

public class PerformanceTest extends BaseTest {
    TopMenuPage topMenuPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;
    final static Logger log = LoggerHelper.getLogger(BaseTest.class);
    Faker faker = new Faker(Locale.UK);
    String randomEmail = faker.internet().emailAddress();
    StopWatch watch = new StopWatch();

    @Test(description = "Registration Test Using Faker Input")
    public void RegistrationTestUsingFakerInput() throws Exception {
        watch.start();
        topMenuPage = PageFactory.initElements(driver,TopMenuPage.class);
        loginPage = topMenuPage.clickOnLoginOrRegisterLink();
        //AssertionHelper.updateTestStatus(loginPage.assertPageBreadCrumbMenuDisplayedContains("Login"));
        loginPage.clickOnContinueButtonInAccountLoginPage();
        register = PageFactory.initElements(driver,RegisterPage.class);
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
        register.enterConfirmPassword(p.getProperty("password"));
        register.tickOnSubscribeAsYes();
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
        successPage = register.clickContinueButtonInRegisterPage();

        double seconds = (double)watch.getTime() / 1000.0;
        watch.reset();
        log.info("**********************************************");
        log.info("Time taken to exeute this method was: " + seconds + " seconds");
        ExcelUtility.setCellData("Register Page", 1, 0);
        ExcelUtility.setCellData(seconds, 1, 1);
        //AssertionHelper.updateTestStatus(successPage.assertPageBreadCrumbMenuDisplayedContains("Success"));
        //AssertionHelper.updateTestStatus(successPage.assertPageHeaderIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.assertCongratulationsAccountSuccessfullyCreatedTextIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.getYourAccountHasBeenCreatedText().equalsIgnoreCase("Your Account Has Been Created!"));
        AssertionHelper.updateTestStatus(successPage.getCongratulationsAccountSuccessfullyCreatedText().contains("Congratulations! Your new account has been successfully created!"));
        AssertionHelper.updateTestStatus(successPage.getContinueButtonText().contains("Continue"));
        AssertionHelper.updateTestStatus(successPage.assertContinueButtonIsEnabledAndDisplayed());

    }


}
