package com.automationteststore.base;

import com.automationteststore.pages.ProductIDPage;
import com.google.common.util.concurrent.Uninterruptibles;
import enums.WaitStrategy;
import helpers.WebElementOrderCheckerUtil.WebElementOrderChecker;
import helpers.WebElementOrderCheckerUtil.WebElementOrderCheckerImpl;
import helpers.assertion.VerificationHelper;
import helpers.logger.LoggerHelper;
import helpers.navigation.NavigateToNewTab;
import helpers.scroll.ScrollPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.automationteststore.base.BaseTest.driver;

public class BasePage {

    final static Logger log = LoggerHelper.getLogger(BasePage.class);
    private static String PAGE_URL = "https://automationteststore.com/index.php?rt=";
    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    public List<WebElement> allProductsList;
    @FindBy(how = How.CSS, using = ".maintext")
    protected WebElement heading;
    By addToCart = By.cssSelector("[title='Add to Cart']");
    By product_names = By.cssSelector("a.prdocutname");

    @FindBy(css = "a.prdocutname")
    public WebElement productName;

    @FindBy(css = "button[title='Continue']")
    private WebElement continueBtn;
    @FindBy(how = How.CSS, using = "h2[class='heading2'] span")
    private WebElement subHeading;
    @FindBy(css = ".//*")
    private List<WebElement> allPageElements;
    @FindBy(css = "a.navbar-brand")
    private WebElement logo;
    @FindBy(css = "a")
    private WebElement aTag;
    @FindBy(css = "//*[contains(text(),'$')]")
    private List<WebElement> dollarSigns;
    @FindBy(how = How.ID, using = "continue-button")
    private WebElement continueButton;
    @FindBy(how = How.ID, using = "accept-cookies")
    private List<WebElement> acceptCookies;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
    private List<WebElement> allPageBreadCrumbList;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
    private List<WebElement> breadCrumbList;


    public BasePage() {

    }

    public static boolean isActivePage() {
        return driver.getCurrentUrl().contains(PAGE_URL);
    }

