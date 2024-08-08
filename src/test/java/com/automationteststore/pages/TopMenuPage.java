package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;
import helpers.assertion.VerificationHelper;
import helpers.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class TopMenuPage {
    private final Logger log = LogManager.getLogger(TopMenuPage.class);
    BasePage basePage;
    String URL = "https://automationteststore.com/";
    By addToCart = By.cssSelector("i.fa.fa-cart-plus.fa-fw");
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
    private List<WebElement> allPageBreadCrumbList;
    @FindBy(xpath = "/html/body/div/header/div[1]/div/div[2]/div/div/div/ul/li/a")
    private List<WebElement> topMenuList;
    @FindBy(linkText = "Login or register")
    WebElement loginOrRegisterLink;

    @FindBy(xpath = "(//span[text()='Specials'])[1]")
    private WebElement specialsLink;

    @FindBy(xpath = "//*[@id='main_menu_top']/li[2]/a/span")
    private WebElement accountLink;
    @FindBy(xpath = "//span[normalize-space()='3']")
    private WebElement itemCount;

    @FindBy(xpath = "(//span[text()='Login'])[1]")
    private WebElement loginOption;


    @FindBy(xpath = "(//span[text()='Check Your Order'])[1]")
    private WebElement checkYourOrderOption;

    @FindBy(xpath = "/html/body/div/header/div[1]/div/div[2]/div/div[3]/div/ul/li[2]/ul/li")
    private List<WebElement> accountOptionList;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    private WebElement account_link;

    @FindBy(css = "ul[class='nav topcart pull-left'] li[class='dropdown hover']")
    private WebElement itemsLink;

    @FindBy(css = "span.cart_total")
    private WebElement cartTotalAmount;

    @FindBy(xpath = "//span[normalize-space()='1']")
    private WebElement noOfItemCount;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li/ul/li/div[2]/div/a")
    private List<WebElement> itemsCartDropdownButtonsList;

    @FindBy(css = "a[title='View Cart']")
    private WebElement viewCartIcon;

    @FindBy(css = ".fa.fa-money.fa-fw")
    private WebElement checkoutIcon;

    @FindBy(xpath = "(//span[text()='Logout'])[1]")
    private WebElement logoutOption;

    @FindBy(xpath = "//div[contains(text(),'Welcome back')]")
    private WebElement welcomeBackTxt;

    @FindBy(css = ".fa.fa-search")
    private WebElement searchButton;

    @FindBy(css = "[placeholder='Search Keywords']")
    private WebElement searchWidget;
    @FindBy(css = "#filter_keyword")
    private WebElement searchBox;
    @FindBy(css = "li.search-category")
    private List<WebElement> autoSuggestionDropdownList;
    @FindBy(xpath = "//body[1]/div[1]/header[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")
    private WebElement currencyDropdown;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li")
    private WebElement itemsCartDropdown;

    @FindBy(css = "span.cart_block_total")
    private List<WebElement> itemsCartTotalLabelAndPriceList;

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement accountIconImage;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    private WebElement accountStatusTxt;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
    private List<WebElement> breadcrumbsList;

    @FindBy(xpath = "//ul[@id='customer_menu_top']//div[@class='menu_text']")
    private WebElement userProfileDropdown;

    @FindBy(xpath = "/html/body/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li/ul/li/a")
    private List<WebElement> userProfileDropdownList;

    @FindBy(xpath = "/html/body/div/header/div/div/div/ul/li/ul/li/div/div/table/tbody/tr/td[2]")
    private List<WebElement> itemsProductnames;


    public By getAddToCart() {
        return addToCart;

    }

    public List<WebElement> getTopMenuList() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(s -> topMenuList.size() == 4);
        return topMenuList;
    }

    public boolean getTopMenuItemsList(String menuName) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until((s) -> topMenuList.size() == 5);
        return topMenuList.stream().parallel().anyMatch(s -> s.getText().contains(menuName));

    }

    public void navigateToHomePage() {
        driver.get(GlobalVars.getHomePageUrl());


    }

    public LoginPage clickOnLoginOrRegisterLink() {
        loginOrRegisterLink.click();
        return new LoginPage();
    }

    public LoginPage navigateToLoginPage() {
        loginOrRegisterLink.click();
        return new LoginPage();
    }

    public boolean assertLoginOrRegisterLinkIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(loginOrRegisterLink);
    }

    public String getLoginOrRegisterLink() {
        return new VerificationHelper(driver).getText(loginOrRegisterLink);

    }

    public CheckoutCartPage clickOnViewCartLink() throws IOException {
        viewCartIcon.click();
        return new CheckoutCartPage();
    }

    public LoginPage clickCheckoutIcon() {
        checkoutIcon.click();
        return new LoginPage();
    }

    public CheckoutConfirmationPage clickOnCheckoutButton() {
        checkoutIcon.click();
        return new CheckoutConfirmationPage();
    }

    public boolean assertProductsAreDisplayed() {
        return itemsProductnames.stream().parallel().filter(WebElement::isDisplayed).count() == itemsProductnames.size();

    }

    public boolean assertProductNamesAreDisplayed() {
        boolean status = false;
        int size = itemsProductnames.size();
        for (int i = 0; i < size; i++) {
            if (new VerificationHelper(driver).isDisplayed(itemsProductnames.get(i))) {
                status = true;
                break;
            }
        }
        return status;
    }


    public RegisterPage navigateToRegisterPage() {
        driver.get("https://automationteststore.com/index.php?rt=account/create");
        return new RegisterPage();
    }

    public WebElement getItemsLink() {
        return itemsLink;

    }

    public boolean assertItemsLinkIsDisplayed() {
        return itemsLink.isDisplayed();

    }

    public WebElement getItemCount() {
        return itemCount;

    }

    public String getItemCountText() {
        return itemCount.getText();

    }

    public boolean assertItemCountTextIsDisplayed() {
        return itemCount.isDisplayed();

    }

    public void mouseOverItemLink() {
        Actions action = new Actions(driver);
        action.moveToElement(itemsLink).build().perform();
        action.moveToElement(checkoutIcon).click().build().perform();

    }

    public ShoppingCartPage mouseOverAndClickOnItemsLink() {
        new JavaScriptHelper(driver).scrollToElementAndClick(itemsLink);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return new ShoppingCartPage();
    }


    public CheckoutPage mouseOverItemsCartLinkAndClickCheckoutIcon() {
        Actions action = new Actions(driver);
        BasePage.isActivePage();
        action.moveToElement(itemsLink).build().perform();
        checkoutIcon.click();
        return new CheckoutPage();
    }

    public ShoppingCartPage mouseOverItemsCartLinkAndClickViewCartIcon() {
        Actions action = new Actions(driver);
        action.moveToElement(itemsLink).build().perform();
        basePage = PageFactory.initElements(driver, BasePage.class);
        viewCartIcon.click();
        return new ShoppingCartPage();
    }

    public String getCartTotalAmountText() {
        return new VerificationHelper(driver).getText(cartTotalAmount);

    }

    public boolean assertCartTotalAmountIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(cartTotalAmount);

    }

    public String getCartTotalQuantityText() {
        return new VerificationHelper(driver).getText(noOfItemCount);

    }

    public boolean assertNoOfItemCountIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(noOfItemCount);

    }


    public List<WebElement> getItemsCartDropdownButtonsList() {
        return itemsCartDropdownButtonsList;

    }

    public LoginPage clickCheckoutCartDropdownIconButton() throws IOException {
        itemsCartDropdownButtonsList.get(1).click();
        return new LoginPage();
    }

    public ShoppingCartPage clickViewCartDropdownIconButton() {
        viewCartIcon.click();
        return new ShoppingCartPage();
    }

    public boolean assertTopMenuItemsListArePresent(String menuItem) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(d -> topMenuList.size() > 3);
        try {
            for (int i = 0; i < topMenuList.size(); i++) {
                if (topMenuList.get(i).isDisplayed()) {
                    log.info("Index " + i + " :: " + "Element is Present: " + topMenuList.get(i).getText());
                }
            }
        } catch (Exception e) {
            log.error("Fail: Element is Not Present");
        }
        return topMenuList.stream().anyMatch(s -> s.isDisplayed() && s.getText().contains(menuItem));
    }

    public WebElement getLogoutOption() {
        return logoutOption;
    }

    public String getWelcomeBackMessage() {
        return new VerificationHelper(driver).getText(welcomeBackTxt);
    }

    public WebElement getCurrencyDropdown() {
        return currencyDropdown;
    }

    public WebElement getItemsCartDropdown() {
        return itemsCartDropdown;
    }

    public List<WebElement> getItemsCartTotalLabelAndPriceList() {
        return itemsCartTotalLabelAndPriceList;
    }

    public WebElement getAccountIconImage() {
        return accountIconImage;
    }

    public WebElement getAccountStatusTxt() {
        return accountStatusTxt;
    }

    public List<WebElement> getBreadcrumbsList() {
        return breadcrumbsList;
    }

    public WebElement getUserProfileDropdown() {
        return userProfileDropdown;
    }

    public List<WebElement> getUserProfileDropdownList() {
        return userProfileDropdownList;
    }

    public List<WebElement> getItemsProductnames() {
        return itemsProductnames;
    }

    public void assertAutoSuggestionDropdownListAreDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(d -> autoSuggestionDropdownList.size() > 0);
        for (int i = 0; i < autoSuggestionDropdownList.size(); i++) {
            if (autoSuggestionDropdownList.get(i).isDisplayed()) {
                log.info("Index " + i + " :: " + "Element is Present: " + autoSuggestionDropdownList.get(i).getText());
            }
        }


    }

    public boolean assertSearchBoxIsDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(d -> searchBox.isDisplayed());
    }

    public void clickSearch() {
        searchButton.click();

    }

    public void assertTopMenuPageContent() {

    }

    public SearchResultPage navigateToSearchResultPage() {
        searchButton.click();
        return new SearchResultPage();
    }

    public void assertForSearchButton(String searchButton) {

    }

    public void assertSearchColor() {

    }

    public void assertClearFilterBgColor() {
    }

    public void searchForProduct(String searchKeyword) {
        System.out.println("searching .." + searchKeyword);
        searchBox.sendKeys(searchKeyword);
        searchButton.click();
    }


    public LoginPage clickOnMatchingTextFromTopMenuLinks(String loginOrRegisterLink) {
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.clickAnyMatchingElementByText(topMenuList, loginOrRegisterLink);
        return new LoginPage();
    }

}