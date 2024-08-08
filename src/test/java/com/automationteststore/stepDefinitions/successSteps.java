package com.automationteststore.stepDefinitions;


import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.MyAccountPage;
import com.automationteststore.pages.SuccessPage;
import com.automationteststore.pages.TopMenuPage;
import helpers.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class successSteps extends BaseTest {
    BasePage page;
    TopMenuPage topMenuPage;
    SuccessPage successPage;
    MyAccountPage accountPage;

    @Then("I should see {string} and {string} message")
    public void i_should_see_and_message(String pageHeader, String registerValidationMessage) {
        page = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(page.getPageHeaderText().contains(pageHeader));
        this.successPage = PageFactory.initElements(driver, SuccessPage.class);
        AssertionHelper.updateTestStatus(this.successPage.getCongratulationsAccountSuccessfullyCreatedText().contains(registerValidationMessage));

    }

    @Then("I should see {string} in Account success page")
    public void i_should_see_in_account_success_page(String accountCreatedSuccessfullyText) {
        this.successPage = PageFactory.initElements(driver, SuccessPage.class);
        AssertionHelper.updateTestStatus(this.successPage.getYourAccountHasBeenCreatedText().contains(accountCreatedSuccessfullyText));

    }

    @Then("I can see in Account success page as follows:")
    public void i_can_see_in_account_success_page_as_follows(DataTable dataTable) {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        AssertionHelper.updateTestStatus(topMenuPage.getWelcomeBackMessage().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.successPage.getYourAccountHasBeenCreatedText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.successPage.getCongratulationsAccountSuccessfullyCreatedText().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(this.successPage.getMyAccountText().contains(dataTable.cell(3, 0)));

    }

    @Then("I can see {string} Your new account has been successfully created!")
    public void i_can_see_your_new_account_has_been_successfully_created(String string) {
        AssertionHelper.updateTestStatus(this.successPage.getCongratulationsAccountSuccessfullyCreatedText().contains(string));

    }

    @And("I click on continue button in success basePage")
    public void iClickOnContinueButtonInSuccessPage() throws IOException {
        accountPage = this.successPage.clickContinueButtonInSuccessPage();

    }
}
