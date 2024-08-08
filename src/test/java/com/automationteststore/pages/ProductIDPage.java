package com.automationteststore.pages;


import com.automationteststore.base.BasePage;
import helpers.assertion.VerificationHelper;
import helpers.javaScript.JavaScriptHelper;
import helpers.select.DropDownHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.automationteststore.base.BaseTest.driver;

public class ProductIDPage {
    private final static Logger log = LogManager.getLogger(ProductIDPage.class);
    BasePage basePage;
    @FindBy(css = ".bgnone")
    private List<WebElement> productname;
    @FindBy(css = "[class='col-md-6 text-center'] div:nth-child(2) [src]")
    private List<WebElement> productEasyZoom;

    @FindBy(css = "[class='productname']")
    private List<WebElement> productnames;
    @FindBy(css = "div.productfilneprice")
    private WebElement unitprice;

    @FindBy(css = ".input-group-addon")
    private WebElement qtyLabel;

    @FindBy(css = "span.total-price")
    private WebElement totalPrice;

    @FindBy(css = ".cart")
    private WebElement add2Cart;

    @FindBy(id = "option350")
    private WebElement colorDropdown;

    @FindBy(xpath = "//select[@id='option350']")
    private WebElement colorDrops;

    @FindBy(id = "option351")
    private WebElement sizeDropdown;

    @FindBy(id = "product_quantity")
    private WebElement product_quantity;


    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[1]/div/label")
    private List<WebElement> colorRadioButtonList;

    @FindBy(css = ".total-price-holder .control-label")
    private WebElement total_price_holder_label;

    @FindBy(css = ".productprint.btn.btn-large")
    private WebElement productPrint;

    @FindBy(css = ".wishlist_add.btn.btn-large")
    private WebElement addToWishlist;

    @FindBy(css = "a[href='#a[href='#description']']")
    private WebElement productDescription;

    @FindBy(css = "a[href='#review']")
    private WebElement productReview;

    @FindBy(css = "a[href='#relatedproducts']")
    private WebElement relatedProducts;

    @FindBy(css = ".btn.btn-large.productprint")
    private WebElement productprint;

    @FindBy(css = ".thumbnails.mainimage.smallimage")
    private WebElement thumbnailsImage;

    @FindBy(css = "div[class='tab-content'] li:nth-child(1)")
    private WebElement descriptionProductModel;

    @FindBy(css = ".productinfo li:nth-of-type(1)")
    private WebElement descriptionProductManufacturerLogo;

    @FindBy(css = "#option316")
    private WebElement sideDropdown;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[1]/div/select/option")
    private List<WebElement> sizeDropdownList;

    @FindBy(css = "div[id='review_title'] h4")
    private WebElement reviewTitle;

    @FindBy(css = ".control-label.col-md-3.pull-left")
    private WebElement reviewRatingHeader;

    @FindBy(css = "li.on")
    private List<WebElement> reviewRatingList;

    @FindBy(css = "#text")
    private WebElement reviewTextBox;

    @FindBy(css = ".control-label.col-md-3.pull-left")
    private WebElement reviewNoteWarning;

    @FindBy(css = "#captcha_img")
    private WebElement reviewNCaptchaImage;

    @FindBy(css = "captcha")
    private WebElement reviewCaptchaBox;

    @FindBy(css = "#review_submit")
    private WebElement reviewSubmitBtn;


    public List<WebElement> getProductEasyZoom() {
        return productEasyZoom;

    }

    public List<WebElement> getProductnames() {
        return productnames;

    }

    public String getUnitpriceTxt() {

        return new VerificationHelper(driver).getText(unitprice);
    }

    public WebElement product_quantity() {
        return product_quantity;

    }

    public void inputProduct_quantity(String qty) {
        product_quantity.sendKeys(qty);

    }

    public WebElement add2Cart() {
        return add2Cart;

    }

    public ShoppingCartPage clickOnAdd2Cart() {
        add2Cart.click();
        return new ShoppingCartPage();
    }

    public WebElement getTotalPrice() {
        return totalPrice;

    }

    public WebElement getAdd2Cart() {
        return add2Cart;

    }

    public WebElement getProduct_quantity() {
        return product_quantity;

    }

    public List<WebElement> getColorRadioButtonList() {
        return colorRadioButtonList;

    }

    public WebElement getTotal_price_holder_label() {
        return total_price_holder_label;

    }

    public WebElement getProductPrint() {
        return productPrint;

    }

    public WebElement getAddToWishlist() {
        return addToWishlist;

    }

    public WebElement getProductDescription() {
        return productDescription;

    }

    public WebElement getProductReview() {
        return productReview;

    }

    public WebElement getRelatedProducts() {
        return relatedProducts;

    }

    public WebElement getProductprint() {
        return productprint;

    }

    public WebElement getThumbnailsImage() {
        return thumbnailsImage;

    }

    public WebElement getDescriptionProductModel() {
        return descriptionProductModel;

    }

    public WebElement getDescriptionProductManufacturerLogo() {
        return descriptionProductManufacturerLogo;

    }

    public List<WebElement> getProductname() {
        return productname;

    }

    public WebElement getUnitprice() {
        return unitprice;

    }

    public WebElement getQtyLabel() {
        return qtyLabel;

    }

    public WebElement getSideDropdown() {
        return sideDropdown;

    }

    public List<WebElement> getSizeDropdownList() {
        return sizeDropdownList;

    }

    public WebElement getReviewTitle() {
        return reviewTitle;

    }

    public WebElement getReviewRatingHeader() {
        return reviewRatingHeader;

    }

    public WebElement getReviewTextBox() {
        return reviewTextBox;

    }

    public WebElement getReviewNoteWarning() {
        return reviewNoteWarning;

    }

    public WebElement getReviewCaptchaBox() {
        return reviewCaptchaBox;

    }

    public WebElement getReviewSubmitBtn() {
        return reviewSubmitBtn;

    }

    public WebElement getReviewNCaptchaImage() {
        return reviewNCaptchaImage;

    }

    public void selectColor(String color) {
        new JavaScriptHelper(driver).scrollToElementAndClick(colorDrops);
        //new DropDownHelper(driver).selectUsingVisibleText(colorDrops, color.trim());
        new DropDownHelper(driver).selectUsingIndex(colorDrops, 1);

    }

    public void enterQuantity(String qty) {
        product_quantity.clear();
        product_quantity.sendKeys(qty);

    }

    public void selectSize(String size) {
        new DropDownHelper(driver).selectUsingVisibleText(sizeDropdown, size);

    }

    public ShoppingCartPage clickAdd2Cart() {
        add2Cart.click();
        return new ShoppingCartPage();
    }

    public List<WebElement> getReviewRatingList() {
        return reviewRatingList;

    }


}
