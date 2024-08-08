package com.automationteststore.stepDefinitions.Search;

import com.automationteststore.base.BasePage;
import com.automationteststore.pages.SearchResultPage;
import helpers.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automationteststore.base.BaseTest.driver;


public class SearchResultPageSteps {

    SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);


    @Then("^I can see search result for \"([^\"]*)\" filter")
    public void i_can_see_search_result_for_working_pattern_filter(String filterName) {

    }


    @Then("^I can see the jobs in search result")
    public void i_can_see_the_job_in_search_result() {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        //searchResultPage.assertJobTitle();
    }


    @Then("I can see {string} in search result for {string}")
    public void iCanSeeSearchResultFor(String noResult, String jobTitle) {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);


    }

    @And("I can see {string} in the search result page")
    public void iCanSeeSearchResultInSearchResultPage(String searchResult) {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);


    }

    @Then("I should see the search result for inputted data")
    public void i_can_should_search_results_for_inputted_data() {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    @When("I can see the search result for inputted data")
    public void i_can_see_the_search_result_for_inputted_data() {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        //searchResultPage.assertJobTitle();;
    }

    @Then("I should see result found in search result page")
    public void i_should_see_result_found_in_search_result_page() {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);

    }

    @And("I should see {string} in the search result page")
    public void iShouldSeeInTheSearchResultPage(String noResultFoundTxt) {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        //searchResultPage.assertForNoResultFound(noResultFoundTxt);
    }

    @Then("I can see {string} job found for All vacancies at all locations!")
    public void iShouldSeeJobFoundForAllVacanciesAtAllLocations(String jobCount) {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        //searchResultPage.assertForJobsCount(jobCount);

    }


    @And("I should see job advert status message:")
    public void iCanSeeJobAdvertStatusMessage(DataTable jobNowClosedMsg) {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        //searchResultPage.assertForJobNowClosed(jobNowClosedMsg);

    }

    @And("I can see {string} search result")
    public void iCanSeeSearchResult(String searchResult) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);

    }

    @When("I can see the followings displayed in the search result page:")
    public void i_can_see_the_followings_displayed_in_the_search_result_page(DataTable dataTable) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        AssertionHelper.updateTestStatus(searchResultPage.getSearchCriteriaText().trim().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(searchResultPage.getSearchProductDescriptionsRadioButtonLabel().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(searchResultPage.getSearchProductModelRadioButtonLabel().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(searchResultPage.getProductsMeetingSearchCriteriaText().contains(dataTable.cell(3, 0)));
        // AssertionHelper.updateTestStatus(searchResultPage.getNoSearchResultFoundText().contains(dataTable.cell(5,0)));
        //AssertionHelper.updateTestStatus(searchResultPage.getSearchResultFoundText().contains(dataTable.cell(6,0)));

    }

    @And("I can see page url, title and header as follows:")
    public void iCanSeePageUrlTitleAndHeaderAsFollows(DataTable dataTable) {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(page.getThisPageUrl().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(page.getThisPageTitle().contains(dataTable.cell(1, 1)));
        AssertionHelper.updateTestStatus(page.getPageHeaderText().contains(dataTable.cell(1, 2)));

    }

    @And("I can see {string} is selected by default")
    public void i_can_filter_the_products_in_search_result(String sortBy) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        AssertionHelper.updateTestStatus(searchResultPage.assertSortByDropdownItemIsSelected());
        AssertionHelper.updateTestStatus(searchResultPage.assertSortByDropdownDefaultItemIsSelected(sortBy));
        Assert.assertEquals(searchResultPage.getSortByDropdownDateOldNewText(), sortBy);

    }

    @Then("I should see the products in search result is greater {int}")
    public void i_can_see_the_products_in_search_result(int leastExpectedProductNumber) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        var status = searchResultPage.getSearchResultProductFoundCount() > leastExpectedProductNumber;
        AssertionHelper.updateTestStatus(status);

    }

    @And("I can see the search result for {string}")
    public void iCanSeeTheSearchResultFor(String categoryName) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        System.out.println(searchResultPage.getSearchResultProductFound());
        AssertionHelper.updateTestStatus(searchResultPage.getSearchResultProductFound().get(2).equalsIgnoreCase(categoryName));


    }

    @And("I select an item {string} from the all categories")
    public void i_select_an_item_from_the_all_categories() throws InterruptedException {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        searchResultPage.selectItemsFromAllCategories();

    }

    @And("I tap on the following search criteria buttons:")
    public void i_tap_on_the_following_search_criteria_buttons(DataTable dataTable) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        AssertionHelper.updateTestStatus(searchResultPage.getSearchProductDescriptionsRadioButtonLabel().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(searchResultPage.getSearchProductModelRadioButtonLabel().contains(dataTable.cell(1, 0)));
        searchResultPage.clickSearchProductDescriptionsRadioButton();
        searchResultPage.clickSearchProductModelRadioButton();

    }


    @And("I can see the followings displayed in the Sort By dropdown search result page:")
    public void iCanSeeTheFollowingsDisplayedInTheSortByDropdownSearchResultPage() {
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);

    }

    @And("I can see {string}")
    public void iCanSee(String searchResultFound) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        AssertionHelper.updateTestStatus(searchResultPage.getNoSearchResultFoundText().contains(searchResultFound));

    }


    @When("I select {string} to filter the search result")
    public void iSelect(String sortBy) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        searchResultPage.selectSortByDropdownItems(sortBy);

    }


    @And("tap on the {string} button")
    public void tapOnTheSearchButton(String Search) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        driver.findElement(By.cssSelector("[title='" + Search + "']"));
        searchResultPage.clickSearchButton();
    }

    @And("I can see inputted data retained in the search criteria {string}")
    public void iCanSeeInputtedDataRetainedInTheSearchCriteriaBoxes(String categoryName) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        AssertionHelper.updateTestStatus(searchResultPage.getSearchCriteriaAttributeValue().equalsIgnoreCase(categoryName));

    }

    @And("I can see {string} is selected by default in search criteria")
    public void i_can_see_is_selected_by_default_in_search_criteria(String categoryText) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        searchResultPage.selectSearchCriteriaAllCategoriesByText(categoryText);


    }

    @And("I can see the research result per-page {string} {string}")
    public void iCanSeeTheTotalNumberOfProductsInPagination(String perPage, String rangeCount) {
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        AssertionHelper.updateTestStatus(searchResultPage.getSearchResultProductFoundCountInPagination().trim().contains(perPage));
        AssertionHelper.updateTestStatus(searchResultPage.getSearchResultProductFoundCountInPagination().trim().contains(rangeCount));


    }


}
