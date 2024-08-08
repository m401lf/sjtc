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
import testData.data.datarepo;
import utilities.GlobalVars;

import java.io.IOException;


public class order_submit_as_new_customer_checkout_option extends BaseTest {
    NavigationMenuPage naviPage;
    ProductCategoryPage productCategoryPage;
    ShoppingCartPage shoppingCartPage;
    ProductIDPage productIDPage;
    CheckoutPage checkoutPage;
    LoginPage loginPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Test(description = "summit order as a new customer")
    public void OrderSubmitRegistrationOption() throws IOException {
        loginPage = new LoginPage(driver);
        productIDPage = new ProductIDPage(driver);
        productCategoryPage = new ProductCategoryPage(driver);
        Assert.assertTrue(indexPage.getCurrentPageTitle().equalsIgnoreCase("Your Store"));
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains("tutorialsninja.com/demo/"));
        naviPage = new NavigationMenuPage(driver);
        productCategoryPage.clickCartTotalItems();
        Assert.assertTrue(productCategoryPage.getYourShoppingCartIsEmptyText().equalsIgnoreCase("Your shopping cart is empty!"));
        productCategoryPage = naviPage.mouseOverMenuItemAndClickOnItemFromDropdown(AppText.laptopsAndNotebooks, AppText.Show_AllLaptops_And_Notebooks);
        Assert.assertTrue(indexPage.getCurrentPageTitle().equalsIgnoreCase("Laptops & Notebooks"));
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains("?route=product/category&path=18"));
        productCategoryPage.addProductToCart(AppText.Sony_VAIO);
        Assert.assertTrue(productCategoryPage.assertSuccessfullyAddedItemsYourShoppingCartTextIsDisplayed());
        AssertionHelper.updateTestStatus(productCategoryPage.getSuccessfullyAddedItemsYourShoppingCartText().contains("Success: You have added"));
        Assert.assertTrue(productCategoryPage.getCartTotalItemsText().contains("1 item(s)"));
        Assert.assertTrue(productCategoryPage.assertCartTotalItemsTextIsDisplayed());
        productCategoryPage.clickCartTotalItems();
        Assert.assertTrue(productCategoryPage.assertListOfDisplayedTextInItemCartIsDisplayed());
        Assert.assertTrue(productCategoryPage.assertItemsInCartIsDisplayed(AppText.Sony_VAIO));
        Assert.assertTrue(productCategoryPage.assertViewCartButtonIsDisplayed());
        Assert.assertTrue(productCategoryPage.getViewCartButtonText().contains("View Cart"));
        Assert.assertTrue(productCategoryPage.assertCheckoutButtonTextIsDisplayed());
        Assert.assertTrue(productCategoryPage.getCheckoutButtonText().contains("Checkout"));
        shoppingCartPage = indexPage.clickViewCartButton();
        Assert.assertTrue(shoppingCartPage.assertContinueShippingButtonIsDisplayed());
        indexPage = shoppingCartPage.clickContinueShippingButton();
        productCategoryPage = naviPage.mouseOverMenuItemAndClickOnItemFromDropdown(AppText.Desktops, AppText.Show_AllDesktops);
        productIDPage = productCategoryPage.addProductToCartInProductIDPage(AppText.HP_LP3065);
        Assert.assertTrue(productCategoryPage.assertPageHeaderIsDisplayed());
        productIDPage.inputDeliveryDateBox("2024-04-22");
        productIDPage.inputQuantityBox("2");
        productIDPage.clickAddToCartButtonText();
        productCategoryPage.clickCartTotalItems();
        Assert.assertTrue(productCategoryPage.assertListOfDisplayedTextInItemCartIsDisplayed());
        shoppingCartPage = indexPage.clickViewCartButton();
        checkoutPage = shoppingCartPage.clickCheckoutButtonInShoppingPage();
        Assert.assertTrue(checkoutPage.assertPageBreadCrumbMenuNameIsDisplayedAs("Checkout"));
        Assert.assertTrue(checkoutPage.getNewCustomerText().contains(GlobalVars.getNewCustomer()));
        Assert.assertTrue(checkoutPage.getReturningCustomerText().contains(GlobalVars.getReturningCustomer()));
        Assert.assertTrue(checkoutPage.assertRegisterAccountRadioButtonIsSelected());
        Assert.assertTrue(checkoutPage.assertGuestCheckoutRadioButtonIsNotSelected());
        checkoutPage.clickContinueButtonStep1CheckoutOptions();
        checkoutPage.inputStep2BillingDetails(
                datarepo.getFirstName(),
                datarepo.getLastName(),
                datarepo.getTelephone(),
                datarepo.getCompanyName(),
                datarepo.getAddress1(),
                datarepo.getAddress2(),
                datarepo.getCity(),
                datarepo.getZipCode(),
                datarepo.getCountry(),
                datarepo.getRegionState(),
                datarepo.getPassword()
        );


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


