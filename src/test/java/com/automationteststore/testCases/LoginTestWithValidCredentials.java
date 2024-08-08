package com.automationteststore.testCases;


import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.GlobalVars;

//@Listeners(base.Listeners.class)

public class LoginTestWithValidCredentials extends BaseTest {
    HomePage homePage;
    TopMenuPage topMenuPage;
    LoginPage loginPage;
    MyAccountPage accountPage;
    LogoutPage logoutPage;
    EditProfilePage editPage;


    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        loginPage = topMenuPage.clickOnLoginOrRegisterLink();
        accountPage = loginPage.loginApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        editPage = accountPage.clickOnEditAccountDetailsLink();
        accountPage = editPage.clickOnContinueEditBtn();
        logoutPage = accountPage.clickOnLogoffBtn();
        homePage = logoutPage.clickOnLogoutContinueButton();
    }

}