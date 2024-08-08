package com.automationteststore.stepDefinitions.Search;

import com.automationteststore.pages.SearchResultPage;
import com.automationteststore.pages.TopMenuPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automationteststore.base.BaseTest.driver;


public class topMenuPageSteps {
    TopMenuPage topMenuPage;
    SearchResultPage searchResultPage;

    @And("I search for products with {string}")
    public void i_search_for_products_with(String productName) {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        topMenuPage.searchForProduct(productName);

    }

    @And("^I search for product with \"([^\"]*)\"$")
    public void i_search_for_product_as(String searchKeyword) {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        topMenuPage.searchForProduct(searchKeyword);
    }


    @And("I navigate to search result page")
    public void i_navigate_to_search_result_page() {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        searchResultPage = topMenuPage.navigateToSearchResultPage();
    }


    @And("I can see search widget is displayed")
    public void iCanSeeSearchWidgetIsDisplayed() {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        Assert.assertTrue(topMenuPage.assertSearchBoxIsDisplayed());

    }
}