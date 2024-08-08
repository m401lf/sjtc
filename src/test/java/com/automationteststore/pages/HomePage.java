package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class HomePage{
    private final static Logger log = LogManager.getLogger(LoginPage.class);

    private  String linkSubMenu = "//a[text()='%s']";
    private  String linkSubMenu2 = "//div[text()='%s']/parent::a[text()='%s']";

    By addToCart = By.cssSelector("[title='Add to Cart']");
    @FindBy(css = ".welcome_msg h4")
    private WebElement welcome_msg;
    @FindBy(xpath = "///h2[@innertext='Fast shipping']")
    private WebElement fastShipping;
    @FindBy(xpath = "///h2[@innertext='Easy Payments']")
    private WebElement easyPayments;
    @FindBy(xpath = "///h2[@innertext='Shipping Options']")
    private WebElement shippingOptions;
    @FindBy(xpath = "///h2[@innertext='Large Variety']")
    private WebElement largeVariety;
    @FindBy(xpath = "span.maintext")
    private List<WebElement> headingLists;
    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    private List<WebElement> allProductsList;
    @FindBy(css = ".info_links_footer > li:nth-of-type(5) > a")
    private WebElement contactusLink;

    public String getFastShipping() {
        return fastShipping.getText();

    }

    public String getEasyPayments() {
        return new VerificationHelper(driver).getText(easyPayments);

    }

    public String getShippingOptions() {
        return new VerificationHelper(driver).getText(shippingOptions);

    }

    public String getLargeVarietyLargeVariety() {
        return new VerificationHelper(driver).getText(largeVariety);

    }

    public List<WebElement> getHeadingLists() {
        return headingLists;

    }

    public List<WebElement> getProductList() {
        return allProductsList;

    }

    public void addProductsToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
    }

    public WebElement getProductByName(String productName) {
        return allProductsList
                .stream()
                .parallel()
                .filter(product -> product.findElement(By.cssSelector("a.prdocutname")).getText().contains(productName))
                .findFirst()
                .orElse(null);

    }


    public HomePage addProductToCart(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));
        WebElement prod = products
                .stream()
                .parallel()
                .filter(product -> product.findElement(By.cssSelector("a")).getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
        assert prod!= null;
        prod.findElement(By.cssSelector("a.productcart")).click();
        log.info("Product " + productName + " added to cart");
        return this;
    }


    public String getWelcomeMessage() {
        return new VerificationHelper(driver).getText(welcome_msg);

    }

    public boolean assertWelcomeMessage() {
        return new VerificationHelper(driver).isDisplayed(welcome_msg);

    }

}
