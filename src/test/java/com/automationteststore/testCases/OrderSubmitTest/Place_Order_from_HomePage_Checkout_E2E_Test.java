package com.automationteststore.testCases.OrderSubmitTest;


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
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;

public class Place_Order_from_HomePage_Checkout_E2E_Test extends BaseTest {

    String[] itemsNeeded = {"SKINSHEEN BRONZER STICK", "BENEFIT BELLA BAMBA", "ABSOLUE EYE PRECIOUS CELLS"};

    TopMenuNavigationPage naviPage;
    IndexPage indexPage;
    LoginPage loginPage;
    CheckoutConfirmationPage accountPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutConfirmationPage checkoutConfirmationPage;
    CheckoutCartPage checkoutCartPage;
    ProductCategoryPage productCategoryPage;
    CheckoutSuccessPage checkoutSuccessPage;


    @Test
    public void completeOrder1() throws IOException {
        naviPage = new TopMenuNavigationPage(driver);
        naviPage.navigateToIndexPage();
        indexPage = new IndexPage(driver);
        indexPage.addProductsToCart(GlobalVars.getAbsolueEyePreciousCells());
        indexPage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        indexPage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        indexPage.addProductsToCart(GlobalVars.getSkinBronzerStick());


        //////naviPage.mouseHoverItemsDropdownLink();
        Assert.assertTrue(naviPage.assertProductsAreDisplayed());
        Assert.assertTrue(naviPage.assertProductNamesAreDisplayed());

        loginPage = naviPage.clickCheckoutButton();
        Assert.assertTrue(loginPage.assertPageBreadCrumbMenuDisplayedContains("Login"));
        Assert.assertTrue(loginPage.getNewCustomerTxt().contains("I AM A NEW CUSTOMER."));
        Assert.assertTrue(loginPage.getReturningCustomerTxt().contains("RETURNING CUSTOMER"));
        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getPassword());
        accountPage = loginPage.clickLoginButton();
       ///// naviPage.mouseHoverItemsDropdownLink();
        checkoutConfirmationPage = naviPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutConfirmationPage.assertPageBreadCrumbMenuDisplayedContains("Confirm"));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
        boolean status_orderNumber = checkoutSuccessPage.getOrderNumberTxt().contains("Your order #");
        AssertionHelper.updateTestStatus(status_orderNumber);
        AssertionHelper.updateTestStatus(checkoutSuccessPage.assertThankYouForShoppingWithUsTxt().contains("Thank you for shopping with us!"));
        AssertionHelper.updateTestStatus(checkoutSuccessPage.verifyThankYouForShoppingWithUsTxt());
        checkoutSuccessPage.clickOnContinueCheckoutSuccessButton();
        AssertionHelper.updateTestStatus(indexPage.getThisPageUrl().contains("https://automationteststore.com/"));
        AssertionHelper.updateTestStatus(indexPage.getThisPageTitle().contains("A place to practice your automation skills!"));

    }
}