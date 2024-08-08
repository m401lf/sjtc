package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;
import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.time.Duration;

import static com.automationteststore.base.BaseTest.driver;


public class CheckoutSuccessPage {
    private final Logger log = LogManager.getLogger(CheckoutSuccessPage.class);
    HomePage homePage;
    BasePage page;

    private String orderSuccessPageUrl = "https://com/index.php?rt=checkout/success";
    @FindBy(css = "span.maintext")
    private WebElement yourOrderHasBeenProcessedHeadingTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[2]")
    private WebElement OrderNumberText;
    @FindBy(partialLinkText = "Your order #")
    private WebElement OrderNumberTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[3]")
    private WebElement viewInvoiceText;
    @FindBy(xpath = "//p[contains(text(),'You can view your order details by going to the ')]")
    private WebElement youCanViewYourOrderDetailsText;
    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    private WebElement thankYouForShoppingWithUsText;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[3]")
    private WebElement invoicePageLink;

    @FindBy(css = "//*[@id='maincontainer']/div/div/div/div/section/p[3]/a")
    private WebElement invoicePage;
    @FindBy(css = ".maintext")
    private WebElement heading;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/a")
    private WebElement continueCheckoutSuccessBtn;


    public String getHeading() {
        return new VerificationHelper(driver).getText(heading);

    }

    public boolean assertYourOrderHasBeenProcessedTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(yourOrderHasBeenProcessedHeadingTxt);
    }

    public String getYourOrderHasBeenProcessedText() throws InterruptedException {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        return new VerificationHelper(driver).getText(yourOrderHasBeenProcessedHeadingTxt);
    }

    public String getOrderNumberText() {
        return new VerificationHelper(driver).getText(OrderNumberText);

    }

    public boolean assertOrderNumberTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(OrderNumberText);

    }

    public String getViewInvoiceText() {
        return new VerificationHelper(driver).getText(viewInvoiceText);

    }

    public String getThankYouForShoppingWithUsText() {
        return new VerificationHelper(driver).getText(thankYouForShoppingWithUsText);
    }

    public String assertThankYouForShoppingWithUsText() {
        return new VerificationHelper(driver).getText(thankYouForShoppingWithUsText);
    }

    public boolean assertThankYouForShoppingWithUsTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(thankYouForShoppingWithUsText);
    }


    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        invoicePageLink.click();
        return new InvoiceOrderPage();
    }

    public HomePage clickOnContinueCheckoutSuccessButton() {
        continueCheckoutSuccessBtn.click();
        return new HomePage();
    }

    public String getContinueButtonText() {
        return new VerificationHelper(driver).getText(continueCheckoutSuccessBtn);

    }

    public String getYouCanViewYourOrderDetailsText() {
        return new VerificationHelper(driver).getText(youCanViewYourOrderDetailsText);
    }

    public String getInvoiceNumberText() {
        return new VerificationHelper(driver).getText(OrderNumberText);
    }

    public String getViewInvoiceLink() {
        return new VerificationHelper(driver).getText(invoicePageLink);
    }

    public InvoiceOrderPage clickViewInvoiceLink() {
        invoicePageLink.click();
        return new InvoiceOrderPage();
    }


}
