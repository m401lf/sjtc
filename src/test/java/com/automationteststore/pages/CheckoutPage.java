package com.automationteststore.pages;


import com.automationteststore.base.BasePage;
import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.automationteststore.base.BaseTest.driver;


public class CheckoutPage {

    private final Logger log = LogManager.getLogger(CheckoutPage.class);
    BasePage basePage;
    @FindBy(xpath = "//h2[contains(text(),'Customer')]")
    private WebElement customerHeadingTxt;
    @FindBy(css = ".product-column.product-figure")
    private WebElement itemImage;
    @FindBy(xpath = "//button[contains(text(),'Sign Out')]")
    private WebElement signOutBtn;
    @FindBy(xpath = "//*[@id='checkout-app']/div/div/div/div/ol/li[3]/div/a/div[3]/button")
    private WebElement billingAddrEditBtn;
    @FindBy(xpath = "//body/div[@id='checkout-app']/div[1]/div[1]/div[1]/div[1]/ol[1]/li[2]/div[1]/a[1]/div[3]/button[1]")
    private WebElement shippingAddressEditBtn;
    @FindBy(css = ".checkout-step.optimizedCheckout-checkoutStep.checkout-step--customer")
    private WebElement fullCustomerHeadingTxt;
    @FindBy(id = "addressToggle")
    private WebElement shippingAddressTxt;
    @FindBy(xpath = "//label[contains(text(),'My billing address is the same as my shipping addr')]")
    private WebElement myBillingAddressSameShippingAddressTxt;
    @FindBy(xpath = "//h2[contains(text(),'Customer')]")
    private WebElement shippingMethodTxt;
    @FindBy(css = "#checkout-shipping-continue")
    private WebElement customerContinueBtn;
    @FindBy(xpath = "//h3[contains(text(),'Order Summary')]")
    private WebElement orderSummaryTxt;
    @FindBy(css = "#cart-edit-link")
    private WebElement editCartLinkTxt;
    @FindBy(xpath = "//*[@id='checkout-app']/div/div/div/aside/article/section[3]/div/div")
    private WebElement totalPrice;

    public String customerHeadingTxt() {
        return customerHeadingTxt.getText();

    }

    public WebElement itemImage() {
        return itemImage;

    }

    public void clickOnSignOutButton() {
        signOutBtn.click();

    }

    public WebElement signOutBtn() {
        return signOutBtn;

    }

    public void clickOnBillingAddEditButton() {
        billingAddrEditBtn.click();

    }

    public WebElement billingAddEditButton() {
        return billingAddrEditBtn;

    }

    public WebElement shippingAddEditButton() {
        return shippingAddressEditBtn;

    }

    public String getFullCustomerHeadingText() {
        return new VerificationHelper(driver).getText(fullCustomerHeadingTxt);

    }

    public String getShippingAddressText() {
        return new VerificationHelper(driver).getText(shippingAddressTxt);

    }

    public String getMyBillingAddressSameShippingAddressText() {
        return new VerificationHelper(driver).getText(myBillingAddressSameShippingAddressTxt);

    }

    public String getShippingMethodText() {
        return new VerificationHelper(driver).getText(shippingMethodTxt);

    }

    public void clickOnCustomerContinueButton() {
        customerContinueBtn.click();

    }

    public String getOrderSummaryText() {
        return new VerificationHelper(driver).getText(orderSummaryTxt);

    }

    public void clickOnEditCartLink() {
        editCartLinkTxt.click();

    }

    public String getEditCartLinkText() {
        return new VerificationHelper(driver).getText(editCartLinkTxt);

    }

    public String getTotalPrice() {
        return new VerificationHelper(driver).getText(totalPrice);

    }


}
