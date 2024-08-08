package com.automationteststore.stepDefinitions.user.general;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClickingOnElementsSteps {
    public static void selectElement(String elementName) throws Throwable {
        ClickingOnElementsSteps clickingOnElementsSteps = new ClickingOnElementsSteps();
        clickingOnElementsSteps.i_click_on_the(elementName);
    }

    @Given("^I click on Forgot your password$")
    public void i_click_on_forgotten_your_password() throws Throwable {

    }

    @Then("^I click on the send email button on the candidate page$")
    public void i_and_click_on_the_send_email_button_on_the_candidate_page() throws Throwable {

    }

    @When("^I click the \"([^\"]*)\" link on the candidate page$")
    public void i_click_the_link(String linkName) throws Throwable {

    }

    @When("^I click the \"([^\"]*)\" link on the \"([^\"]*)\" candidate page$")
    public void i_click_the_link(String linkName, String pageName) throws Throwable {
        i_click_the_link(linkName);
    }

    @Then("^I click on the \"([^\"]*)\"$")
    public void i_click_on_the(String elementName) throws Throwable {

    }

    // helper method

    @When("^I do not select \"([^\"]*)\"$")
    public void i_do_not_select(String elementName) throws Throwable {

    }

}
