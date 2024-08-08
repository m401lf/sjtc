package testCases.Login;


import helper.assertion.AssertionHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.AccountPage;
import pages.IndexPage;
import pages.LoginPage;
import testData.data.LoginDetailsTestData;
import utilities.GlobalVars;

@Listeners(base.Listeners.class)

public class TC_LF_001_1 extends BaseTest {

    IndexPage ip;
    LoginPage lp;
    AccountPage ap;


    @Test(description = "(TS_002): Login Functionality - Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        ip = new IndexPage(driver);
        lp = ip.clickOnMyAccountAndLoginLink();
        ap = lp.loginInApplication(LoginDetailsTestData.EMAIL, LoginDetailsTestData.PASSWORD);
        AssertionHelper.updateTestStatus(ap.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
    }

}