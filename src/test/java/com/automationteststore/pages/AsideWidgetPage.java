package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.automationteststore.base.BaseTest.driver;


public class AsideWidgetPage {
    final static Logger log = LogManager.getLogger(AsideWidgetPage.class);
    BasePage basePage;
    NotificationPage notificationPage;
    LogoutPage logoutPage;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div[1]/div/ul/li/a")
    private List<WebElement> asideWidgetLinks;

    public List<WebElement> getAsideWidgetLinks() {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(ExpectedConditions.visibilityOfAllElements(asideWidgetLinks));
    }

    public void tapOnAsideWidgetLinkByName(String linkName) throws IOException {
        driver.findElements(By.xpath("//a[contains(text(),'" + linkName + "')]"));
    }

    public void clickSideWidgetLinkByName(String linkName) {
        asideWidgetLinks.stream()
                .parallel()
                .filter(s -> s.getText().contains(linkName))
                .findFirst()
                .ifPresent(WebElement::click);
        log.info("Taped on " + linkName + " link");
    }

    public MyAccountPage tapMyAccountLink() throws IOException {
        clickSideWidgetLinkByName(" My Account");
        return new MyAccountPage();
    }

    public EditProfilePage tapEditAccountLink() throws IOException {
        clickSideWidgetLinkByName(" Edit Account");
        return new EditProfilePage();
    }

    public RegisterPage tapOnRegisterLink() throws IOException {
        clickSideWidgetLinkByName("Register");
        return new RegisterPage();
    }

    public ForgottenPasswordPage tapOnPasswordLink() {
        clickSideWidgetLinkByName(" Password");
        log.info("clicked Forgotten Password link");
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current basePage url :: " + basePage.getThisPageUrl());
        log.info("current basePage title:: " + basePage.getThisPageTitle());
        return new ForgottenPasswordPage();
    }

    public AddressPage tapOnAddressBookLink() {
        clickSideWidgetLinkByName("Address Book");
        log.info("clicked Address Book link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current basePage url :: " + basePage.getThisPageUrl());
        log.info("current basePage title:: " + basePage.getThisPageTitle());
        return new AddressPage();
    }

    public WishListPage tapOnWishListLink() throws IOException {
        clickSideWidgetLinkByName("Wish List");
        log.info("clicked Wish List link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current basePage url :: " + basePage.getThisPageUrl());
        log.info("current basePage title:: " + basePage.getThisPageTitle());
        return new WishListPage();
    }

    public OrderHistoryPage tapOnOrderHistoryLink() throws IOException {
        clickSideWidgetLinkByName("Order History");
        log.info("clicked Order History link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current basePage url :: " + basePage.getThisPageUrl());
        log.info("current basePage title:: " + basePage.getThisPageTitle());
        return new OrderHistoryPage();
    }

    public DownloadsPage tapOnDownloadLink() {
        clickSideWidgetLinkByName(" Download");
        log.info("clicked Order Download link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        return new DownloadsPage();
    }

    public NotificationPage tapOnNewsletterLink() throws IOException {
        clickSideWidgetLinkByName(" Newsletter");
        log.info("clicked Newsletter link");
        notificationPage = PageFactory.initElements(driver, NotificationPage.class);
        return notificationPage;
    }

    public TransactionsPage tapOnTransactionsLink() throws IOException {
        clickSideWidgetLinkByName(" Transactions");
        log.info("clicked Transactions link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current basePage url :: " + basePage.getThisPageUrl());
        log.info("current basePage title:: " + basePage.getThisPageTitle());
        return new TransactionsPage();
    }

    public LogoutPage tapLogoffLink() throws IOException {
        logoutPage = PageFactory.initElements(driver, LogoutPage.class);
        clickSideWidgetLinkByName("  Logoff");
        return logoutPage;
    }

    public List<String> getAsideWidgetList() {
        List<String> asideWidgetList =
                asideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
        log.info("Aside Widget List: " + asideWidgetList);
        return asideWidgetList;
    }

    public int getCountAsideWidgetList() {
        List<String> asideWidgetList =
                asideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
        return asideWidgetList.size();
    }

    public boolean assertAsideWidgetItemsCountAndFirstAndLastIndex(int labelsCount, int firstIndex, int lastIndex) {
        List<WebElement> asideWidgetList = asideWidgetLinks;
        int size = asideWidgetList.size();
        for (int i = 0; i < size; i++) {
            if (asideWidgetList.get(i).getText().equals(String.valueOf(labelsCount))) {
                if (i == firstIndex) {
                    log.info("First Index: " + firstIndex);
                    log.info("First Index: " + firstIndex);
                }
                if (i == lastIndex) {
                    log.info("Last Index: " + lastIndex);
                    log.info("Last Index: " + lastIndex);
                }

            }

        }

        return true;

    }

}

