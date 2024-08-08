package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automationteststore.base.BaseTest.driver;


public class LogoutPage {
    private final static Logger log = LogManager.getLogger(LogoutPage.class);
    HomePage homePage;
    @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    private WebElement saveToLogoutTxt;
    @FindBy(css = ".mb40 > a[title='Continue']")
    private WebElement logoutAccountContinueBtn;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/a")
    private WebElement logoutAccountContinueButton;
    @FindBy(css = ".heading1")
    private WebElement accountLogoutTxt;

    public String getLogoutAccountContinueButtonText() {
        return new VerificationHelper(driver).getText(logoutAccountContinueBtn);

    }

    public String getAccountLogoutText() {
        return new VerificationHelper(driver).getText(accountLogoutTxt);

    }

    public HomePage clickOnLogoutContinueButton() {
        logoutAccountContinueButton.click();
        log.info("Clicked logout continue button..");
        homePage = PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }

    public String getLogoutContinueButtonTxt() {
        return new VerificationHelper(driver).getText(logoutAccountContinueButton);

    }

    public boolean assertContinueButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(logoutAccountContinueButton);

    }

}
