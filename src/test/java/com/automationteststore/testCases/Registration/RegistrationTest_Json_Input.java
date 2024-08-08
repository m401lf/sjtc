package com.automationteststore.testCases.register;


import helper.assertion.AssertionHelper;
import org.testng.annotations.DataProvider;
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
import java.util.HashMap;
import java.util.List;

@Listeners(base.Listeners.class)

public class RegistrationTest_Json_Input extends BaseTest {

    TopMenuNavigationPage naviPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;


    @Test(dataProvider = "getData", groups = {"Register"}, description = "RegistrationTest_Through_LoginOption")
    public void RegistrationTestAsideWidgetJsonInput(HashMap<String, String> input) throws IOException {
        naviPage = new TopMenuNavigationPage(driver);
        AssertionHelper.updateTestStatus(naviPage.assertLoginOrRegisterLinkIsDisplayed());
        AssertionHelper.updateTestStatus(naviPage.getLoginOrRegisterLink().contains(input.get("loginOrRegister")));
        loginPage = naviPage.clickOnLoginOrRegisterLink();
        //AssertionHelper.updateTestStatus(loginPage.assertPageBreadCrumbMenuDisplayedContains(input.get("loginPageBreadCrumb")));
        register = loginPage.clickOnContinueButtonInAccountLoginPage();
        register.enterFirstName(input.get("firstname"));
        register.enterLastName(input.get("lastname"));
        register.enterEmailAddress();
        register.enterTelephoneNumber(input.get("telephone"));
        register.enterFaxNumber(input.get("fax"));
        register.enterCompanyName(input.get("coyName"));
        register.enterAddress1(input.get("address1"));
        register.enterAddress2(input.get("address2"));
        register.enterCity(input.get("city"));
        register.selectRegionOrState(input.get("region/State"));
        register.enterPostalOrZipCode(input.get("postcode"));
        AssertionHelper.updateTestStatus(register.getCountrySelectedByIPGeoLocationText().contains(input.get("country")));
        register.inputUniqueLoginName();
        register.enterPassword(input.get("password"));
        register.enterPasswordConfirm(input.get("confirmPassword"));
        register.tickOnSubscribeAsYes();
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
        successPage = register.clickContinueButtonInRegisterPage();
        //AssertionHelper.updateTestStatus(successPage.assertPageBreadCrumbMenuDisplayedContains(input.get("successPageBreadCrumb")));
        //AssertionHelper.updateTestStatus(successPage.assertPageHeaderIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.getYourAccountHasBeenCreatedText().equalsIgnoreCase(input.get("yourAccountHasBeenCreatedMsg")));
        AssertionHelper.updateTestStatus(successPage.assertCongratulationsAccountSuccessfullyCreatedTextIsDisplayed());
        AssertionHelper.updateTestStatus(successPage.getCongratulationsAccountSuccessfullyCreatedText().contains(input.get("congratulationsYourAccountSuccessfullyCreatedMsg")));
        AssertionHelper.updateTestStatus(successPage.getContinueButtonText().contains(input.get("continueButtonText")));
        AssertionHelper.updateTestStatus(successPage.assertContinueButtonIsEnabledAndDisplayed());
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//testData//data//Register.json");
        //return new Object[][]{{data.get(0)}};
        return new Object[][]  {{data.get(0)}, {data.get(1)}, {data.get(2)}}; //for array multiple testData.data set in the json file
    }

}

