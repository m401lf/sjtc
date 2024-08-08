package com.automationteststore.pages;

import helpers.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.automationteststore.base.BaseTest.driver;

public class EditProfilePage {

    private final Logger log = LogManager.getLogger(EditProfilePage.class);
    @FindBy(xpath = "//*[@id='AccountFrm']/div[2]/div/button")
    private WebElement continueEditBtn;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    private WebElement myAccountInformationHeadingText;
    @FindBy(name = "firstname")
    private WebElement firstNameBox;
    @FindBy(xpath = "//*[@id='AccountFrm_lastname']")
    private WebElement lastNameBox;
    @FindBy(id = "AccountFrm_email")
    private WebElement emailBox;
    @FindBy(css = "#AccountFrm_telephone")
    private WebElement telephoneBox;
    @FindBy(css = "#AccountFrm_fax")
    private WebElement faxBox;

    public String userOnAccountEditPage() {
        return myAccountInformationHeadingText.getText();

    }

    public void enterFirstName(String firstName) {
        firstNameBox.clear();
        firstNameBox.sendKeys(firstName);
    }

    public void enterLastName(String lastname) {
        lastNameBox.clear();
        lastNameBox.sendKeys(lastname);
    }

    public void enterFreshEmail() {
        String email = System.currentTimeMillis() + "@gmail.com";
        emailBox.clear();
        emailBox.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneBox.clear();
        telephoneBox.sendKeys(telephone);
    }

    public void enterFax(String fax) {
        faxBox.clear();
        faxBox.sendKeys(fax);
    }

    public MyAccountPage clickOnContinueEditBtn() throws InterruptedException {
        new JavaScriptHelper(driver).scrollIntoViewAndClick(continueEditBtn);
        Thread.sleep(5000);
        return new MyAccountPage();
    }

    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) {
        System.out.println(" about editing Profile Details....");
        enterFirstName(firstname);
        enterLastName(lastname);
        enterFreshEmail();
        enterTelephone(telephone);
        enterFax(fax);
        System.out.println("edited Profile Details....");

    }

}
