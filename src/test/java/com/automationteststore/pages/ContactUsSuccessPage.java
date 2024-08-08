package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.automationteststore.base.BaseTest.driver;


public class ContactUsSuccessPage {


    private final Logger log = LogManager.getLogger(ContactUsSuccessPage.class);

    HomePage homePage;
    @FindBy(css = ".mb40 > p:nth-of-type(2)")
    private WebElement successfullySentMsg;
    @FindBy(css = ".mb40 > a[title='Continue']")
    private WebElement continueBtn;

    public String getContinueButtonText() {
        return new VerificationHelper(driver).getText(continueBtn);

    }

    public String getSuccessfullySentMessage() {
        return new VerificationHelper(driver).getText(successfullySentMsg);
    }

    public LoginPage clickOnContinueButton() {
        continueBtn.click();
        return new LoginPage();
    }

}



