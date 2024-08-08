package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import helpers.assertion.VerificationHelper;
import helpers.select.DropDownHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


import static com.automationteststore.base.BaseTest.driver;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SearchResultPage {
    private final static Logger log = LogManager.getLogger(SearchResultPage.class);
    BasePage basePage;
    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    private List<WebElement> searchResultFound;
    @FindBy(css = ".prdocutname")
    private List<WebElement> productTitleList;
    @FindBy(id = "keyword")
    private WebElement searchBox;

    @FindBy(css = "#keyword")
    private WebElement searchCriteriaAttributeValue;

    @FindBy(xpath = "//select[@id='category_id']")
    private WebElement allCategoriesDropdown;

    @FindBy(id = "/html/body/div/div[2]/div/div/div/div/div[1]/fieldset/div[2]/div/select/option")
    private List<WebElement> allSubCategoriesDropdownList;

    @FindBy(css = "label[for='description']")
    private WebElement searchProductDescriptionsRadioButton;

    @FindBy(css = "label[for='model']")
    private WebElement searchProductModelRadioButton;

    @FindBy(css = "label[for='price']")
    private WebElement searchProductPriceRadioButton;

    @FindBy(css = "#search_button")
    private WebElement searchButton;

    @FindBy(css = "label[for='viewed']")
    private WebElement searchProductViewedRadioButton;

    @FindBy(xpath = "//h4[normalize-space()='Search Criteria']")
    private WebElement SearchCriteriaText;

    @FindBy(xpath = "//h4[normalize-space()='Products meeting the search criteria']")
    private WebElement productsMeetingSearchCriteriaText;

    @FindBy(css = "label[for='model']")
    private WebElement searchProductModelRadioButtonLabel;
    @FindBy(xpath = "//div[contains(text(),'There is no product that matches the search criter')]")
    private WebElement noSearchResultFoundText;
    @FindBy(css = "option[value='date_modified-ASC']")
    private WebElement dateOldNew;
    @FindBy(css = ".fa.fa-th-list.icon-white")
    private WebElement listIconWhiteIcon;
    @FindBy(css = ".fa.fa-th")
    private WebElement listGridIcon;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[1]/form/select/option")
    private List<WebElement> sortByDropdownList;
    @FindBy(id = "sort")
    private WebElement sortByDropdown;
    @FindBy(css = "select#limit")
    private WebElement perPageDropdown;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[5]/form/select/option")
    private List<WebElement> perPageDropdownList;
    @FindBy(xpath = "i.fa.fa-cart-plus.fa-fw")
    private List<WebElement> addToCartButtonList;
    @FindBy(xpath = "(//a[@title='Add to Cart'])")
    private WebElement addToCartButton;
    @FindBy(css = "span.nostock")
    private List<WebElement> outOfStockButtons;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div/div/div/div/div/div")
    private List<WebElement> onePriceList;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/form[1]")
    private WebElement perPageSearchResultCount;


    public void clickPerPageDropdown() {
        perPageDropdown.click();

    }

    public List<WebElement> perPageDropdownList() {
        return perPageDropdownList;

    }

    public void addToCart() {
        addToCartButton.click();
        log.info("Product added to cart successfully");
    }

    public boolean isProductExist(String productName) {
        boolean flag = false;
        for (WebElement product : searchResultFound) {
            if (product.getAttribute("title").equals(productName)) {
                flag = true;
                break;
            }
        }

        return flag;

    }

    public void selectProduct(String productName) {
        for (WebElement product : searchResultFound) {
            if (product.getAttribute("title").equals(productName)) {
                product.click();
            }
        }

    }

    public void waitForTheSearchResult() {
        await().atMost(15, MINUTES)
                .pollDelay(5, SECONDS)
                .pollInterval(5, SECONDS)
                .until(() -> {
                    searchButton.click();
                    return searchResultFound.get(0).getText().equalsIgnoreCase("1");
                });
    }

    public WebElement getSearchBox() {
        return searchBox;

    }

    public WebElement getAllCategoriesDropdown() {
        return allCategoriesDropdown;

    }

    public List<WebElement> getAllSubCategoriesDropdownList() {
        return allSubCategoriesDropdownList;

    }

    public void clickSearchProductDescriptionsRadioButton() {
        searchProductDescriptionsRadioButton.click();

    }

    public String getSearchProductDescriptionsRadioButtonLabel() {
        return new VerificationHelper(driver).getText(searchProductDescriptionsRadioButton);

    }

    public void clickSearchProductModelRadioButton() {
        searchProductModelRadioButton.click();

    }


    public void clickSearchProductPriceRadioButton() {
        searchProductPriceRadioButton.click();

    }

    public String getSearchProductPriceRadioButton() {
        return new VerificationHelper(driver).getText(searchProductPriceRadioButton);

    }

    public String getSearchButton() {
        return new VerificationHelper(driver).getText(searchButton);

    }

    public void clickSearchButton() {
        searchButton.click();

    }

    public void clickSearchProductViewedRadioButton() {
        searchProductViewedRadioButton.click();

    }

    public String getSearchProductViewedRadioButtonText() {
        return new VerificationHelper(driver).getText(searchProductViewedRadioButton);

    }

    public String getSearchCriteriaText() {
        return new VerificationHelper(driver).getText(SearchCriteriaText);
    }

    public String getSearchCriteriaAttributeValue() {
        return searchCriteriaAttributeValue.getAttribute("value");

    }

    public boolean assertSearchCriteriaTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(SearchCriteriaText);

    }


    public boolean assertProductsMeetingSearchCriteriaTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(productsMeetingSearchCriteriaText);

    }

    public String getProductsMeetingSearchCriteriaText() {
        return new VerificationHelper(driver).getText(productsMeetingSearchCriteriaText);

    }

    public boolean assertSearchProductModelRadioButtonLabel() {
        return new VerificationHelper(driver).isDisplayed(searchProductModelRadioButtonLabel);

    }

    public String getSearchProductModelRadioButtonLabel() {
        return new VerificationHelper(driver).getText(searchProductModelRadioButtonLabel);

    }


    public void clickListIconWhiteIcon() {
        listIconWhiteIcon.click();

    }

    public boolean assertListIconWhiteIconIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(listIconWhiteIcon);

    }

    public boolean assertListGridIconIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(listGridIcon);

    }

    public void clickListGridIcon() {
        listGridIcon.click();
        log.info("List grid icon clicked successfully");
    }

    public List<WebElement> getSortByDropdownList() {
        return sortByDropdownList;

    }

    public String getSortByDropdownDateOldNewText() {
        return new VerificationHelper(driver).getText(dateOldNew);
    }

    public boolean assertSortByDropdownItemIsSelected() {
        return new VerificationHelper(driver).isSelected(dateOldNew);
    }

    public boolean assertSortByDropdownDefaultItemIsSelected(String dateOldNewText) {
        new DropDownHelper(driver).selectUsingVisibleText(sortByDropdown, dateOldNewText);
        return true;
    }

    public boolean assertSortByDropdownIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(sortByDropdown);

    }

    public void clickSortByDropdownButton() {
        sortByDropdown.click();

    }

    public boolean assertPerPageDropdownIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(perPageDropdown);

    }

    public WebElement getPerPageDropdown() {
        return perPageDropdown;

    }

    public List<WebElement> getPerPageDropdownList() {
        return perPageDropdownList;

    }

    public List<WebElement> getAddToCartButtonList() {
        return addToCartButtonList;

    }

    public boolean assertAddToCartButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(addToCartButton);

    }

    public void clickAddToCartButton() {
        addToCartButton.click();

    }

    public List<WebElement> getOutOfStockButtons() {
        return outOfStockButtons;

    }

    public List<WebElement> getOnePriceList() {
        return onePriceList;

    }

    public void assertProductName(String productTitle) {

    }


    public void assertProductTitle() {


    }

    public String getNoSearchResultFoundText() {
        return new VerificationHelper(driver).getText(noSearchResultFoundText);

    }

    public List<String> getSearchResultProductFound() {
        return productTitleList.stream().parallel().filter(WebElement::isDisplayed).map(WebElement::getText).collect(Collectors.toList());


    }

    public long getSearchResultProductFoundCount() {
        return productTitleList.stream().parallel().filter(WebElement::isDisplayed).count();

    }

    public boolean assertNoSearchResultFoundTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(noSearchResultFoundText);
    }


    public int getProductResultCount() {
        return searchResultFound.size();
    }

    public void selectSortByDropdownItems(String sortBy) {
        new DropDownHelper(driver).selectUsingVisibleText(sortByDropdown, sortBy);

    }

    public void selectItemsFromAllCategories() {
        allCategoriesDropdown.click();
        new DropDownHelper(driver).selectUsingVisibleText(sortByDropdown, "All Categories");
    }

    public void selectSearchCriteriaAllCategoriesByText(String categoryText) {
        new DropDownHelper(driver).selectUsingVisibleText(allCategoriesDropdown, categoryText);
    }

    public String getSearchResultProductFoundCountInPagination() {
        return new VerificationHelper(driver).getText(perPageSearchResultCount);
    }
}


