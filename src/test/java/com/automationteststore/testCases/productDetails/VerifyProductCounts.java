package com.automationteststore.testCases.productDetails;


import com.automationteststore.pages.NavigationMenuPage;
import com.automationteststore.pages.ProductCategoryPage;
import helpers.assertion.AssertionHelper;
import org.testng.annotations.Test;



public class VerifyProductCounts extends BaseTest {
    NavigationMenuPage navigationMenuPage;
    ProductCategoryPage productCategoryPage;

    @Test
    public void testVerifyProductCounts() {

        navigationMenuPage = new NavigationMenuPage();
        productCategoryPage = navigationMenuPage.mouseOverMenuItemAndClickOnItemFromDropdown(AppText.laptopsAndNotebooks, AppText.showAllLaptopsAndNotebooks);
        int count = productCategoryPage.getTotalProductsCount();
        if (count == 5) {
            AssertionHelper.markPass();
        } else {
            AssertionHelper.markFail("product count is not matching");
        }
    }
}
