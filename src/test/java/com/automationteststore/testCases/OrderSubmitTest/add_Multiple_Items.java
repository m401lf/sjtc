package com.automationteststore.testCases.OrderSubmitTest;


import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.CheckoutCartPage;
import pages.IndexPage;
import pages.TopMenuNavigationPage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class add_Multiple_Items extends BaseTest {
    TopMenuNavigationPage naviPage;
    IndexPage indexPage;
    CheckoutCartPage checkoutCartPage;
    @Test
    public void add_multiple_products() throws IOException, InterruptedException {
        naviPage = new TopMenuNavigationPage(driver);
        List<WebElement> itemNames = driver.findElements(By.cssSelector(".prdocutname"));
        new JavaScriptHelper(driver).scrollToElement(itemNames.get(0));
        List<WebElement> addToCartProduct = driver.findElements(By.cssSelector("a.productcart"));

        String[] itemsNeeded = {"TOTAL MOISTURE FACIAL CREAM","BODY CREAM BY BULGARI"};
        for(int i = 0; i<itemNames.size(); i++) {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(name))
                addToCartProduct.get(i).click();

        }
        naviPage = new TopMenuNavigationPage(driver);
        ///naviPage.mouseHoverItemsDropdownLink();
        checkoutCartPage = naviPage.clickOnViewCartLink();
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart("Absolue Eye Precious Cells", 7);

    }

}
