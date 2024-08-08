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

public class verifyItemsUnitAndTotalPricesAreDisplayedShippingCart extends BaseTest {
    TopMenuNavigationPage naviPage;
    IndexPage indexPage;
    CheckoutCartPage checkoutCartPage;


    @Test
    public void verifyUnitPrice() throws Exception {
        naviPage = new TopMenuNavigationPage(driver);
        naviPage.navigateToIndexPage();
        indexPage = new IndexPage(driver);
        indexPage.addProductsToCart(GlobalVars.getAbsolueEyePreciousCells());
        indexPage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        indexPage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        indexPage.addProductsToCart(GlobalVars.getSkinBronzerStick());
        //naviPage.mouseHoverItemsDropdownLink();
        Assert.assertTrue(naviPage.assertProductsAreDisplayed());
        Assert.assertTrue(naviPage.assertProductNamesAreDisplayed());
        checkoutCartPage = naviPage.clickOnViewCartLink();
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart(GlobalVars.getAbsolueEyePreciousCells(), 10);
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart(GlobalVars.getBenefitBellaBamba(), 7);
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart(GlobalVars.getSkinBronzerStick(), 5);

        checkoutCartPage.clickOnUpdateButton();
        checkoutCartPage.removeItemFromShippingCart((GlobalVars.getAbsolueEyePreciousCells()));
        checkoutCartPage.clickOnUpdateButton();
        checkoutCartPage.assertProductNameAndUnitPriceIsDisplayed(GlobalVars.getBenefitBellaBamba());
        checkoutCartPage.assertProductNameAndTotalPriceIsDisplayed(GlobalVars.getBenefitBellaBamba());

    }
}


