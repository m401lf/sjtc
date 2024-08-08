package com.automationteststore.stepDefinitions;


import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.*;
import com.google.common.util.concurrent.Uninterruptibles;
import helpers.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jxl.read.biff.BiffException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;

public class commonSteps extends BaseTest {
    BasePage basePage;
    TopMenuPage topMenuPage;
    HomePage homePage;
    ProductIDPage productIdPage;
    LoginPage loginPage;
    AsideWidgetPage asideWidgetPage;
    SuccessPage successPage;
    LogoutPage logoutPage;
    MyAccountPage accountPage;
    ShoppingCartPage shoppingCartPage;

    @Given("I landed on Ecommerce website")
    public void i_landed_on_ecommerce_website() throws Exception {
        this.topMenuPage = launchApplication();

    }

    @When("I can see page title {string} and page header {string}")
    public void i_can_see_page_title_and_page_header(String pageTitle, String pageHeader) {
        this.basePage = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(this.basePage.getThisPageTitle().contains(pageTitle));
        AssertionHelper.updateTestStatus(this.basePage.getPageHeaderText().contains(pageHeader));
    }

    @When("I tap on {string} to navigate to login page")
    public void i_tap_on_to_navigate_to_login_page(String loginOrRegisterLink) {
        AssertionHelper.updateTestStatus(this.topMenuPage.getLoginOrRegisterLink().contains(loginOrRegisterLink));
        loginPage = this.topMenuPage.clickOnLoginOrRegisterLink();
    }