    public static List<String> getArrayListOfStringWithCommaSeparated(String fieldNames) {
        List<String> errorIds = new ArrayList<>();
        if (fieldNames.contains(",")) {
            errorIds = Arrays.asList(fieldNames.split(","));
        } else {
            errorIds.add(fieldNames);
        }
        return errorIds;
    }

    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(pageLoadCondition);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.DEFAULT_IMPLICIT_TIMEOUT));
    }

    public WebElement getLogo() {
        return logo;

    }

    public List<WebElement> getAllElements() {
        return allPageElements;

    }

    public void getRectHeightAndWidthOfAnElement(WebElement element) {
        Point p = element.getLocation();
        log.info(p.getX());
        log.info(p.getY());
        Rectangle r = element.getRect();
        log.info(r.getX());
        log.info(r.getY());
    }

    public boolean checkForTitle(WebDriver driver, String title) {
        log.info(title);
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException(title);
        return driver.getTitle().trim().contains(title);
    }

    public boolean assertLogoIsDisplayed() {
        return logo.isDisplayed();

    }

    public String getLogoText() {
        return logo.getText();

    }

    public void clickLogoImage() {
        logo.click();

    }

    public String getThisPageTitle() {
        log.info("Title is: " + driver.getTitle());
        return new VerificationHelper(driver).getCurrentPageTitle();
    }

    public String getCurrentPageTitle() {
        log.info("Title is: " + driver.getTitle());
        return new VerificationHelper(driver).getCurrentPageTitle();
    }

    public String getCurrentPageUrl() {
        log.info("BasePage Url is: " + driver.getCurrentUrl());
        return new VerificationHelper(driver).getCurrentPageUrl();
    }

    public String getThisPageUrl() {
        log.info("BasePage Url is: " + driver.getCurrentUrl());
        return new VerificationHelper(driver).getCurrentPageUrl();
    }

    public boolean assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(String MenuName) throws InterruptedException {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(GlobalVars.explicit_Wait));
        return breadCrumbList.stream().parallel().anyMatch(s -> s.getText().trim().contains(MenuName));
    }

    public void checkPageIsReady(int loopCount) {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(pageLoadCondition);
    }

    public void acceptCookie() {
        if (acceptCookies.size() > 0) {
            driver.findElement(By.id("accept-cookies")).click();
        }
    }

    public void assertCookieBannerIsNotVisible() {
        Assert.assertEquals(0, driver.findElements(By.id("cookie_banner")).size(), "Web element was present");
    }

    public void assertCookieIsNotPresent(String cookieName) {
        Assert.assertNull(driver.manage().getCookieNamed(cookieName));

    }

    public void assertCookieIsPresent(String seen_cookie_message, String cookieName) {
        Cookie cookie = driver.manage().getCookieNamed(cookieName);
        Assert.assertNotNull(cookie);
        Assert.assertEquals("The cookie value was not expected", cookie.getValue());

    }

    public void assertElementDoesNotExist(By locator) {
        try {
            getElement(locator);
            Assert.assertTrue(false, "This element should not exist.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    public void assertElementExist(By locator) {
        try {
            getElement(locator);
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false, "This element should exist.");
        }
    }

    public void assertTextDisplayedOnThePage(String str) {
        assertElementExist(By.xpath("//*[normalize-space(.)='" + str + "']"));
    }


    // ********* Input Label names ********* //

    public void assertHeadingIsDisplayed() {
        Assert.assertTrue(heading.isDisplayed(), "Heading not displayed");

    }

    public void assertManageCookiesPage() throws Exception {
        NavigateToNewTab.navigateToNewTab();

    }

    public void assertNoRadioButtonSelected(List<WebElement> elements) {
        Assert.assertTrue(elements.get(1).isSelected(), "Radio button not selected");

    }

    public void assertOnElementIsDisplayed(WebElement element) {
        if (driver.getCurrentUrl().contains("/index.php?rt")) {
            Assert.assertTrue(element.isDisplayed(), "Element is not displayed ");
        } else {

            Assert.assertTrue(element.isDisplayed(), "Add Employer button is not displayed ");
        }
    }



/*    public void assertOnErrorMessage(String expectedErrorMsg) {
        Assert.assertEquals("Error message mismatch", expectedErrorMsg, errorMsg.getText());
    }*/

/*    public void assertOnErrorMessages(DataTable dataTable) {
        List<String> expectedErrorMsgs = dataTable.asList();
        for (int i = 0; i < errorMsgs.size(); i++) {
            Assert.assertEquals("Error Message did not match", expectedErrorMsgs.get(i), errorMsgs.get(i).getText());
        }
    }

    public void assertOnErrorMessages(int i) {
        Assert.assertTrue(errorMsgs.get(i).isDisplayed(), "Error message " + (i + 1) + " is not displayed");
    }*/



/*    public void assertOnErrorMessagesOnPage(DataTable dataTable) {
        List<String> expectedErrorMsgs = dataTable.asList();
        for (int i = 0; i < expectedErrorMsgs.size(); i++) {
            Assert.assertEquals("Error message did not match", expectedErrorMsgs.get(i),
                    pageErrorMsgs.get(i).getText());
        }

    }*/

    public void assertOnElementIsNotDisplayed(List<WebElement> elements) {
        Assert.assertEquals(elements.size(), 0, "Element is displayed");
    }

/*    public void assertOnPageErrorMessage(String expectedErrorMsg) {
        Assert.assertEquals("Error message mismatch", expectedErrorMsg, pageErrorMsg.getText().trim());
    }*/

    /*    public void assertOnErrorMessagesOnPage(int i) {
            Assert.assertTrue(pageErrorMsgs.get(i).isDisplayed(), "Error message " + (i + 1) + " is not displayed");
        }*/
    public void assertOnOrderOfWebElementsByListOrder(List<String> elementIds) {
        String idOfParentElement = elementIds.get(0);
        WebElement parentWebElement = driver.findElement(By.id(idOfParentElement));
        List<WebElement> childWebElements = parentWebElement.findElements(By.xpath(".//*"));
        WebElementOrderChecker webElementOrderChecker = new WebElementOrderCheckerImpl(childWebElements);
        List<String> childIds = getIdListOfExpectedChildElements(elementIds);
    }

    public void assertOnSubHeadingText(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }


    // ********* Radio buttons ********* //



    /*public void assertRadioButtonsUnchecked() {
        for (int i = 0; i < radioBtns.size(); i++) {
            Assert.assertFalse(radioBtns.get(i).isSelected(), (i + 1) + " Radio button is selected by default ");
        }
    }*/

    public void assertOnSubHeadingT(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("error-summary-title"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public void assertRejectedCookiesMessageIsNotVisible() {
        Assert.assertEquals(0, driver.findElements(By.id("rejected-cookies-message")).size(), "Web element was present");
    }

    public void assertTextShouldNotBeDisplayedInHeadingText(String headingText) {
        WebElement newHeading = driver.findElement(By.id("heading"));
        Assert.assertNotEquals(headingText, newHeading.getText());
    }

    public void assertWebElementNotDisplayedInCurrentPage(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("no such element: Unable to locate element:"));
        }
    }

    public void clickCookiesLink(WebElement element) {
        try {
            ScrollPage.scrollToView(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void clickContinueButton() {
        continueButton.click();

    }

    public boolean doesThePageHaveValidationErrors() {
        try {
            WebElement errorSummaryElement = getElement(
                    By.cssSelector("ul[class='nhsuk-list nhsuk-error-summary__list']"));
            List<WebElement> errorSummaryChildElements = errorSummaryElement.findElements(By.xpath(".//*"));
            List<WebElement> errorFieldElements = driver
                    .findElements(By.className("error-message"));
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);

    }
    private List<String> getIdListOfExpectedChildElements(List<String> elementIds) {
        List<String> ids = new ArrayList<>();
        for (String elementId : elementIds) {
            ids.add(elementId);
        }
        ids.remove(0);
        return ids;
    }

    // navigate helper
    public void navigateTo(String url) {
        driver.navigate().to(url);

    }

    public void waitForElementToDisappear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
        log.info("Waiting Element to disappear....");
    }

    public void waitForElementToAppearBy(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitAndSendKeys(WebElement findBy, String keysToSend) {
        findBy.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(findBy)).sendKeys(keysToSend);
        log.info("Waited and Successfully sent keys to :: " + keysToSend);
    }

    public void waitAndClick(WebElement findBy) {
        log.info("Waiting Element to be clicked....");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        log.info("Successfully clicked ");
        wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();

    }

    public void SwitchWindowToChild() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

    public void clickAnyElementMatchingText(List<WebElement> elements, Predicate<WebElement> predicate) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element not present"));
        element.click();
    }

    public void clickAnyMatchingLinkText(List<WebElement> element, String linkText) {
        WebElement ele = element.stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(linkText))
                .findFirst()
                .orElse(null);
        if (ele != null) {
            ele.click();
            log.info("Clicked on the link");
        }
    }

    public void clickAnyMatchingElementByText(List<WebElement> elements, String text) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(s -> s.isDisplayed() && s.getText().contains(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text " + text + " not present"));
        element.click();
    }


    public List<String> getAnyMatchingElement_Text_Attribute_TagName(List<WebElement> elements, Function<WebElement, String> Function) {
        return elements
                .stream()
                .parallel()
                .filter(WebElement::isDisplayed)
                .map(Function)
                .collect(Collectors.toList());
    }

    public boolean assertAnyLinkFromListOfElements(List<WebElement> listOfElements, String linkText) {
        return listOfElements
                .stream()
                .parallel()
                .anyMatch(s -> s.getText().equalsIgnoreCase(linkText));
    }


    public String getPageHeaderText() {
        return new VerificationHelper(driver).getText(heading);
    }

    public String getPageSubHeaderText() {
        return new VerificationHelper(driver).getText(subHeading);
    }

    public WebElement getPageBreadcrumbMenuList(String breadCrumbMenuName) {
        for (int i = 0; i < allPageBreadCrumbList.size(); i++) {
            if (allPageBreadCrumbList.get(i).getText().contains(breadCrumbMenuName)) {
                return allPageBreadCrumbList.get(i);

            }
        }


        return null;
    }

    public List<WebElement> getDollarSigns() {
        return dollarSigns;

    }

    public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (itr.hasNext()) {
            String p = itr.next().getText();
            if (p.contains("$")) {
                String actualData = p.substring(1);
                //log.info(actualData);
                double p1 = Double.parseDouble(actualData);
                int productPrice = (int) (p1);
                array.add(productPrice);
            }
        }
        return array;
    }

    public boolean verifyArrayHasAscendingData(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            // this condition will check all next price should be smaller than previous one.
            // next price can be grater and equal
            if (array.get(i) <= array.get(i + 1)) {
                log.info("obj.get(i).." + array.get(i));
                log.info("obj.get(i+1).." + array.get(i + 1));
            } else {
                log.info("price filter is not working");
                return false;
            }
        }
        return true;
    }

    public void moveToElementAndClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void moveToElement(WebElement element) {
        WebElement webElement = waitForVisibilityOfElement(element, GlobalVars.explicitWait);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }


    public void waitForElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void clickAnItemFromListByText(List<WebElement> elements, String itemText) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(e -> e.getText().equalsIgnoreCase(itemText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + itemText + " not present"));
        element.click();
    }


    public void clickAnElementMatchingText(List<WebElement> elements, String itemText) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(e -> e.getText().equalsIgnoreCase(itemText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + itemText + " not present"));
        element.click();
    }

    public ProductIDPage addProductToCart(String productName) {
        List<WebElement> products = allProductsList;
        for (WebElement product : products)
            if (product.findElement(By.cssSelector("a.prdocutname")).getText().equalsIgnoreCase(productName)) {
                log.info(product.findElement(By.cssSelector("a.prdocutname")).getText());
                product.findElement(addToCart).click();
                break;
            }
        return new ProductIDPage();

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
                .filter(product -> product.findElement(By.cssSelector("a.prdocutname")).getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);

    }


    public ProductIDPage addProductToBasket(String productName) {
        for (int i = 0; i < allProductsList.size(); i++) {
            //if (allProductsList.get(i).findElement(By.cssSelector("a.prdocutname")).getText().equalsIgnoreCase(productName)) {
            if (allProductsList.get(i).findElement(product_names).getText().equalsIgnoreCase(productName)) {

                    log.info(allProductsList.get(i).findElement(By.cssSelector("a.prdocutname")).getText());
                allProductsList.get(i).findElement(addToCart).click();
                break;
            }

        }

        return new ProductIDPage();
    }

    public void selectDropDownByIndexOrTextOrValue(Object o, WebElement countryDropdownBtn) {
        Select select = new Select(countryDropdownBtn);
        if (o instanceof Integer) {
            select.selectByIndex((int) o);
        } else if (o instanceof String) {
            select.selectByVisibleText((String) o);
        } else if (o instanceof WebElement) {
            select.selectByVisibleText(((WebElement) o).getText());
        } else {
            log.error("Invalid input for dropdown selection");
        }
    }

    public void click(By xpath, WaitStrategy clickable) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        WebElement element = null;
        switch (clickable) {
            case CLICKABLE:
                element = wait.until(ExpectedConditions.elementToBeClickable(xpath));
                break;
            case PRESENCE:
                element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
                break;
            case VISIBLE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
                break;
            default:
                break;
        }
        element.click();
        
    }

    public void sendKeys(By locator, String cityName, WaitStrategy presence) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        WebElement element = null;
        switch (presence) {
            case PRESENCE:
                element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            case VISIBLE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;

            default:
                break;
        }
        element.sendKeys(cityName);
    }
}
