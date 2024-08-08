package testCases.OrderSubmitTest;


import helper.assertion.AssertionHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.ApplicationText.AppText;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;


public class order_submit_test extends BaseTest {
    NavigationMenuPage naviPage;
    ProductCategoryPage productCategoryPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    LoginPage loginPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Test(description = "order purchase")
    public void orderPurchaseTest() throws IOException {
        indexPage = new IndexPage(driver);
        loginPage = new LoginPage(driver);
        Assert.assertTrue(indexPage.getCurrentPageTitle().equalsIgnoreCase("Your Store"));
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains("tutorialsninja.com/demo/"));
        naviPage = new NavigationMenuPage(driver);
        productCategoryPage = naviPage.mouseOverMenuItemAndClickOnItemFromDropdown(AppText.laptopsAndNotebooks, AppText.Show_AllLaptops_And_Notebooks);
        Assert.assertTrue(indexPage.getCurrentPageTitle().equalsIgnoreCase("Laptops & Notebooks"));
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains("?route=product/category&path=18"));
        productCategoryPage.addProductToCart(AppText.Sony_VAIO);
        Assert.assertTrue(productCategoryPage.assertSuccessfullyAddedItemsYourShoppingCartTextIsDisplayed());
        AssertionHelper.updateTestStatus(productCategoryPage.getSuccessfullyAddedItemsYourShoppingCartText().contains("Success: You have added"));
        Assert.assertTrue(productCategoryPage.getCartTotalItemsText().contains("1 item(s)"));
        Assert.assertTrue(productCategoryPage.assertCartTotalItemsTextIsDisplayed());
        productCategoryPage.clickCartTotalItems();
        Assert.assertTrue(productCategoryPage.assertItemsInCartIsDisplayed(AppText.Sony_VAIO));
        Assert.assertTrue(productCategoryPage.assertViewCartButtonIsDisplayed());
        Assert.assertTrue(productCategoryPage.getViewCartButtonText().contains("View Cart"));
        Assert.assertTrue(productCategoryPage.assertCheckoutButtonTextIsDisplayed());
        Assert.assertTrue(productCategoryPage.getCheckoutButtonText().contains("Checkout"));
        shoppingCartPage = indexPage.clickViewCartButton();
        shoppingCartPage.clickCheckoutButtonInShoppingPage();
        Assert.assertTrue(loginPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Checkout"));
        checkoutPage = loginPage.loginApplicationAsReturningCustomerWithValidCredentials(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        checkoutPage.clickContinueButtonStep1ShippingAddress();
        AssertionHelper.updateTestStatus(checkoutPage.assertItemsInCheckoutOptions("Step 1: Checkout Options"));
        checkoutPage.clickContinueButtonStep2BillingDetails();
        AssertionHelper.updateTestStatus(checkoutPage.assertItemsInCheckoutOptions("Step 2: Billing Details"));
        AssertionHelper.updateTestStatus(checkoutPage.assertToUseExistingAddressRadioButtonIsSelectedByDefault());
        checkoutPage.clickContinueButtonStep3DeliveryDetails();
        AssertionHelper.updateTestStatus(checkoutPage.assertItemsInCheckoutOptions("Step 3: Delivery Details"));
        AssertionHelper.updateTestStatus(checkoutPage.assertToUseExistingAddressRadioButtonIsSelectedByDefault());
        checkoutPage.clickContinueButtonStep4DeliveryMethods();
        AssertionHelper.updateTestStatus(checkoutPage.assertItemsInCheckoutOptions("Step 4: Delivery Method"));
        AssertionHelper.updateTestStatus(checkoutPage.assertFlatShippingRateRadioBtnSelected());
        AssertionHelper.updateTestStatus(checkoutPage.assertCashOnDeliveryIsSelectedByDefault());
        checkoutPage.tickAgreeToTermsCheckbox();
        checkoutPage.clickContinueButtonStep5PaymentMethods();
        AssertionHelper.updateTestStatus(checkoutPage.assertItemsInCheckoutOptions("Step 5: Payment Method"));
        AssertionHelper.updateTestStatus(checkoutPage.assertItemsInCheckoutOptions("Step 6: Confirm Order"));
        checkoutSuccessPage = checkoutPage.clickContinueButtonStep6OrderConfirmation();
        AssertionHelper.updateTestStatus(checkoutSuccessPage.assertOrderSuccessfullyPlacedTextDisplayed());
        AssertionHelper.updateTestStatus(checkoutSuccessPage.assertForShippingWithUsTextDisplayed());
        indexPage = checkoutSuccessPage.clickContinueButtonInCheckoutSuccess();
    }


}




