package com.automationteststore.testCases.OrderSubmitTest;


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

public class AddRemoveItemBasketTest extends BaseTest {

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
    public void testAddRemoveItemBasket() throws InterruptedException, IOException {
        naviPage = new TopMenuNavigationPage(driver);
        indexPage = new IndexPage(driver);
        indexPage.addProductsToCart(GlobalVars.PRODUCTNAME_1);
        indexPage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        indexPage.addProductsToCart(GlobalVars.PRODUCTNAME_3);

        /////naviPage.mouseHoverItemsDropdownLink();
        Assert.assertTrue(naviPage.assertProductsAreDisplayed());
        loginPage = naviPage.clickCheckoutButton();
        Assert.assertTrue(loginPage.assertPageBreadCrumbMenuDisplayedContains("Login"));
        Assert.assertTrue(loginPage.getNewCustomerTxt().contains("I AM A NEW CUSTOMER."));
        Assert.assertTrue(loginPage.getReturningCustomerTxt().contains("RETURNING CUSTOMER"));
        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getPassword());
        accountPage = loginPage.clickLoginButton();
        /////naviPage.mouseHoverItemsDropdownLink();
        checkoutConfirmationPage = naviPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutConfirmationPage.assertPageBreadCrumbMenuDisplayedContains("Confirm"));
    }
}
