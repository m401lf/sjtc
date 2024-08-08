package com.automationteststore.stepDefinitions;


import com.automationteststore.base.BasePage;
import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.*;
import helpers.assertion.AssertionHelper;
import helpers.javaScript.JavaScriptHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.GlobalVars;

import java.io.IOException;
import java.util.List;


public class e2eSteps extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public MyAccountPage accountPage;
    public ForgottenPasswordPage forgottenPasswordPage;
    public ForgottenLoginnamePage forgottenLoginnamePage;
    public RegisterPage registerPage;
    public EditProfilePage editPage;
    public LogoutPage logoutPage;
    public SuccessPage successPage;
    public CheckoutCartPage checkoutCartPage;
    public CheckoutCustomerPage checkoutCustomerPage;
    public CheckoutConfirmationPage checkoutConfirmationPage;
    public CheckoutPage checkoutPage;
    public CheckoutSuccessPage checkoutSuccessPage;
    public ProductCategoryPage productCategoryPage;
    ProductIDPage productIdPage;
    BasePage page;
    TopMenuPage topMenuPage;
    TopMenuPage naviPage;
    ShoppingCartPage shoppingCartPage;

    @Given("I am on ecommerce website")
    public void iAmOnEcommerceWebsite(String url) throws Exception {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        topMenuPage = launchApplication();
        List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));
        new JavaScriptHelper(driver).scrollToElement(products.get(0));
    }

    @Given("I am back on ecommerce website")
    public void iAmBackOnEcommerceWebsite() {
        page = PageFactory.initElements(driver, BasePage.class);
        BasePage.isActivePage();
        AssertionHelper.updateTestStatus(page.getThisPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl()));
    }

    @When("I can see page title {string} and page url {string} in the Home basePage")
    public void i_can_see_page_title_and_page_url(String pageTitle, String pageUrl) {
        page = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(page.getThisPageTitle().contains(pageTitle));
        AssertionHelper.updateTestStatus(page.getThisPageUrl().contains(pageUrl));
    }

    @Given("I can see in current page title and url as follows:")
    public void i_can_see_in_current_page_title_and_url_as_follows(DataTable dataTable) throws InterruptedException {
        page = PageFactory.initElements(driver, BasePage.class);
        BasePage.isActivePage();
        AssertionHelper.updateTestStatus(page.getThisPageTitle().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(page.getThisPageUrl().contains(dataTable.cell(1, 0)));

    }

    @When("I search with a keyword {string}")
    public void iMoveToTheSearchAndInputAKeyword(String item) {

    }

    @And("I add product {string}, {string} and {string} to cart")
    public void iAddAnItemToCart(String productName0, String productName1, String productName2) {
        productCategoryPage = PageFactory.initElements(driver, ProductCategoryPage.class);
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
        productCategoryPage.addProductToCart(productName2);
    }

    @And("I add products {string} and {string} to cart")
    public void iAddProductsToCart(String productName0, String productName1) {
        productCategoryPage = PageFactory.initElements(driver, ProductCategoryPage.class);
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
    }

    @And("I add products {string} and {string} and {string} to basket")
    public void iAddSomeProductsToBasket(String productName0, String productName1, String productName2) {
        productCategoryPage = PageFactory.initElements(driver, ProductCategoryPage.class);
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
        productCategoryPage.addProductToCart(productName2);
    }

    @And("I add products to cart {string}, {string} and {string}")
    public void i_add_products_to_cart_and(String productName0, String productName1, String productName2) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.addProductsToCart(productName0);
        homePage.addProductsToCart(productName1);
        homePage.addProductsToCart(productName2);

    }

    @And("I scroll to the products view")
    public void iScrollToProductView() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        List<WebElement> products = homePage.getProductList();
        new JavaScriptHelper(driver).scrollToElement(products.get(0));

    }

    @Given("can see No Of Items in Cart and Total Amount are displayed as follows:")
    public void can_see_no_of_items_in_cart_and_total_amount_are_displayed_as_follows(DataTable dataTable) {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        AssertionHelper.updateTestStatus(dataTable.cell(1, 0).contains(topMenuPage.getCartTotalAmountText()));
        AssertionHelper.updateTestStatus(dataTable.cell(2, 0).contains(topMenuPage.getCartTotalQuantityText()));

    }

    @And("I hoverOver items cart and click on checkout icon from dropdown")
    public void i_hoverOver_items_cart_and_click_on_checkout_icon_from_dropdown() {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        checkoutPage = topMenuPage.mouseOverItemsCartLinkAndClickCheckoutIcon();
    }

    @And("I hoverOver items cart and click on view Cart icon from dropdown")
    public void i_hoverOver_items_cart_and_click_on_view_Cart_icon_from_dropdown() {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        shoppingCartPage = topMenuPage.mouseOverItemsCartLinkAndClickViewCartIcon();
    }

    @When("I should see {} in checkout confirmation page")
    public void iShouldSeeInCheckoutConfirmationPage(String pageHeaderTitle) {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getOrderSummaryText().contains(pageHeaderTitle));

    }

    @Given("I tap on Confirm Order")
    public void i_tap_on_confirm_order() throws Exception {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @Given("I tap on {string} in checkout confirmation page")
    public void i_tap_on_confirm_order_in_checkout_confirmation_page(String confirmOrderButtonText) throws Exception {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        Assert.assertEquals(checkoutConfirmationPage.getConfirmOrderButtonTxt(), confirmOrderButtonText);
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();

    }

    @Then("I should see {string} in Checkout Success page")
    public void i_should_see_in_checkout_success_page(String orderProcessed) throws InterruptedException {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        Assert.assertEquals(checkoutSuccessPage.getYourOrderHasBeenProcessedText(), orderProcessed);

    }

    @Then("I should see Your order number has been created")
    public void i_should_see_your_order_number_has_been_created() {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        AssertionHelper.updateTestStatus(checkoutSuccessPage.assertOrderNumberTextIsDisplayed());

    }

    @Then("I should see {string} in the page")
    public void i_should_see_thank_you_for_shopping_with_us_in_checkout_success_page(String thankMsg) {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        Assert.assertEquals(checkoutSuccessPage.getThankYouForShoppingWithUsText(), thankMsg);
    }

    @And("I click on Checkout Icon button")
    public void iClickCheckoutIconButton() {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        loginPage = topMenuPage.clickCheckoutIcon();

    }

    @And("I click Checkout Icon button")
    public void clickCheckoutIconButton() throws IOException {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        loginPage = topMenuPage.clickCheckoutCartDropdownIconButton();

    }

    @And("I click View Cart Icon button")
    public void clickViewCartIconButton() {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        shoppingCartPage = topMenuPage.clickViewCartDropdownIconButton();

    }


    @When("I login in login page as a returning customer:")
    public void i_login_in_login_page_as_a_returning_customer(DataTable dataTable) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterLoginName(dataTable.cell(1, 0));
        loginPage.enterPassword(dataTable.cell(1, 1));
        checkoutConfirmationPage = loginPage.clickLoginButton();

    }

    @And("I navigate to shopping page")
    public void iNavigateToShoppingPage() throws IOException {
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        topMenuPage.mouseOverItemLink();
        checkoutCartPage = naviPage.clickOnViewCartLink();

    }

    @And("I increased quantity by {}")
    public void iInputInQuantityFieldAndIncreasedBy(int number) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        shoppingCartPage.inputItemQuantity(number);

    }

    @And("I update {string} quantity in cart by {}")
    public void iUpdateProductQtyInTheCart(String productName, int qty) throws InterruptedException {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        shoppingCartPage.updateQuantityOfProductInTheCart(productName, qty);

    }

    @Given("I update product in cart by quantity:")
    public void i_update_product_in_cart_by_quantity(DataTable dataTable) throws InterruptedException {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        shoppingCartPage.updateQuantityOfProductInTheCart(dataTable.cell(1, 0), Integer.parseInt(dataTable.cell(1, 1)));
    }


    @Given("I can see product {string} and per unit price {}")
    public void i_can_see_product_and_per_unit_price(String productName, String unitPrice) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertTrue(shoppingCartPage.getUnitPriceOfProductInTheCart(productName).equalsIgnoreCase(unitPrice));
    }

    @Given("I can see product and per unit price:")
    public void i_can_see_product_and_per_unit_price(DataTable dataTable) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertTrue(shoppingCartPage.getUnitPriceOfProductInTheCart(dataTable.cell(0, 0)).equalsIgnoreCase(dataTable.cell(1, 0)));

    }

    @Given("I can see product name")
    public void i_can_see_product_name(DataTable dataTable) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertTrue(shoppingCartPage.getNameOfProductsInTheCart(dataTable.cell(0, 0)).contains(dataTable.cell(0, 0)));

    }

    @Given("I should see the product name {string} in the cart")
    public void i_can_see_product_and_total_price(String productName) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertTrue(shoppingCartPage.getNameOfProductsInTheCart(productName).contains(productName));

    }

    @Given("I can see product name and total price:")
    public void i_can_see_product_name_and_total_price(DataTable dataTable) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertEquals(shoppingCartPage.getTotalPriceOfProductInTheCart(dataTable.cell(0, 0)), dataTable.cell(0, 1));

    }

    @Given("click on update button")
    public void click_on_update_button() {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        shoppingCartPage.clickOnUpdateButton();

    }

    @Given("click {string} button")
    public void click_update_button(String updateBtn) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertEquals(shoppingCartPage.getUpdateButtonText(), updateBtn);
        shoppingCartPage.clickOnUpdateButton();
    }

    @Given("I can see current page submenu breadcrumbs {string} are correctly displayed")
    public void i_can_see_current_page_submenu_breadcrumbs_are_correctly_displayed(String breadcrumbText) throws InterruptedException {
        page = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(page.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(breadcrumbText));
    }

    @And("I reduced quantity by {int}")
    public void iReducedQuantityBy(int number) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        shoppingCartPage.inputItemQuantity(number);

    }

    @And("I removed {string} item from cart")
    public void iRemovedSomeItemsFromCart(String productName) throws InterruptedException {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        shoppingCartPage.removeProductFromCart(productName);

    }


    @And("I can see {string} and {string} in login page")
    public void iCanSeeReturningCustomerAndNewCustomerText(String returningCustomerTxt, String newCustomerTxt) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        boolean status_returningCustomer = loginPage.getReturningCustomerTxt().equalsIgnoreCase(returningCustomerTxt);
        AssertionHelper.updateTestStatus(status_returningCustomer);
        boolean status_newCustomer = loginPage.getNewCustomerTxt().equalsIgnoreCase(newCustomerTxt);
        AssertionHelper.updateTestStatus(status_newCustomer);

    }

    @And("I can see {string}, {string}, {string}, {string}, {string} and {string} buttons are displayed")
    public void iCanSeeAndButtonsAreDisplayed(String editShippingTxt, String editPayTxt, String editCoupTxt, String editCartTxt, String backArrowBtnTxt, String confirmOrderBtnTxt) {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditShippingButtonText().trim().contains(editShippingTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditPaymentButtonText().trim().contains(editPayTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCouponButtonText().trim().contains(editCoupTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCartButtonText().trim().contains(editCartTxt));
        Assert.assertTrue(checkoutConfirmationPage.getBackArrowButtonText().contains(backArrowBtnTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().trim().contains(confirmOrderBtnTxt));
    }

    @Given("I can see the following buttons are displayed:")
    public void i_can_see_the_following_buttons_are_displayed(DataTable dataTable) {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditShippingButtonText().trim().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditPaymentButtonText().trim().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCouponButtonText().trim().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCartButtonText().trim().contains(dataTable.cell(3, 0)));
        Assert.assertTrue(checkoutConfirmationPage.getBackArrowButtonText().contains(dataTable.cell(4, 0)));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().trim().contains(dataTable.cell(5, 0)));
    }

    @Given("I click Edit Cart button")
    public void i_click_edit_cart_button() throws IOException {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        checkoutConfirmationPage.clickOnEditCartButton();
    }

    @Given("I click {string} button in checkout_confirmation_page")
    public void i_click_edit_cart_button_in_checkout_confirmation_page(String confirmationButtonText) throws IOException {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCartButtonText().trim().contains(confirmationButtonText));
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        checkoutConfirmationPage.clickOnEditCartButton();
    }

    @And("I click on confirm order button")
    public void iClickOnConfirmOrderButton() throws Exception {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().contains("Confirm"));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @And("I tap on {string}")
    public void iTapConfirmOrderButtonCheckoutConfirmationPage(String confirmOrderButtonText) throws Exception {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().contains(confirmOrderButtonText));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @And("I am presented with {}")
    public void iAmPresentedWithAnOderNumber(String orderNumberMsg) {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        boolean status = checkoutSuccessPage.getOrderNumberText().contains(orderNumberMsg);
        AssertionHelper.updateTestStatus(status);

    }

    @Then("I click on Continue button in Checkout Success page")
    public void i_click_on_continue_button_in_checkout_success_page() throws InterruptedException {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        homePage = checkoutSuccessPage.clickOnContinueCheckoutSuccessButton();
    }


    @And("I click on {string} button in Checkout Success page")
    public void iClicksOnContinue_checkout_success_page(String continueButton) throws InterruptedException {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        AssertionHelper.updateTestStatus(checkoutSuccessPage.getContinueButtonText().contains(continueButton));
        homePage = checkoutSuccessPage.clickOnContinueCheckoutSuccessButton();


    }

    @And("I am back to home page")
    public void iAmBackToHomePage() {


    }

    @And("I tap on checkout button")
    public void iTapOnCheckoutButton() {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        loginPage = shoppingCartPage.clickOnCheckoutButton();

    }

    @And("I tap {string} button")
    public void iTapCheckoutButton(String checkoutBtn) {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertEquals(shoppingCartPage.getCheckoutButtonText(), checkoutBtn);
        loginPage = shoppingCartPage.clickOnCheckoutButton();

    }

    @And("I login with {string} and {string} as a returning customer")
    public void iLoginWithAsAReturningCustomer(String loginname, String password) throws IOException {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterLoginName(loginname);
        loginPage.enterPassword(password);
        checkoutConfirmationPage = loginPage.clickLoginButton();
    }

    @Given("I can see {} and {} in login page")
    public void i_can_see_returning_customer_and_i_am_a_new_customer(String returning_customer, String new_customer) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        Assert.assertEquals(loginPage.getReturningCustomerTxt(), returning_customer);
        Assert.assertEquals(loginPage.getNewCustomerTxt(), new_customer);

    }

    @And("I should be on {} in the Checkout Confirmation page")
    public void iShouldBeOnCheckoutConfirmationPage(String headerTxt) {
        checkoutConfirmationPage = PageFactory.initElements(driver, CheckoutConfirmationPage.class);
        Assert.assertEquals(checkoutConfirmationPage.getPageHeadingText(), headerTxt);

    }

    @And("I should see order processed, your order number and a thanks message:")
    public void iShouldSeeOrderProcessedYourOrderNumberAndAThanksMessage(DataTable dataTable) {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        AssertionHelper.updateTestStatus(checkoutSuccessPage.getHeading().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(checkoutSuccessPage.getOrderNumberText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(checkoutSuccessPage.getThankYouForShoppingWithUsText().contains(dataTable.cell(2, 0)));

    }

    @And("I should see {string} by going to the invoice page")
    public void iShouldSeeYouCanViewYourOrderDetailsByGoingToTheInvoicePage(String viewInvoiceMsg) {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        Assert.assertTrue(checkoutSuccessPage.getYouCanViewYourOrderDetailsText().contains(viewInvoiceMsg));
    }

    @And("I should see You can view your order details by going to the {string}")
    public void iShouldSeeYouCanViewYourOrderDetailsByGoingToThe(String invoicePage) {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        Assert.assertTrue(checkoutSuccessPage.getViewInvoiceLink().contains(invoicePage));

    }

    @And("I should see {string} number has been created")
    public void iShouldSeeNumberHasBeenCreated(String OrderNumberText) {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        Assert.assertTrue(checkoutSuccessPage.getInvoiceNumberText().contains(OrderNumberText));

    }

    @And("I tap Checkout button")
    public void iTapCheckoutButton() {
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        loginPage = shoppingCartPage.clickOnCheckoutButton();
    }

    @And("I can see {string} is Displayed")
    public void iCanSeeYOURORDERHASBEENPROCESSEDIsDisplayed(String processedOrderMsg) throws InterruptedException {
        checkoutSuccessPage = PageFactory.initElements(driver, CheckoutSuccessPage.class);
        page = PageFactory.initElements(driver, BasePage.class);
        Assert.assertTrue(checkoutSuccessPage.getYourOrderHasBeenProcessedText().contains(processedOrderMsg));
    }

}



