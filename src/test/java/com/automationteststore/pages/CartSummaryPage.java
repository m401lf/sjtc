package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class CartSummaryPage {

    final static Logger log = LogManager.getLogger(CartSummaryPage.class);

    @FindBy(css = ".maintext")
    public WebElement yourShoppingCart;
    @FindBy(css = "i.fa.fa-trash-o.fa-fw")
    public List<WebElement> quantity_delete;
    @FindBy(xpath = "//*[contains(text(),'Your shopping cart is empty')]")
    public WebElement emptyShoppingCartMsg;
    @FindBy(css = "a[title='Continue']")
    public WebElement continueBtn;


    public void clickOnContinueButton() throws IOException {
        continueBtn.click();
    }

    public boolean assertProduct(String prod) {
        System.out.println("selecting product.." + prod);
        WebElement product = driver.findElement(By.xpath("//*[contains(text(),'" + prod + "')]"));
        return new VerificationHelper(driver).isDisplayed(product);
    }

    public void deleteProductFromShoppingCart() throws InterruptedException {
        // Delete all items from cart
        System.out.println("Deleting all products from cart..");
        List<WebElement> deletes = quantity_delete;
        Iterator<WebElement> itr = deletes.iterator();
        while (itr.hasNext()) {
            itr.next().click();
            Thread.sleep(2000);
        }
    }

    public boolean assertEmptyShoppingCartMessageIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);
    }

}
