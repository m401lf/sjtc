package com.automationteststore.stepDefinitions;

import com.automationteststore.base.BasePage;
import com.automationteststore.pages.*;
import helpers.assertion.AssertionHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import utilities.GlobalVars;

import java.io.IOException;

import static com.automationteststore.base.BaseTest.driver;


public class contactusSteps{
    ContactUsPage contactUsPage;
    LoginPage loginPage;
    LoginPage indexPage;
    MyAccountPage accountPage;
    BasePage page;
    TopMenuPage topMenuPage;
    FooterPage footerPage;
    ContactUsSuccessPage contactUsSuccessPage;


    @Given("I navigate to contactus basePage")
    public void iNavigateToContactusPage() throws IOException {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        topMenuPage.navigateToHomePage();
        page = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(page.getThisPageTitle().contains(GlobalVars.getHomePageTitle()));
        footerPage = PageFactory.initElements(driver, FooterPage.class);
        contactUsPage = footerPage.clickOnContactusLink();
    }

    @And("I can see contact details {string}, {string} and {string} are displayed")
    public void iCanSeeContactDetailsIsDisplayedAnd(String contactusTxt, String address, String phoneNumber) {
        this.contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        AssertionHelper.updateTestStatus(contactUsPage.getContactDetailsText().contains(contactusTxt));
        AssertionHelper.updateTestStatus(contactUsPage.getAddressText().contains(address));
        AssertionHelper.updateTestStatus(contactUsPage.getPhoneNumberTxt().contains(phoneNumber));
    }

    @And("clicks on the submit button")
    public void clicksOnTheSubmitButton() throws IOException {
        contactUsSuccessPage = this.contactUsPage.tapOnSubmitBtn();
    }

    @Then("I should get confirmation warning massage firstname {string}")
    public void iShouldGetConfirmationWarningMassageFirstname(String errorFirstnameMsg) {
        AssertionHelper.updateTestStatus(this.contactUsPage.getErrorFirstNameBoxMsg().contains(errorFirstnameMsg));
    }

    @Then("I should get confirmation warning massage email {string}")
    public void iShouldGetConfirmationWarningMassageEmail(String errorEmailMsg) {
        this.contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        AssertionHelper.updateTestStatus(this.contactUsPage.getErrorEmailBoxMsg().trim().contains(errorEmailMsg));
    }

    @Then("I should get confirmation warning massage inquiry {string}")
    public void iShouldGetConfirmationWarningMassageInquiry(String warningMassageInquiry) throws InterruptedException {
        AssertionHelper.updateTestStatus(this.contactUsPage.getErrorInquiryBoxMsg().contains(warningMassageInquiry));
    }

    @When("I inputted first name as {string} email Address as {string} and inquiry as {string}")
    public void iInputtedFirstNameAsEmailAddressAsAndInquiryAs(String firstname, String email, String inquiryMsg) {
        this.contactUsPage.inputFirstName(firstname);
        this.contactUsPage.inputEmail(email);
        this.contactUsPage.inputInquiry(inquiryMsg);
    }

    @Then("I can see {string} button and {string}")
    public void iCanSeeContinueButtonAnd(String continueBtn, String submitSuccessMsg) {
        this.contactUsSuccessPage = PageFactory.initElements(driver, ContactUsSuccessPage.class);
        AssertionHelper.updateTestStatus(this.contactUsSuccessPage.getContinueButtonText().equalsIgnoreCase(continueBtn));
        AssertionHelper.updateTestStatus(this.contactUsSuccessPage.getSuccessfullySentMessage().equalsIgnoreCase(submitSuccessMsg));
    }

    @And("I tap on the continue button")
    public void iTapOnTheContinueButton() throws IOException {
        indexPage = this.contactUsSuccessPage.clickOnContinueButton();
    }

}



