package com.automationteststore.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenLoginnamePage {


    private final static Logger log = LogManager.getLogger(FooterPage.class);

    LoginPage loginPage;
    @FindBy(css = "#forgottenFrm_email")
    private WebElement emailTxtField;
    @FindBy(css = "#forgottenFrm_lastname")
    private WebElement forgottenFrmLastName;

    @FindBy(css = ".maintext")
    private WebElement header;
    @FindBy(css = "h4.heading4")
    private WebElement hintHeading;
    @FindBy(css = "button[title='Continue']")
    private WebElement continueBtn;


    public boolean isHeaderDisplayed() {
        return header.isDisplayed();

    }

    public boolean isHintHeaderDisplayed() {
        return hintHeading.isDisplayed();

    }

    public void enterLastName(String lastname) {
        forgottenFrmLastName.clear();
        forgottenFrmLastName.sendKeys(lastname);

    }

    public String getContinueBtnTxt() {
        return continueBtn.getText();

    }

    public boolean isContinueBtnDisplayed() {
        return continueBtn.isDisplayed();

    }

    public void enterEmail(String email) {
        emailTxtField.sendKeys(email);

    }

    public LoginPage clickOnContinueButtonInForgottenLoginnamePage() {
        continueBtn.click();
        loginPage = new LoginPage();
        return loginPage;
    }

}
