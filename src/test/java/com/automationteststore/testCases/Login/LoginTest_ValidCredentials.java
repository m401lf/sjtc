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

public class LoginTest_ValidCredentials extends BaseTest {

    IndexPage ip;
    LoginPage lp;
    AccountPage ap;
    LogoutPage lgp;
    EditPage ep;

    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        ip = new IndexPage(driver);
        lp = ip.clickOnMyAccountAndLoginLink();
        Assert.assertTrue(lp.assertPageBreadCrumbMenuNameIsDisplayedAs("Login"));
        ap = lp.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        AssertionHelper.updateTestStatus(ap.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        ep = ap.tapOnEditAsideWidgetLink();
        ap = ep.clickContinue_Button();
        lgp = ap.tapLogoutLinkFromSideWidgetLinks();
        ip = lgp.clickAccountLogoutContinueBtn();
    }

}