    @Given("I verify if links are present:")
    public void i_verify_if_links_are_present(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.topMenuPage.assertTopMenuItemsListArePresent(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.assertTopMenuItemsListArePresent(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.assertTopMenuItemsListArePresent(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.assertTopMenuItemsListArePresent(dataTable.cell(3, 0)));
    }

    @Given("I can see top menu page properties as follows:")
    public void i_can_see_top_menu_page_properties_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.topMenuPage.getLoginOrRegisterLink().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.getTopMenuItemsList(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.getTopMenuItemsList(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.getTopMenuItemsList(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(this.topMenuPage.getTopMenuItemsList(dataTable.cell(4, 0)));
    }

    @Given("I can see page properties as follows:")
    public void i_can_see_page_properties_as_follows(DataTable dataTable) {
        this.basePage = PageFactory.initElements(driver, BasePage.class);
        boolean status = this.basePage.getThisPageUrl().contains(dataTable.cell(1, 0));
        AssertionHelper.updateTestStatus(status);
        boolean result = this.basePage.getThisPageTitle().contains(dataTable.cell(1, 1));
        AssertionHelper.updateTestStatus(result);
    }

    @Then("I should see {string} and {string}")
    @Then("I should see in current page {string} and {string}")
    public void i_should_see_and(String pageTitle, String pageUrl) {
        //this.basePage = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(this.basePage.getThisPageTitle().contains(pageTitle));
        AssertionHelper.updateTestStatus(this.basePage.getThisPageUrl().contains(pageUrl));
    }
    @And("I logout application")
    public void and_I_logout_application() {
        accountPage = PageFactory.initElements(driver, MyAccountPage.class);
        logoutPage = accountPage.clickOnLogoffBtn();
        homePage = logoutPage.clickOnLogoutContinueButton();
    }
    @When("I can see page breadcrumb as follows:")
    public void i_can_see_page_breadcrumb_as_follows(DataTable dataTable) throws InterruptedException {
        AssertionHelper.updateTestStatus(this.basePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(this.basePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.basePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(dataTable.cell(2, 0)));

    }
    @When("I can see current page breadcrumb {string}")
    public void i_can_see_current_page_breadcrumb(String pageBreadcrumb) throws InterruptedException {
        //this.basePage = PageFactory.initElements(driver, BasePage.class);
        Assert.assertTrue(this.basePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(pageBreadcrumb));

    }
    @And("I logoff application")
    @And("logoff application")
    public void i_logoff_application() {
        successPage = PageFactory.initElements(driver, SuccessPage.class);
        accountPage = successPage.clickContinueButtonInSuccessPage();
        accountPage = PageFactory.initElements(driver, MyAccountPage.class);
        logoutPage = accountPage.clickOnLogoffBtn();
        logoutPage = PageFactory.initElements(driver, LogoutPage.class);
        homePage = logoutPage.clickOnLogoutContinueButton();
        driver.quit();
    }

    @Then("I quit browser")
    public void i_Quit_Browser() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(GlobalVars.THREE));
        driver.quit();
    }

    @When("page header is displayed as {string}")
    public void page_header_display_as(String headerText) {
        Assert.assertEquals(this.basePage.getPageHeaderText(), headerText);

    }

    @And("I should see in the page as follows:")
    public void i_should_see_in_the_page_as_follow(DataTable dataTable) {
        AssertionHelper.updateTestStatus(this.basePage.getThisPageUrl().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(this.basePage.getThisPageTitle().contains(dataTable.cell(1, 1)));

    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Then("should be presented with the following validation message as {string}")
    public void should_be_presented_with_the_following_validation_message_as(String loginValidationMessage) {
        accountPage = PageFactory.initElements(driver, MyAccountPage.class);
        Assert.assertTrue(accountPage.getWelcomeMessageTxt().contains(loginValidationMessage));

    }

    @Then("I add the following items to cart in home page")
    public void i_add_the_following_items_to_cart_in_home_page(DataTable dataTable) {
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.addProductToCart(dataTable.cell(0, 0));
        basePage.addProductToCart(dataTable.cell(1, 0));
        basePage.addProductToCart(dataTable.cell(2, 0));
        basePage.addProductToCart(dataTable.cell(3, 0));

    }

    @And("I add the following items to cart in search result page:")
    public void i_add_products_to_cart_in_search_result_page(DataTable dataTable) {
        this.basePage.addProductsToCart(dataTable.cell(0, 0));
        this.basePage.addProductsToCart(dataTable.cell(1, 0));
        this.basePage.addProductsToCart(dataTable.cell(2, 0));
        this.basePage.addProductsToCart(dataTable.cell(3, 0));

    }

    @Then("I add product {string} to basket cart")
    public void i_add_the_to_basket_cart(String productName) {
        this.basePage.addProductToBasket(productName);

    }


    @And("I select color {string}")
    public void iSelectColor(String color) {
        productIdPage = PageFactory.initElements(driver, ProductIDPage.class);
        productIdPage.selectColor(color);

    }

    @And("I select size {string}")
    public void iSelectSize(String size) {
        productIdPage = PageFactory.initElements(driver, ProductIDPage.class);
        productIdPage.selectSize(size);
    }

    @And("I tap on the {string} button")
    public void iTapOnTheButton(String addToCartButton) {
        productIdPage = PageFactory.initElements(driver, ProductIDPage.class);
        AssertionHelper.updateTestStatus(productIdPage.getAdd2Cart().getText().contains(addToCartButton));
        shoppingCartPage = productIdPage.clickAdd2Cart();
    }

    @And("I enter quantity {string}")
    public void iEnterQuantity(String qty) {
        productIdPage = PageFactory.initElements(driver, ProductIDPage.class);
        productIdPage.enterQuantity(qty);
    }


    @And("I should see the followings dash tile options in My Account page:")
    public void iShouldSeeTheFollowingsDashTileOptionsInMyAccountPage(DataTable dataTable) {
        accountPage = PageFactory.initElements(driver, MyAccountPage.class);
        AssertionHelper.updateTestStatus(accountPage.getManageAddressBook().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(accountPage.getOrderHistory().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(accountPage.getDownloads().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(accountPage.getTransactionHistory().contains(dataTable.cell(3, 0)));

    }

    @And("I can see {int} side Widget icons are displayed")
    public void iCanSeeSideWidgetIconsAreDisplayed(int sideWidgetIconCount) {
        accountPage = PageFactory.initElements(driver, MyAccountPage.class);
        Assert.assertEquals(accountPage.getSideWidgetIconCount(), sideWidgetIconCount);
    }

    @And("I can see the links in aside widget are displayed:")
    public void iCanSeeTheLinksInAsideWidgetAreDisplayed(DataTable dataTable) {
        asideWidgetPage = PageFactory.initElements(driver, AsideWidgetPage.class);
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(0).getText().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(1).getText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(2).getText().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(3).getText().contains(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(4).getText().contains(dataTable.cell(4, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(5).getText().contains(dataTable.cell(5, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(6).getText().contains(dataTable.cell(6, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(7).getText().contains(dataTable.cell(7, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(8).getText().contains(dataTable.cell(8, 0)));
        AssertionHelper.updateTestStatus(asideWidgetPage.getAsideWidgetLinks().get(9).getText().contains(dataTable.cell(9, 0)));

    }

    @And("I should see in the current page {string} and {string}")
    public void iShouldSeeInTheCurrentPageAnd(String pageTitle, String pageUrl) {
        this.basePage = PageFactory.initElements(driver, BasePage.class);
        Assert.assertEquals(this.basePage.getThisPageTitle(), pageTitle);
        Assert.assertEquals(this.basePage.getThisPageUrl(), pageUrl);
    }
}
