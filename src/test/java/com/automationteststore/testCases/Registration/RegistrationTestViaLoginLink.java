package testCases.Registration;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(base.Listeners.class)

public class RegistrationTestViaLoginLink extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    AccountPage accountPage;
    EditPage editPage;
    LogoutPage logoutPage;

    @Test(description = "Registration Test Via Login Link via DataProvider", dataProvider = "getData", groups = {"Register"})
    public void RegistrationViaLoginLink(HashMap<String, String> input) throws Exception {
        indexPage = new IndexPage(driver);
        Assert.assertEquals(indexPage.getCurrentPageTitle(), (input.get("pageTitle")));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        Assert.assertTrue(indexPage.verifyTopMenuItemIsDisplayed("My Account"));
        loginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Login");
        Assert.assertTrue(loginPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Login"));
        registerPage = loginPage.clickContinueButton();
        Assert.assertTrue(registerPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
        Assert.assertTrue(registerPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
        Assert.assertTrue(registerPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Register"));
        Assert.assertTrue(registerPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(registerPage.assertYourPersonalDetailsIsDisplayed());
        registerPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
        registerPage.inputPassword(input.get("password"));
        registerPage.inputConfirmPassword(input.get("password"));
        registerPage.tickOnYesSubscribeRadioButton();
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        successPage = registerPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Success"));
        Assert.assertTrue(successPage.assertPageHeaderIsDisplayed());
        accountPage = successPage.clickOnAccountSuccessContinueBtn();
        Assert.assertTrue(registerPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Account"));
        editPage = accountPage.tapOnEditAsideWidgetLink();
        Assert.assertTrue(registerPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Edit Information"));
        accountPage = editPage.clickContinue_Button();
        Assert.assertTrue(registerPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Account"));
        logoutPage = accountPage.tapOnSideWidgetLinkByName("Logout");
        Assert.assertTrue(registerPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Logout"));
        indexPage = logoutPage.tapOnAccountLogoutContinueBtn();
        Assert.assertTrue(indexPage.assertLogoDisplayed());

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(GlobalVars.getDataProviderJsonPath());
        return new Object[][]{{data.get(1)}};
        //return new Object[][]{{testData.data.get(0)}, {testData.data.get(1)}, {testData.data.get(2)}}; //for array multiple testData.data set in the json file
    }

}
