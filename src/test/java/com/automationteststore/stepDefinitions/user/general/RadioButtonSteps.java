package com.automationteststore.stepDefinitions.user.general;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class RadioButtonSteps {


    @When("^I select the \"([^\"]*)\" radio button on the \"([^\"]*)\" candidate page$")
    @And("^I select \"([^\"]*)\" as immigration status on \"([^\"]*)\" candidate page$")
    @Then("^I select \"([^\"]*)\" on the \"([^\"]*)\" candidate page$")
    public void i_select_the_radio_button_on_the_specific_candidate_page(String radioButton, String pageName)
            throws Throwable {
        //i_select_the_radio_button_on_the_candidate_page(radioButton, pageName);
    }

    @Then("^there should be radio buttons below the heading for the following:$")
    public void there_should_be_radio_buttons_for_the_following(List<String> radioButtons) throws Throwable {
//        QuestionPage page = (QuestionPage) CandidatePageCollection.getCurrentPage();
//        for (int i = 0; i < radioButtons.size(); i++) {
//            page.assertElementIsDisplayed(radioButtons.get(i), true);
//        }
//
//        page.assertRadioButtonsBelowHeading();
    }

}
