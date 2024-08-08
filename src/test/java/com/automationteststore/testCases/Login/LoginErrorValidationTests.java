package testCases.Login;


import com.github.javafaker.Faker;
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
import pages.IndexPage;
import pages.LoginPage;
import utilities.GlobalVars;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

@Listeners(base.Listeners.class)

public class LoginErrorValidationTests extends BaseTest {

    LoginPage loginPage;
    Faker faker;

    // @Test(invocationCount = 2)
    @Test(description = "Login Test With Invalid Credentials")
    public void LoginTestInvalidCredentials(Method method) throws IOException {
        faker = new Faker(Locale.UK);
        indexPage = new IndexPage(driver);
        loginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Login");
        Assert.assertTrue(loginPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Login"));
        loginPage.inputLoginApplication(faker.internet().emailAddress(), GlobalVars.getWrongPass());
        loginPage.clickOnLoginBtn();
        AssertionHelper.updateTestStatus(loginPage.assertWarningConfirmationMsg());
        AssertionHelper.updateTestStatus(loginPage.getErrorWarningConfirmationMsg().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg()));
    }
}
