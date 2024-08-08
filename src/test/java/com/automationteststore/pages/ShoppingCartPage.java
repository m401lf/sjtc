package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import helpers.select.DropDownHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.automationteststore.base.BaseTest.driver;


public class ShoppingCartPage {

    private final Logger log = LogManager.getLogger(ShoppingCartPage.class);
    @FindBy(xpath = "//*[contains(text(),'Your shopping cart is empty')]")
    private WebElement emptyShoppingCartMsg;
    @FindBy(xpath = "//input[@id='estimate_postcode']")
    private WebElement estimatePostcodeBox;
    @FindBy(css = "h1.basePage-title.mb-3.h3") // MyAccount BasePage heading
    private WebElement headerTxt;
    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement errorAlertForDesiredQuantityOrNotInStock;
    @FindBy(xpath = "//td[2]")
    private List<WebElement> productNames;
    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr")
    private List<WebElement> products;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]")
    private List<WebElement> productList;
    @FindBy(xpath = "//*[@id='cart']/div/div/table/tbody/tr/td[1]")
    private List<WebElement> productImages;
    @FindBy(xpath = "//*[@id='cart']/div/div/table/tbody/tr/td[3]")
    private List<WebElement> productModels;
    @FindBy(css = "div.input-group.input-group-sm")
    private List<WebElement> quantityBox;
    @FindBy(css = "#cart_update")
    private WebElement updateButton;
    @FindBy(css = "i.fa.fa-trash-o.fa-fw")
    private List<WebElement> removeItems;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[1]")
    private List<WebElement> product_Images;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]")
    private List<WebElement> product_Names;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[3]")
    private List<WebElement> product_Models;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[4]")
    private List<WebElement> product_Quantities;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[5]")
    private List<WebElement> product_Prices;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[6]")
    private List<WebElement> product_TotalPrices;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[7]")
    private List<WebElement> product_RemoveButtons;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td")
    private List<WebElement> allTds_Tr;
    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[6]")
    private List<WebElement> totalPrices;
    @FindBy(xpath = "//table/tbody/tr/td[6]")
    private List<WebElement> unitPrices;
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
    private WebElement FlatRateShipmentsDropdown;

    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;

    @FindBy(id = "cart_quantity50")
    private WebElement quantity;

    @FindBy(id = "cart_update")
    private WebElement updateBtn;

    @FindBy(css = ".mb20.pull-right > a[title='Checkout']")
    private WebElement checkoutBtn;

    private static String getProductModelNumbers(WebElement p) {
        return p.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    private static String getProductQuantity(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[3]")).getText();
    }

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

    }

    public void clickOnEstimateCalculatorBtn() {
        estimateCalculatorBtn.click();

    }

    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        new DropDownHelper(driver).selectUsingVisibleText(FlatRateShipmentsDropdown, flatRateShipment);
    }

    public void updateQuantityOfProductInTheCart(String productName, int qty) throws InterruptedException {
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getText().equalsIgnoreCase(productName)) {
                productList.get(i).findElement(By.xpath("following-sibling::td[3]//div//input")).clear();
                productList.get(i).findElement(By.xpath("following-sibling::td[3]//div//input")).sendKeys(String.valueOf(qty));
                break;
            }
        }

    }

    public Boolean VerifyOrderDisplay(String productName) {
        Boolean match = product_Names.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;

    }


/*    public String getModelOfProductInTheCart(String productName) {
        String productModel = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        for (WebElement element : productList) {
            if (element.getText().contains(productName)) {
                productModel = element.findElement(By.xpath("following-sibling::td[1]")).getText().trim();

            }
        }
        return productModel;
    }*/

    public String assertProductNameAndModelOfProductInTheCart(String productName) {
        String productModel = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getText().equalsIgnoreCase(productName)) {
                productList.get(i).findElement(By.xpath("following-sibling::td[5]")).click();
                break;
            }
        }
        return productModel;

    }

    public String getUnitPriceOfProductInTheCart(String productName) {
        String unitPerPrice = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getText().trim().equalsIgnoreCase(productName.trim())) {
                unitPerPrice = productList.get(i).findElement(By.xpath("following-sibling::td[2]")).getText();
                break;
            }
        }
        return unitPerPrice;
    }

    public String getTotalPriceOfProductInTheCart(String productName) {
        String totalPrice = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for (WebElement element : productList) {
            if (element.getText().equalsIgnoreCase(productName)) {
                totalPrice = element.findElement(By.xpath("following-sibling::td[4]")).getText();
                break;
            }
        }
        return totalPrice;
    }

    public String getNameOfProductsInTheCart(String productName) {
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        return productList
                .stream()
                .parallel()
                .map(WebElement::getText)
                .filter(text -> text.equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public void removeProductFromCart(String productName) {
        List<WebElement> products =
                productList.stream()
                        .parallel()
                        .filter(p -> p.getText().equalsIgnoreCase(productName))
                        .collect(Collectors.toList());
        if (products.size() > 0) {
            products.stream().parallel().findFirst().ifPresent(product -> product.findElement(By.xpath("following-sibling::td[5]")).click());
        }
    }

    public void clickOnUpdateButton() {
        updateBtn.click();

    }

    public LoginPage clickOnCheckoutButton() {
        checkoutBtn.click();
        return new LoginPage();
    }

    public void inputItemQuantity(int number) {
        quantity.clear();
        quantity.sendKeys(String.valueOf(number));

    }

    public String getUpdateButtonText() {
        return new VerificationHelper(driver).getText(updateBtn);

    }

    public String getCheckoutButtonText() {
        return new VerificationHelper(driver).getText(checkoutBtn);

    }

    public boolean assertEmptyShoppingCartMessage() {
        return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);
    }

    public List<String> getQuantityOfProductInTheCart(String productName) {

        return product_Names
                .stream()
                .parallel()
                .filter(s -> s.getText().contains(productName))
                .map(s -> getProductQuantity(s)).collect(Collectors.toList());
        //.forEach(a->System.out.println(a));
    }

    public String getProductName(String prodName) {
        WebElement name = driver.findElement(By.xpath("//td[@class='align_left']//a[contains(text(),'" + prodName + "')]"));
        return new VerificationHelper(driver).getText(name);

    }

    public String getProductTotalPrice(String prodName) {
        WebElement prod = productList.stream()
                .parallel()
                .filter(p -> p.getText().equalsIgnoreCase(prodName))
                .findFirst()
                .orElse(null);
        return prod.findElement(By.xpath("following-sibling::td[2]")).getText().trim();
    }

//    public void getProductModelNumberInTheCart(String productName) {
//        List<String> productModel = product_Names
//                .stream()
//                .parallel()
//                .filter(s -> s.getText().contains(productName))
//                .map(ShoppingCartPage::getProductModelNumber).toList();
//        productModel.forEach(System.out::println);
//    }
//
//
//
//    private static String getProductModelNumber(WebElement s) {
//        return s.findElement(By.xpath("following-sibling::td[2]")).getText();
//    }


}
