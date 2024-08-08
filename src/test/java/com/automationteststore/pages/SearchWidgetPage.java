package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class SearchWidgetPage {
    private final static Logger log = LogManager.getLogger(SearchWidgetPage.class);
    BasePage basePage;
    @FindBy(id = "filter_keyword")
    private WebElement searchBox;

    @FindBy(css = ".fa.fa-search")
    private WebElement searchButton;

    @FindBy(css = ".search-category")
    private List<WebElement> searchCategoryList;

    public void enterSearchKeyword(String SearchKeyword) {
        searchBox.clear();
        searchBox.sendKeys(SearchKeyword);
        log.info("Entering search");
    }

    public SearchResultPage clickSearchButton() throws IOException {
        searchButton.click();
        log.info("Clicked search button");
        return new SearchResultPage();
    }

    public SearchResultPage searchWithValidSearchKeyword(String validProductSearchKeyword) throws IOException {
        enterSearchKeyword(validProductSearchKeyword);
        searchButton.click();
        return new SearchResultPage();

    }

    public SearchResultPage SearchWithInvalidKeyword(String invalidKeyword) throws IOException {
        enterSearchKeyword(invalidKeyword);
        searchButton.click();
        return new SearchResultPage();
    }

    public List<WebElement> getSearchCategoryList() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(searchCategoryList));
    }

    public void clickItemFromSearchCategoryList(String categoryName) {
        searchBox.click();
        WebElement categoryItem = getSearchCategoryList()
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElse(null);
        categoryItem.click();
        log.info(categoryItem.getText());
    }

}


