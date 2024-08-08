package com.automationteststore.pages;


import com.automationteststore.base.BasePage;
import helpers.assertion.VerificationHelper;
import helpers.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automationteststore.base.BaseTest.driver;


public class SuccessPage {


    private final Logger log = LogManager.getLogger(SuccessPage.class);

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    private WebElement myAccountText;
    @FindBy(css = ".btn.btn-default.mr10")
    private WebElement continueAccountSuccessBtn;
    @FindBy(css = ".maintext")
    private WebElement yourAccountHasBeenCreatedHeadingTxt;
    @FindBy(css = ".mb40")
    private WebElement congratulationsMsg;
    @FindBy(css = "//*[@id='maincontainer']/div/div[1]/div/div/section/p[2]")
    private WebElement accountSuccessfullyCreatedMsg;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;

    @FindBy(xpath = "//*[@id='content']/div/a")
    private WebElement continueBtn;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;


    public String getMyAccountText() {
        return myAccountText.getText();

    }

    public String getAccountHasBeenCreatedHeadingText() {
        return yourAccountHasBeenCreatedHeadingTxt.getText();

    }

    public MyAccountPage clickOnContinueAccountSuccessButton() {
        continueAccountSuccessBtn.click();
        return new MyAccountPage();

    }


    public String getContinueButtonText() {
        return continueAccountSuccessBtn.getText();

    }

    public String getYourAccountHasBeenCreatedText() {
        return yourAccountHasBeenCreatedHeadingTxt.getText();

    }

    public String getYourAccountHasBeenCreatedHeadingText() {
        return yourAccountHasBeenCreatedHeadingTxt.getText();

    }

    public boolean assertYourAccountHasBeenCreatedHeadingTextDisplayed() {
        return accountSuccessfullyCreatedMsg.isDisplayed();

    }

    public boolean assertCongratulationsAccountSuccessfullyCreatedTextIsDisplayed() {
        return congratulationsMsg.isDisplayed();

    }

    public String getCongratulationsAccountSuccessfullyCreatedText() {
        return congratulationsMsg.getText();

    }

    public String getAccountSuccessPageHeading() {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        return basePage.getPageHeaderText();

    }

    public boolean assertContinueButtonIsEnabledAndDisplayed() {
        return new VerificationHelper(driver).isDisplayedAndEnabled(continueButton);
    }

    public ShoppingCartPage clickContinueButton() {
        new JavaScriptHelper(driver).scrollToElementAndClick(continueButton);
        return new ShoppingCartPage();
    }

    public MyAccountPage clickContinueButtonInSuccessPage() {
        continueAccountSuccessBtn.click();
        return new MyAccountPage();
    }

    public WebElement getMsgConfirmation() {
        return msgConfirmation;

    }

    public WebElement getContinueBtn() {
        return continueBtn;

    }


}
