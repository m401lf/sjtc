package com.automationteststore.stepDefinitions;

import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.RegisterPage;
import helpers.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.RegistrationModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class registerSteps extends BaseTest {
    RegisterPage register;
    BasePage basePage;

    @DataTableType
    public RegistrationModel convertRegistrationModel(Map<String, String> entry) {
        return RegistrationModel.createAnAccountModel(entry);
    }

    @When("I should see {string}")
    public void i_should_see(String alreadyRegisteredText) {
        this.register = PageFactory.initElements(driver, RegisterPage.class);
        AssertionHelper.updateTestStatus(this.register.getIfYouAlreadyHaveAnAccountWithUs().contains(alreadyRegisteredText));

    }

    @When("I can see input sections as follows:")
    public void i_can_see_input_sections_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.register.getYourPersonalDetailsTxt().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.register.getYourAddressText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.register.getLoginDetailsSectionTxt().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(this.register.getNewsletterTxt().contains(dataTable.cell(3, 0)));

    }

    @When("I can see labels {int} first label {string} and last {string}")
    public void i_can_see_labels_first_label_and_last(Integer labelCount, String firstLabel, String lastLabel) {
        AssertionHelper.updateTestStatus(this.register.assertLabelCountAndSizeAndPositions(labelCount, firstLabel, lastLabel));
    }

    @When("I input firstName {string}")
    public void i_input_first_name(String firstName) {
        this.register.enterFirstName(firstName);

    }

    @When("I input lastName {string}")
    public void i_input_last_name(String lastName) {
        this.register.enterLastName(lastName);

    }

    @When("I input unique emailAddress")
    public void i_input_unique_email_address() {
        this.register.enterEmailAddress();

    }

    @When("I enter unique email address and login name")
    public void i_enter_unique_email_address_login_name() {
        this.register.enterEmailAddress();
        this.register.inputUniqueLoginName();
    }

    @When("I input telephone {string}")
    public void i_input_telephone(String telephone) {
        this.register.enterTelephoneNumber(telephone);

    }

    @When("I input fax {string}")
    public void i_input_fax(String fax) {
        this.register.enterFaxNumber(fax);

    }

    @When("I input company {string}")
    public void i_input_company(String coyName) {
        this.register.enterCompanyName(coyName);

    }

    @When("I input Address 1 {string}")
    public void i_input_address_one(String address1) {
        this.register.enterAddress1(address1);

    }

    @When("I input Address 2 {string}")
    public void i_input_address_two(String address2) {
        this.register = PageFactory.initElements(driver, RegisterPage.class);
        this.register.enterAddressTwo(address2);

    }

    @When("I input city {string}")
    public void i_input_city(String cityName) {
        //this.register.enterCity(cityName);
        basePage = PageFactory.initElements(driver, BasePage.class);
        this.register.enterCity(cityName);
    }

    @When("I select region or province {string}")
    public void i_select_region_or_province(String regionOrProvince) {
        this.register.selectRegionOrState(regionOrProvince);

    }

    @And("I select Region or State {string}")
    public void iSelectCountry(String regionOrStateName) {
        this.register.selectRegionOrStateByAnyMethod(regionOrStateName);
    }

    @When("I input ZIP Code {string}")
    public void i_input_zip_code_or_post_code(String zipCode) {
        this.register.enterPostalOrZipCode(zipCode);


    }

    @When("I select Country {string}")
    public void i_select_country_from_the_dropdown(String country) {
        this.register.selectCountry(country);


    }

    @When("I select Country name {string}")
    public void i_select_country_name(String country) {
        this.register.selectCountryName(country);

    }

    @When("I input unique Login name")
    public void i_input_unique_login_name() {
        this.register.inputUniqueLoginName();

    }

    @When("I input Password {string}")
    public void i_input_password(String password) {
        this.register.enterPassword(password);

    }

    @When("I input Password Confirm {string}")
    public void i_input_confirm_password(String comPassword) {
        this.register.enterConfirmPassword(comPassword);

    }

    @When("I tick on subscription option {string}")
    public void i_tick_on_subscription_option(String yesOptionText) {
        Assert.assertTrue(this.register.getSubscribeYesOptionText().contains(yesOptionText));
        this.register.tickOnSubscribeAsYes();
    }

    @When("I can see Subscribe Yes is checked")
    public void i_can_see_subscribe_is_checked() {
        AssertionHelper.updateTestStatus(this.register.assertSubscribeYesIsSelected());

    }

    @When("I can see Subscribe {string} is checked")
    public void i_can_see_subscribe_Yes_is_checked(String yesOptionText) {
        Assert.assertTrue(this.register.getSubscribeYesOptionText().contains(yesOptionText));
        AssertionHelper.updateTestStatus(this.register.assertSubscribeYesIsSelected());

    }

    @When("I tick on Privacy Policy radio button")
    public void i_tick_on_radio_button() {
        this.register.checkOnIAgreeToPrivacyPolicyRadioButton();

    }

    @When("I tick on {string} radio button")
    public void i_tick_on_privacy_policy_radio_button(String privacyPolicyText) {
        Assert.assertEquals(this.register.getPrivacyPolicyText(), privacyPolicyText);
        this.register.checkOnIAgreeToPrivacyPolicyRadioButton();
    }

    @When("I can see {string} is ticked")
    public void i_can_see_privacy_policy_is_ticked(String privacyPolicyText) {
        AssertionHelper.updateTestStatus(this.register.assertPrivacyPolicyIsSelected());
        Assert.assertEquals(this.register.getPrivacyPolicyText(), privacyPolicyText);

    }

    @When("I tap on {string} button in register page")
    public void i_tap_on_button_in_register_page(String continueButtonText) throws IOException {
        if (this.register.getContinueButtonTxt().contains(continueButtonText)) {
            this.register.clickContinueButtonInRegisterPage();
        }

    }

    @When("I enter the following details in input fields")
    public void i_input_following_details_in_input_fields(List<RegistrationModel> registrationModelList) {
        this.register.createRegistrationModel(registrationModelList.stream().findFirst().get());

    }

    @When("I enter the following details")
    public void i_input_following_details(DataTable dataTable) {
        for(Map<String, String> dataMap: dataTable.asMaps(String.class, String.class)){
            this.register.enterFirstName(dataMap.get("First Name"));
            this.register.enterLastName(dataMap.get("Last Name"));
            this.register.enterEmailAddress();
            this.register.enterTelephoneNumber(dataMap.get("Telephone Number"));
            this.register.enterFaxNumber(dataMap.get("Fax Number"));
            this.register.enterCompanyName(dataMap.get("Company Name"));
            this.register.enterAddress1(dataMap.get("Address 1"));
            this.register.enterAddress2(dataMap.get("Address 2"));
            this.register.enterCity(dataMap.get("City"));
            this.register.selectRegionOrState(dataMap.get("Region or State"));
            this.register.enterPostalOrZipCode(dataMap.get("ZIP Code or Postal Code"));
            this.register.inputUniqueLoginName();
            this.register.enterPassword(dataMap.get("Password"));
            this.register.enterConfirmPassword(dataMap.get("Confirm Password"));

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

    }

    @When("I input Your Personal sections with the following details:")
    public void i_input_your_personal_sections_with_the_following_details(DataTable dataTable) {
        this.register.enterFirstName(dataTable.cell(1, 0));
        this.register.enterLastName(dataTable.cell(1, 1));
        this.register.enterEmailAddress();
        this.register.enterTelephoneNumber(dataTable.cell(1, 2));
        this.register.enterFaxNumber(dataTable.cell(1, 3));

    }

    @When("I input Your Address section with the following details:")
    public void i_input_your_address_section_with_the_following_details(DataTable dataTable) {
        this.register.enterCompanyName(dataTable.cell(1, 0));
        this.register.enterAddress1(dataTable.cell(1, 1));
        this.register.enterAddress2(dataTable.cell(1, 2));
        this.register.enterCity(dataTable.cell(1, 3));
        this.register.selectRegionOrState(dataTable.cell(1, 4));
        this.register.enterPostalOrZipCode(dataTable.cell(1, 5));
        this.register.selectCountry(dataTable.cell(1, 6));

    }

    @When("I input Login Details section with the following details:")
    public void i_input_login_details_section_with_the_following_details(DataTable dataTable) {
        this.register.inputUniqueLoginName();
        this.register.enterPassword(dataTable.cell(1, 0));
        this.register.enterConfirmPassword(dataTable.cell(1, 1));
        this.register.tickOnSubscribeAsYes();

    }

    @Then("I should see red warning error messages:")
    public void i_should_see_red_warning_error_messages(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.register.getAgreeToPrivacyPolicyRedMessages().contains(dataTable.cell(0, 0)));

    }

    @When("I can see error messages summary is displayed")
    public void i_can_see_error_messages_summary_is_displayed() {
        AssertionHelper.updateTestStatus(this.register.assertAllAlertErrorDangerSummaryText());

    }

    @Then("I should see red error warning messages:")
    public void i_should_see_red_error_warning_messages(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.register.getLoginNameRedMessages().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.register.getFirstNameRedMessages().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.register.getLastNameRedMessages().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(this.register.getEmailRedMessages().contains(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(this.register.getAddress1RedMessages().contains(dataTable.cell(4, 0)));
        AssertionHelper.updateTestStatus(this.register.getCityRedMessages().contains(dataTable.cell(5, 0)));
        AssertionHelper.updateTestStatus(this.register.getZipCodeRedMessages().contains(dataTable.cell(6, 0)));
        AssertionHelper.updateTestStatus(this.register.getStateProvinceRedMessages().contains(dataTable.cell(7, 0)));
        AssertionHelper.updateTestStatus(this.register.getPasswordRedMessages().contains(dataTable.cell(8, 0)));
    }

    @When("enter Your Personal Details section with:")
    public void enter_your_personal_details_section_with(DataTable dataTable) {
        this.register.enterFirstName(dataTable.cell(1, 0));
        this.register.enterLastName(dataTable.cell(1, 1));
        this.register.enterTelephoneNumber(dataTable.cell(1, 2));
        this.register.enterFaxNumber(dataTable.cell(1, 3));
    }

    @When("enter Your Address Details section with:")
    public void enter_your_address_details_section_with(DataTable dataTable) {
        this.register.enterCompanyName(dataTable.cell(1, 0));
        this.register.enterAddress1(dataTable.cell(1, 1));
        this.register.enterAddress2(dataTable.cell(1, 2));
        this.register.enterCity(dataTable.cell(1, 3));
        this.register.selectRegionOrState(dataTable.cell(1, 4));
        this.register.enterPostalOrZipCode(dataTable.cell(1, 5));
        this.register.selectCountry(dataTable.cell(1, 6));

    }

    @When("enter Your Login Details section with:")
    public void enter_your_login_details_section_with(DataTable dataTable) {
        this.register.enterPassword(dataTable.cell(1, 0));
        this.register.enterConfirmPassword(dataTable.cell(1, 1));
    }


}
