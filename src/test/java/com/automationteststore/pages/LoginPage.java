package com.automationteststore.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import helpers.assertion.VerificationHelper;
import helpers.javaScript.JavaScriptHelper;
import model.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.time.Duration;

import static com.automationteststore.base.BaseTest.driver;


public class LoginPage {
    private final static Logger log = LogManager.getLogger(LoginPage.class);


    @FindBy(css = "label[for='accountFrm_accountregister']")
    private WebElement registerAccountCheckBox;

    private ForgottenPasswordPage forgottenPasswordPage;
    private ForgottenLoginnamePage forgottenLoginnamePage;
    @FindBy(xpath = "//input[@id='loginFrm_loginname']")
    private WebElement loginNameTxtField;
    @FindBy(xpath = "//input[@id='loginFrm_password']")
    private WebElement passwordTxtField;
    @FindBy(css = "button[title='Login']")
    private WebElement loginBtn;
    @FindBy(xpath = "//form[@id='loginFrm']//button[@title='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id='accountFrm']/fieldset/button")
    private WebElement continueBtn;
    @FindBy(css = ".alert.alert-success")
    private WebElement alertAlertSuccessMsg;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    private WebElement loginWithBlanksCredentialsTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]/text()")
    private WebElement loginWithBadPasswordTxt;
    @FindBy(css = "div.alert.alert-error.alert-danger")
    private WebElement errorIncorrectLoginOrPasswordProvidedTxt;
    @FindBy(xpath = "//div[@class='alert alert-error alert-danger']")
    private WebElement errorAlertDangerLoginMessage;
    @FindBy(css = ".form-group.mb40.mt20")
    private WebElement byCreatingAnAccountTxt;
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    private WebElement returningCustomerTxt;
    @FindBy(css = ".col-sm-6.newcustomer > .heading2")
    private WebElement newCustomerTxt;
    @FindBy(css = "fieldset > a:nth-of-type(1)")
    private WebElement forgotYourPasswordLink;
    @FindBy(linkText = "Forgot your login?")
    private WebElement forgotYourLoginLink;
    @FindBy(css = "[class='col-sm-6 newcustomer'] .heading4")
    private WebElement checkoutOptionTxt;

    @FindBy(xpath = "//*[@id='email_create']")
    private WebElement registrationEmailAddress;
    @FindBy(css = ".alert.alert-success")
    private WebElement successAlertForgetLoginNameConfirmationMessage;

    public boolean isAccountRegisterChecked() {
        return new VerificationHelper(driver).isSelected(registerAccountCheckBox);

    }

    public String getContinueButtonTxt() {
        new JavaScriptHelper(driver).scrollToElement(continueBtn);
        return new VerificationHelper(driver).getText(continueBtn);

    }

    private String getRegisterAccountCheckBox() {
        return new VerificationHelper(driver).getText(registerAccountCheckBox);

    }

    public void enterLoginName(String loginName) {
        loginNameTxtField.sendKeys(loginName);

    }

    public void enterPassword(String password) {
        passwordTxtField.sendKeys(password);

    }

    public MyAccountPage clickOnLoginButtonInAccountLoginPage() {
        loginButton.click();
        return new MyAccountPage();
    }

    public void clickLoginButtonInAccountLoginPage() {
        loginButton.click();

    }

    public CheckoutConfirmationPage clickLoginButton() {
        loginButton.click();
        return new CheckoutConfirmationPage();
    }

    public String getLoginBtnText() {
        return loginBtn.getText();

    }

    public MyAccountPage ClickLoginButton() throws IOException {
        loginBtn.click();
        return new MyAccountPage();
    }

    public MyAccountPage loginApplication(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickLoginButton();
        return new MyAccountPage();
    }

    public CheckoutConfirmationPage loginApplicationAsReturningCustomer(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickLoginButton();
        return new CheckoutConfirmationPage();
    }

    public void clickForgetYourLogin() {
        forgotYourLoginLink.click();

    }

    public ForgottenLoginnamePage clickForgetYourLoginLinkInLoginPage() {
        forgotYourLoginLink.click();
        return forgottenLoginnamePage;
    }

    public String getForgotYourPasswordLinkTxt() {
        return new VerificationHelper(driver).getText(forgotYourPasswordLink);

    }

    public String getForgotYourLoginLinkTxt() {
        return new VerificationHelper(driver).getText(forgotYourLoginLink);

    }

    public String getSuccessMsg() {
        return new VerificationHelper(driver).getText(alertAlertSuccessMsg);

    }

    public String getErrorIncorrectLoginPasswordProvidedConfirmationMessage() throws InterruptedException {
        return new VerificationHelper(driver).getText(errorAlertDangerLoginMessage);
    }

    public String getErrorAlertDangerLoginMessage() {
        return errorAlertDangerLoginMessage.getText();
    }

    public String getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt() {
        return new VerificationHelper(driver).getText(errorIncorrectLoginOrPasswordProvidedTxt);

    }

    public String getReturningCustomerTxt() {
        return new VerificationHelper(driver).getText(returningCustomerTxt);

    }

    public boolean isReturningCustomerNotDisplayed() {
        return new VerificationHelper(driver).isNotDisplayed(returningCustomerTxt);

    }

    public String getCheckoutOptionTxt() {
        return new VerificationHelper(driver).getText(checkoutOptionTxt);

    }

    public boolean isCheckoutOptionSelected() {
        return new VerificationHelper(driver).isSelected(checkoutOptionTxt);

    }

    public String getNewCustomerTxt() {
        return new VerificationHelper(driver).getText(newCustomerTxt);

    }

    public RegisterPage navigateToRegisterPage() {
        new JavaScriptHelper(driver).scrollToElementAndClick(continueBtn);
        return new RegisterPage();

    }

    public RegisterPage clickOnContinueButtonInLoginPage() {
        continueBtn.click();
        return new RegisterPage();

    }

    public boolean assertRegisterAccountRadioButtonChecked() {
        return new VerificationHelper(driver).isSelected(registerAccountCheckBox);

    }

    public String getRegisterAccountRadioButtonTxt() {
        return new VerificationHelper(driver).getText(registerAccountCheckBox);

    }

    public String getByCreatingAccountToShopFasterText() {
        return new VerificationHelper(driver).getText(byCreatingAnAccountTxt);

    }


    public RegisterPage clickOnContinueButtonInAccountLoginPage() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        new JavaScriptHelper(driver).scrollIntoViewAndClick(continueBtn);
        continueBtn.click();
        return new RegisterPage();
    }

    public boolean assertRegisterAccountIsSelectedByDefault() {
        return new VerificationHelper(driver).isSelected(registerAccountCheckBox);
    }

    public String getConfirmationMessage() {
        return new VerificationHelper(driver).getText(successAlertForgetLoginNameConfirmationMessage);
    }

    public ForgottenPasswordPage clickForgetYourPasswordLinkInLoginPage() {
        forgotYourPasswordLink.click();
        return new ForgottenPasswordPage();
    }

    public void createLoginModel(String loginName, String password) {
        loginNameTxtField.sendKeys(loginName);
        passwordTxtField.sendKeys(password);
    }

    public void createLoginModel(LoginModel loginModel) {
        loginNameTxtField.sendKeys(loginModel.getLoginname());
        passwordTxtField.sendKeys(loginModel.getPassword());

    }

}
