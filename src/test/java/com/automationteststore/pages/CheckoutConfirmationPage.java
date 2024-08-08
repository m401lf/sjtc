package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import helpers.assertion.VerificationHelper;
import helpers.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class CheckoutConfirmationPage {
    private final Logger log = LogManager.getLogger(CheckoutConfirmationPage.class);
    @FindBy(css = "p > a > b")
    public WebElement returnPolicyLink;
    BasePage page;
    @FindBy(css = "h2[class='heading2'] span")
    private WebElement orderSummaryText;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/h1/span[1]")
    private WebElement pageHeading;
    @FindBy(css = ".align_right.valign_top")
    private List<WebElement> orderSummaryUnitPriceList;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[3]/tbody/tr/td[2]/a")
    private List<WebElement> itemsInYourCartList;
    @FindBy(linkText = "Items in your cart")
    private WebElement itemsInYourCartTxt;
    @FindBy(xpath = "//td[@class='align_left valign_top']//a[contains(text(),'Total Moisture Facial Cream')]")
    private WebElement orderSummaryProductName;
    @FindBy(css = ".bold.extra.totalamout")
    private WebElement totalPriceLabel;
    @FindBy(css = "[class='bold totalamout']")
    private WebElement totalAmt;
    @FindBy(linkText = "Sub-Total:")
    private WebElement subTotal;
    @FindBy(css = ".align_left.valign_top")
    private WebElement orderSummaryNoOfItems;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[2]/span")
    private WebElement flatShippingRate;
    @FindBy(partialLinkText = "tota")
    private WebElement total;
    @FindBy(partialLinkText = "Edit Pay")
    private WebElement editPaymentBtn;
    @FindBy(partialLinkText = "Edit Ship")
    private WebElement editShippingBtn;
    @FindBy(partialLinkText = "Edit Ship")
    private WebElement editShippingButton;
    @FindBy(partialLinkText = "Edit Car")
    private WebElement editCartBtn;
    @FindBy(partialLinkText = "Edit Coup")
    private WebElement editCouponBtn;
    @FindBy(id = "back")
    private WebElement backArrowBtn;
    @FindBy(css = "[title='Confirm Order']")
    private WebElement confirmOrderButton;
    @FindBy(xpath = "//h4[normalize-space()='Payment']")
    private WebElement paymentHeader;
    @FindBy(xpath = "//h4[normalize-space()='Shipping']")
    private WebElement shippingHeader;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement qtyProductWithStockLocations;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    private List<WebElement> ShippingPaymentItemsInYourCartText;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[2]/ul/li")
    private WebElement currencyDropdownBtn;
    //=========================================================
    @FindBy(css = "button#checkout_btn")
    private WebElement confirmOrder_button;
    @FindBy(css = "button.btn.btn-orange.pull-right.lock-on-click")
    private WebElement confirm_Order_button;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li/a")
    private WebElement itemsCartIcon;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/h1/span[1]")
    private WebElement checkoutConfirmationHeadingTxt;
    @FindBy(css = "//*[@id='maincontainer']/div/div[1]/div/div[2]/p")
    private WebElement clickingConfirmOrderReturnPolicyText;
    @FindBy(xpath = "//b[contains(text(),'Return Policy')]")
    private WebElement returnPolicyTxtLink;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[1]/tbody/tr/td[4]/a")
    private WebElement editShipmentIcon;
    @FindBy(xpath = "//h4[contains(text(),'Shipping')]")
    private WebElement shippingTxt;
    @FindBy(css = "//h4[contains(text(),'Payment')]")
    private WebElement paymentTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[1]")
    private WebElement editPaymentIcon;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[2]")
    private WebElement editCouponIcon;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/h4[3]/a")
    private WebElement editCartIcon;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/div[2]/table[3]/tbody/tr/td[4]")
    private List<WebElement> items_In_Your_Cart_List;
    @FindBy(xpath = "/html//a[@id='back']")
    private WebElement backArrowButton;
    @FindBy(css = "span.bold.totalamout")
    private List<WebElement> totalPriceAndAmountTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[1]/span")
    private WebElement totalPriceTxt;
    @FindBy(xpath = "//td[@class='align_left']//a[contains(text(),'Absolue Eye Precious Cells')]")
    private WebElement tPrice;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[2]/span")
    private WebElement amountTxt;

    public String getOrderSummaryText() {
        return new VerificationHelper(driver).getText(orderSummaryText);

    }

    public String getPageHeadingText() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(ExpectedConditions.visibilityOf(pageHeading));
        return new VerificationHelper(driver).getText(pageHeading);
    }

    public WebElement getQtyProductWithStockLocations() {
        return qtyProductWithStockLocations;

    }

    public List<WebElement> getShippingPaymentItemsInYourCartText() {
        return ShippingPaymentItemsInYourCartText;
    }

    public WebElement getCurrencyDropdownBtn() {
        return currencyDropdownBtn;

    }

    public String getConfirmOrderButtonTxt() {
        return new VerificationHelper(driver).getText(confirm_Order_button);

    }

    public WebElement getItemsCartIcon() {
        return itemsCartIcon;

    }


    public WebElement getClickingConfirmOrderReturnPolicyText() {
        return clickingConfirmOrderReturnPolicyText;

    }

    public WebElement getReturnPolicyTextLink() {
        return returnPolicyTxtLink;

    }

    public WebElement getEditShipmentIcon() {
        return editShipmentIcon;

    }

    public WebElement getShippingText() {
        return shippingTxt;

    }

    public WebElement getPaymentText() {
        return paymentTxt;

    }

    public WebElement getEditPaymentIcon() {
        return editPaymentIcon;

    }

    public WebElement getEditCouponIcon() {
        return editCouponIcon;

    }

    public String getItemsInYourCartText() {
        return new VerificationHelper(driver).getText(itemsInYourCartTxt);

    }

    public WebElement getEditCartIcon() {
        return editCartIcon;

    }


    public long getItems_In_Your_Cart_List() {
        return items_In_Your_Cart_List.size();

    }

    public WebElement getBackArrowButton() {
        return backArrowBtn;

    }

    public List<WebElement> getTotalPriceAndAmountText() {
        return totalPriceAndAmountTxt;

    }

    public WebElement getTotalPriceText() {
        return totalPriceTxt;

    }

    public WebElement getMountText() {
        return amountTxt;

    }

    //===============================================================

    public String getPaymentHeaderText() {
        return new VerificationHelper(driver).getText(paymentHeader);

    }

    public String getShippingHeaderText() {
        return new VerificationHelper(driver).getText(paymentHeader);

    }

    public String getOrderSummaryNoOfItemsText() {
        return new VerificationHelper(driver).getText(orderSummaryNoOfItems);

    }

    public List<WebElement> getUnitPriceList() {
        return orderSummaryUnitPriceList;

    }

    public String getReturnPolicyLinkText() {
        return new VerificationHelper(driver).getText(returnPolicyLink);

    }

    public ReturnPolicyPage clickOnReturnPolicyLink() {
        returnPolicyLink.click();
        return new ReturnPolicyPage();
    }

    public List<WebElement> getItemsInYourCartList() {
        return itemsInYourCartList;

    }

    public String getTotalPriceLabelText() {
        return new VerificationHelper(driver).getText(totalPriceLabel);

    }

    public String getTotalAmountText() {
        return new VerificationHelper(driver).getText(totalAmt);

    }

    public String getSubTotalText() {
        return new VerificationHelper(driver).getText(subTotal);

    }

    public String getFlatShippingRateText() {
        return new VerificationHelper(driver).getText(flatShippingRate);

    }

    public String getTotalText() {
        return new VerificationHelper(driver).getText(total);
    }

    public CheckoutEditPaymentPage clickOnEditPaymentButton() {
        editPaymentBtn.click();
        return new CheckoutEditPaymentPage();
    }

    public String getEditPaymentButtonText() {
        return new VerificationHelper(driver).getText(editPaymentBtn);

    }

    public CheckoutShippingModeEditPage clickOnEditShippingButton() throws IOException {
        editShippingBtn.click();
        return new CheckoutShippingModeEditPage();
    }

    public String getEditShippingButtonText() {
        return new VerificationHelper(driver).getText(editShippingButton);

    }

    public ShoppingCartPage clickOnEditCartButton() throws IOException {
        editCartBtn.click();
        return new ShoppingCartPage();
    }

    public String getEditCartButtonText() {
        return new VerificationHelper(driver).getText(editCartBtn);

    }

    public CheckoutEditCouponPage clickOnEditCouponButton() throws IOException {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.waitAndClick(editCouponBtn);
        return new CheckoutEditCouponPage();
    }

    public String getEditCouponButtonText() {
        return new VerificationHelper(driver).getText(editCouponBtn);

    }

    public CheckoutSuccessPage clickConfirmOrderButton() throws IOException {
        page = PageFactory.initElements(driver, BasePage.class);
        page.waitAndClick(confirmOrderButton);
        return new CheckoutSuccessPage();
    }

    public String getCheckoutConfirmationHeadingText() {
        return new VerificationHelper(driver).getText(checkoutConfirmationHeadingTxt);

    }

    public CheckoutCartPage clickOnBackArrowButton() throws IOException {
        backArrowButton.click();
        return new CheckoutCartPage();
    }

    public String getBackArrowButtonText() {
        return new VerificationHelper(driver).getText(backArrowButton);

    }

    public String getAmountText() {
        return new VerificationHelper(driver).getText(amountTxt);

    }

    public CheckoutSuccessPage clickOnConfirmOrderButton() throws Exception {
        new JavaScriptHelper(driver).scrollIntoViewAndClick(confirm_Order_button);
        //confirm_Order_button.click();
        return new CheckoutSuccessPage();
    }

    public String getConfirmOrderButtonText() {
        return new VerificationHelper(driver).getText(confirmOrder_button);

    }

}
