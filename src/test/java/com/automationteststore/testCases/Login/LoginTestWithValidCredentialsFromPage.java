package testCases.Login;


import helper.assertion.AssertionHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;
import utilities.GlobalVars;

@Listeners(base.Listeners.class)

public class LoginTestWithValidCredentialsFromPage extends BaseTest {

    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;
    LogoutPage logoutPage;
    EditPage editPage;

    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        indexPage = new IndexPage(driver);
        loginPage = indexPage.clickOnMyAccountAndLoginLink();
        Assert.assertTrue(loginPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Login"));
        accountPage = loginPage.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        editPage = accountPage.tapOnEditAsideWidgetLink();
        accountPage = editPage.clickContinue_Button();
        logoutPage = accountPage.tapLogoutLinkFromSideWidgetLinks();
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

}