package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class ForgottenPasswordPage {
    final static Logger log = LogManager.getLogger(ForgottenPasswordPage.class);

    LoginPage loginPage;
    @FindBy(id = "forgottenFrm_email")
    private WebElement emailTxtField;
    @FindBy(id = "forgottenFrm_loginname")
    private WebElement forgottenFrmLoginname;
    @FindBy(css = "a[title='Back']")
    private WebElement backButton;
    @FindBy(css = ".maintext")
    private WebElement heading;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/form/h4")
    private WebElement hintHeading;
    @FindBy(css = "button[title='Continue'] > .fa.fa-check")
    private WebElement continueButton;

    @FindBy(how = How.ID, using = "error_passwordConfirm")
    private WebElement err_confirmPassword;

    @FindBy(how = How.ID, using = "error_password")
    private WebElement err_Password;

    public String getHintHeadingText() {
        return hintHeading.getText();

    }

    public boolean isHeadingDisplayed() {
        return heading.isDisplayed();

    }

    public boolean isHintHeadingDisplayed() {
        return hintHeading.isDisplayed();

    }

    public String getContinueButtonTxt() {
        return continueButton.getText();

    }

    public LoginPage clickOnBackButton() {
        backButton.click();
        loginPage = new LoginPage();
        return loginPage;
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();

    }

    public void enterEmail(String email) {
        emailTxtField.sendKeys(email);

    }

    public void enterLoginname(String loginname) {
        forgottenFrmLoginname.sendKeys(loginname);

    }

    public LoginPage clickOnContinueButtonInForgottenPasswordPage() {
        continueButton.click();
        loginPage = new LoginPage();
        return loginPage;
    }

    public void assertErrorIdIsDisplayed(String fieldName) {
        WebElement element = null;
        List<String> fieldNamesList = BasePage.getArrayListOfStringWithCommaSeparated(fieldName);
        for (int i = 0; i < fieldNamesList.size(); i++) {
            switch (fieldNamesList.get(i).toLowerCase()) {
                case "confirm password":
                    element = err_confirmPassword;
                    break;
                case "new password":
                    element = err_Password;
                    break;
            }

            if (element != null) {
                Assert.assertTrue(element.isDisplayed());
            }
            //assertHeadingErrorIdIsDisplayed();

        }
    }
}
