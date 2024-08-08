package com.automationteststore.testCases.Search;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.IndexPage;
import pages.SearchResultPage;
import pages.TopMenuNavigationPage;

@Listeners(base.Listeners.class)

@Test
public class TC_004_SearchProductTest extends BaseTest {
    SearchResultPage searchResultPage;
    TopMenuNavigationPage naviPage;

    public void test_productSearch() {
        //log.info(" Starting TC_004_SearchProductTest ");

        try {

            naviPage = new TopMenuNavigationPage(driver);
            naviPage.enterSearchProduct("mac");
            searchResultPage = naviPage.clickSearchButton();

            searchResultPage.isProductExist("MacBook");

            Assert.assertTrue(searchResultPage.isProductExist("MacBook"));

        } catch (Exception e) {
            Assert.fail();
        }

        //log.info(" Finished TC_004_SearchProductTest ");

    }
}
