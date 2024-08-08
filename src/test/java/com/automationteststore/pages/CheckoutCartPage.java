package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import helpers.select.DropDownHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.automationteststore.base.BaseTest.driver;

public class CheckoutCartPage {

    private final Logger log = LogManager.getLogger(CheckoutCartPage.class);
    @FindBy(xpath = "//input[@id='estimate_postcode']")
    private WebElement estimatePostcodeBox;
    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr")
    private List<WebElement> products;
    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> itemNames;
    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> productNames;
    @FindBy(xpath = "//div[@innertext='Your shopping cart is empty!']")
    private WebElement cart_empty;
    @FindBy(xpath = "//input[@id='coupon_coupon']")
    private WebElement couponBox;
    @FindBy(css = "#apply_coupon_btn")
    private WebElement applyCouponBtn;
    @FindBy(css = "#estimate_country")
    private WebElement estimateCountryDropdown;
    @FindBy(css = "#estimate_country_zones")
    private WebElement countryZonesDropdown;
    @FindBy(xpath = "//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    private WebElement estimateCalculatorBtn;
    @FindBy(xpath = "//select[@id='shippings']")
    private WebElement flatRateShipmentsDropdown;
    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[5]/div/input")
    private WebElement quantity;
    @FindBy(id = "cart_update")
    private WebElement updateBtn;
    @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    private WebElement continueShippingBtn;
    @FindBy(css = ".mb20.pull-right > a[title='Checkout']")
    private WebElement checkoutBtn;
    @FindBy(css = "a[title='Continue']")
    private WebElement ContinueBtn;


    private static double getUnitPrice(WebElement s) {
        String unitPz = s.findElement(By.xpath("following-sibling::td[2]")).getText().trim();
        String unitPz2 = unitPz.replace("$", "").replace(" ", "");
        double unitPz3 = Double.parseDouble(unitPz2);
        if (unitPz3 < 1000.0 || unitPz3 > 00.0) {
            System.out.println("UnitPrice: " + unitPz3);
            System.out.println("---------------------");
        }
        return unitPz3;


    }

    private static double getTotalPrice(WebElement s) {
        String totalPz = s.findElement(By.xpath("following-sibling::td[4]")).getText().trim();
        String totalPz2 = totalPz.replace("$", "").replace(" ", "");
        double totalPz3 = Double.parseDouble(totalPz2);
        if (totalPz3 < 1000.0 || totalPz3 > 00.0) {
            System.out.println("TotalPrice: " + totalPz3);
            System.out.println("-------------------------");
        }
        return totalPz3;
    }

    public void assertProductNameAndUnitPriceIsDisplayed(String productname) {
        List<Double> unitPrice = itemNames
                .stream()
                .parallel()
                .filter(s -> s.getText().contains(productname))
                .map(CheckoutCartPage::getUnitPrice).collect(Collectors.toList());
        unitPrice.forEach(System.out::println);

    }

    public void assertProductNameAndTotalPriceIsDisplayed(String productName) {
        List<Double> totalPrice = productNames
                .stream()
                .parallel()
                .filter(s -> s.getText().contains(productName))
                .map(s -> getTotalPrice(s)).collect(Collectors.toList());
        totalPrice.forEach(System.out::println);

    }

    public void increaseOrDecreaseQuantityOfItemsInTheCart(String productInCart, int qty) {
        // //tr/td[2]/following-sibling::td[3]/div/input
        for (int i = 1; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().contains(productInCart)) {
                WebElement element = itemNames.get(i).findElement(By.xpath("following-sibling::td[3]/div/input"));
                element.clear();
                element.sendKeys(String.valueOf(qty));
            }
        }

    }

    public void removeItemFromShippingCart(String productname) {
        // //tr/td[2]/following-sibling::td[5]/a
        for (int i = 1; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().contains(productname)) {
                WebElement element = itemNames.get(i).findElement(By.xpath("following-sibling::td[5]/a"));
                element.click();
            }
        }

    }


    //==============================================

    public void EnterCouponNumberOnCouponBox(String CouponNumber) {
        couponBox.sendKeys(CouponNumber);

    }

    public void clickOnApplyCouponBtn() {
        applyCouponBtn.click();

    }

    public void selectEstimateCountryDropdown(String countryName) {
        new DropDownHelper(driver).selectUsingVisibleText(estimateCountryDropdown, countryName);


    }

    public void selectCountryZonesDropdown(String countryZonesName) {
        new DropDownHelper(driver).selectUsingVisibleText(countryZonesDropdown, countryZonesName);

    }

    public void enterOnEstimatePostcodeBox(String postCode) {
        estimatePostcodeBox.sendKeys(postCode);
        new DropDownHelper(driver).selectUsingVisibleText(estimatePostcodeBox, postCode);


    }

    public void clickOnEstimateCalculatorBtn() {
        estimateCalculatorBtn.click();

    }

    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        new DropDownHelper(driver).selectUsingVisibleText(flatRateShipmentsDropdown, flatRateShipment);
    }

    public WebElement removeIconBtn() {
        return removeItemBtn;

    }

    public void clickOnRemoveIconButton() {
        removeItemBtn.click();

    }

    public void clickOnUpdateButton() {
        updateBtn.click();

    }

    public HomePage clickOnContinueShippingButton() {
        continueShippingBtn.click();
        return new HomePage();
    }

    public LoginPage clickOnCheckoutButton() {
        checkoutBtn.click();
        return new LoginPage();
    }

    public boolean continueContinueShoppingButtonIdDisplayed() {
        return new VerificationHelper(driver).isDisplayedAndEnabled(ContinueBtn);

    }

    public HomePage clickContinueShoppingButton() throws IOException {
        ContinueBtn.click();
        return new HomePage();
    }

    public void tapContinueBtn() {
        ContinueBtn.click();

    }
}