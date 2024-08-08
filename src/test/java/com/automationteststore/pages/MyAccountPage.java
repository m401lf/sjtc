package com.automationteststore.pages;

import helpers.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class MyAccountPage {
    private final static Logger log = LogManager.getLogger(MyAccountPage.class);
    LogoutPage logoutPage;
    EditProfilePage editProfilePage;
    @FindBy(css = ".maintext")
    private WebElement userProfileMyAccountTxt;
    @FindBy(css = "h1.heading")
    private WebElement myAccountTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[2]/div[1]/div/ul/li[1]")
    private WebElement accountDashboardTxt;
    @FindBy(css = "a > .fa.fa-unlock")
    private WebElement logoffIcon;

    @FindBy(css = ".dash-tile-header")
    private List<WebElement> dashTileHeaders;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/ul/li/a/i")
    private List<WebElement> sideWidgetIcons;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]")
    private List<WebElement> sideWidgetAccountDashboardLinks;
    @FindBy(xpath = "//a[@data-original-title='Edit account details']")
    private WebElement editAccountDetailsLink;
    @FindBy(id = "customer_menu_top")
    private WebElement welcomeBackTxt;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/ul/li[9]/a/i")
    private WebElement logout;
    @FindBy(css = ".alert.alert-success")
    private WebElement successYourAccountSuccessfullyUpdatedTxt;

    public String getAccountDashboardTxt() {
        return accountDashboardTxt.getText();

    }

    public LogoutPage clickOnLogoffBtn() {
        logoutPage = PageFactory.initElements(driver, LogoutPage.class);
        logoffIcon.click();
        return logoutPage;
    }

    public boolean assertLogoffButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(logoffIcon);

    }

    public void verifyAllSideWidgetElementsInAccountPageLinks() {
        List<WebElement> links = sideWidgetAccountDashboardLinks;
        for (int i = 0; i < links.size(); i = i++) {
            String listOfElements = links.get(i).getText();
            log.info("Size Of Side Widget List => " + links.size());
            break;
        }

    }

    public void ClickOnLogOffLinkInSideWidgetList() {
        List<WebElement> ListSideWidget = driver.findElements(By.cssSelector(".side_account_list"));
        for (int i = 0; i < ListSideWidget.size(); i = i++) {
            String listName = ListSideWidget.get(i).getText();
            if (listName.contains("Logoff")) {
                driver.findElements(By.linkText("Logoff")).get(i).click();
                break;
            }

        }

    }

    public String getAccountText() {
        return myAccountTxt.getText();

    }

    public String userProfileInfoMessageTxt() {
        return userProfileMyAccountTxt.getText();

    }

    public String getWelcomeMessageTxt() {
        return new VerificationHelper(driver).getText(welcomeBackTxt);

    }

    public String accountDashboardMessage() {
        return new VerificationHelper(driver).getText(accountDashboardTxt);

    }

    public void clickOnLogoutButton() {
        logout.click();

    }

    public EditProfilePage clickOnEditAccountDetailsLink() throws IOException, InterruptedException {
        Thread.sleep(3000);
        editAccountDetailsLink.click();
        editProfilePage = new EditProfilePage();
        return editProfilePage;

    }

    public String getAccountProfileSuccessfulUpdateMessage() {
        return successYourAccountSuccessfullyUpdatedTxt.getText();

    }

    public boolean assertMyAccountPageIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(myAccountTxt);

    }

    public String getManageAddressBook() {
        return new VerificationHelper(driver).getText(dashTileHeaders.get(0)).trim();

    }

    public String getOrderHistory() {
        return new VerificationHelper(driver).getText(dashTileHeaders.get(1)).trim();

    }

    public String getDownloads() {
        return new VerificationHelper(driver).getText(dashTileHeaders.get(2)).trim();

    }

    public String getTransactionHistory() {
        return new VerificationHelper(driver).getText(dashTileHeaders.get(3)).trim();
    }

    public int getSideWidgetIconCount() {
        return sideWidgetIcons.size();

    }
}