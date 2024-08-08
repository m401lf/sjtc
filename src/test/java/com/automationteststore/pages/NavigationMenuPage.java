package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import enums.WaitStrategy;
import helpers.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.utils.DynamicXpathUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.automationteststore.base.BaseTest.driver;


public class NavigationMenuPage{
    private final static Logger log = LogManager.getLogger(NavigationMenuPage.class);
    BasePage basePage;

    private final String productCategories = "//a[text()='%s']";

    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li/a")
    private List<WebElement> categories;
    @FindBy(xpath = "/html/body/div/div/div/section/nav/ul/li/div/ul/li")
    private List<WebElement> subCategoriesDropdownList;
    @FindBy(css = ".active.menu_home")
    private WebElement homeDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[2]/a")
    private WebElement apparelAccessoriesDropdownButton;
    @FindBy(xpath = "//*[@id=   nk-=-0721q  a'categorymenu']/nav/ul/li[3]/a")
    private WebElement makeupDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[4]/a")
    private WebElement skincareDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[5]/a")
    private WebElement fragranceDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[6]/a")
    private WebElement menDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[7]/a")
    private WebElement hairCareDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[8]/a")
    private WebElement booksDropdownButton;

    public ProductCategoryPage clickOnCategoryMenuItem(String categories, String itemName) {
        String newXpath = DynamicXpathUtils.getXpath(productCategories, categories);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.click(By.xpath(newXpath), WaitStrategy.CLICKABLE);
        if(categories.contains(itemName)) {
            log.info("Click on an item product category :: " + itemName);
            return new ProductCategoryPage();
        }
        return null;
    }

    public List<WebElement> getCategories() {
        return categories;

    }


    public ProductCategoryPage hoverOverCategoryAndClickItemFromDropdownList(String category, String item) throws IOException {
        List<WebElement>
                elements = getCategories()
                .stream()
                .parallel()
                .filter(cat -> cat.getText().contains(category)).collect(Collectors.toList());
        WebElement desiredCategory =
                elements.stream()
                        .parallel()
                        .filter(cat -> cat.getText().contains(category))
                        .findFirst()
                        .orElse(null);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitForWebElementToAppear(desiredCategory);
        log.info("Hover over the product category :: " + category);
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + item + "')]"));
        new JavaScriptHelper(driver).scrollToElementAndClick(ele);
        log.info("Click on an item product category dropdown :: " + item);
        return new ProductCategoryPage();
    }


    public List<WebElement> getSubCategoriesDropdownList() {
        return subCategoriesDropdownList;

    }

    public WebElement getHomeDropdownButton() {
        return homeDropdownButton;

    }

    public WebElement getApparelAccessoriesDropdownButton() {
        return apparelAccessoriesDropdownButton;

    }

    public WebElement getMakeupDropdownButton() {
        return makeupDropdownButton;

    }

    public WebElement getSkincareDropdownButton() {
        return skincareDropdownButton;

    }

    public WebElement getFragranceDropdownButton() {
        return fragranceDropdownButton;

    }

    public WebElement getMenDropdownButton() {
        return menDropdownButton;

    }

    public WebElement getHairCareDropdownButton() {
        return hairCareDropdownButton;

    }

    public WebElement getBooksDropdownButton() {
        return booksDropdownButton;

    }


}