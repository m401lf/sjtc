package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import enums.WaitStrategy;
import helpers.assertion.VerificationHelper;
import helpers.javaScript.JavaScriptHelper;
import helpers.select.DropDownHelper;
import model.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.automationteststore.base.BaseTest.driver;


public class RegisterPage{
    BasePage basePage;
    SuccessPage accountSuccessPage;
    private final static Logger log = LogManager.getLogger(RegisterPage.class);

    String email = System.currentTimeMillis() + "Gen";
    private final By buttonContinue = By.cssSelector("button[title='Continue']");
    private final By address2Box = By.xpath("//input[@id='AccountFrm_address_2']");
    private final By cityBox = By.xpath("//input[@id='AccountFrm_city']");

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerLinkText;
    @FindBy(css = ".heading1")
    private WebElement createAccountTxt;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]")
    private WebElement ifYouAlreadyHaveAnAccountWithUs;

    @FindBy(css = "#AccountFrm")
    private WebElement form;
    @FindBy(css = "label.control-label.col-sm-4")
    private List<WebElement> inputLabels;
    @FindBy(xpath = "//h4[contains(text(),'Your Personal Details')]")
    private WebElement yourPersonalDetailsTxt;
    @FindBy(id = "AccountFrm_firstname")
    private WebElement firstNameTextBox;
    @FindBy(id = "AccountFrm_lastname")
    private WebElement lastNameTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    private WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    private WebElement telephoneTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    private WebElement faxTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Your Address')]")
    private WebElement yourAddressText;
    @FindBy(css = "#AccountFrm_company")
    private WebElement companyTextBox;
    @FindBy(css = "#AccountFrm_address_1")
    private WebElement address1TextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    private WebElement address2TextBox;
    @FindBy(css = "#AccountFrm_city")
    private WebElement cityTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
    private WebElement regionStateDropdownBtn;
    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    private WebElement zipCodeTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_country_id']")
    private WebElement countryDropdownBtn;
    @FindBy(xpath = "//h4[contains(text(),'Login Details')]")
    private WebElement loginDetailsSectionText;
    @FindBy(css = "#AccountFrm_loginname")
    private WebElement loginNameTextBox;
    @FindBy(css = "#AccountFrm_password")
    private WebElement passwordTextBox;
    @FindBy(css = "#AccountFrm_confirm")
    private WebElement passwordConfirmTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Newsletter')]")
    private WebElement newsletterText;
    @FindBy(id = "AccountFrm_newsletter1")
    private WebElement subscribeYesRadioButton;
    @FindBy(css = "label[for='AccountFrm_newsletter1']")
    private WebElement subscribeYesRadioButtonLabel;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[1]/form/div[4]/fieldset/div/div/label")
    private List<WebElement> subscribeRadioButtonLabels;

    @FindBy(css = "[type='radio']")
    private List<WebElement> subscribeRadioButtons;
    @FindBy(xpath = "//label[@for='AccountFrm_newsletter1']")
    private WebElement subscribeYesRadioButtonText;
    @FindBy(css = "#AccountFrm_newsletter0")
    private WebElement subscribeNORadioButton;
    @FindBy(xpath = "//*[@id=\"AccountFrm_agree\"]")
    private WebElement agreeToPrivacyPolicyButton;
    @FindBy(css = "label[class='col-md-6 mt20 mb40'] a b")
    private WebElement agreeToPrivacyPolicyText;
    @FindBy(css = "button[title='Continue']")
    private WebElement continueBtn;
    @FindBy(css = "#AccountFrm_firstname")
    private WebElement firstNameErrorTxt;
    @FindBy(css = "#AccountFrm_lastname")
    private WebElement lastNameErrorTxt;

    @FindBy(css = "#AccountFrm_email")
    private WebElement emailErrorTxt;
    @FindBy(css = "div.alert.alert-error.alert-danger")
    private WebElement allAlertErrorDangerSummaryList;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[1]")
    private WebElement alertErrorDangerItemized;
    @FindBy(css = "#AccountFrm_address_1")
    private WebElement address1ErrorTxt;
    @FindBy(css = "#AccountFrm_city")
    private WebElement cityErrorTxt;
    @FindBy(css = "#AccountFrm_zone_id")
    private WebElement regionStateErrorTxt;
    @FindBy(css = "#AccountFrm_postcode")
    private WebElement zipCodeErrorTxt;
    @FindBy(css = "#AccountFrm_password")
    private WebElement passwordErrorTxt;
    @FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
    private WebElement privacyPolicyErrorTxt;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    private WebElement youMustAgreeToThePrivacyPolicyErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'')]")
    private List<WebElement> allHighlightedWarningRedMessageErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement firstNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement lastNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Email Address does not appear to be valid!')]")
    private WebElement emailRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Address 1 must be between 3 and 128 characters!')]")
    private WebElement address1RedMessages;
    @FindBy(xpath = "//span[contains(text(),'City must be between 3 and 128 characters!')]")
    private WebElement cityRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Zip/postal code must be between 3 and 10 characters!')]")
    private WebElement zipCodeRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Please select a region / state!')]")
    private WebElement StateProvinceRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Login name must be alphanumeric only and between 5')]")
    private WebElement loginNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Password must be between 4 and 20 characters!')]")
    private WebElement passwordRedMessages;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    private WebElement agreeToPrivacyPolicyRedMessages;
    @FindBy(xpath = "//*[contains(text(),'*')]")
    private List<WebElement> asterisks;
    @FindBy(css = "span.input-group-addon")
    private List<WebElement> mandatoryfields;
    @FindBy(how = How.ID, using = "esr-costcentre-confirm-option-yes")
    private WebElement yesRadio;
    @FindBy(how = How.ID, using = "esr-costcentre-confirm-option-no")
    private WebElement noRadio;


    public void clickYesNoRadio(String radioOption) {
        switch (radioOption.toLowerCase()) {
            case "Yes":
                yesRadio.click();
                break;
            case "No":
                noRadio.click();
                break;
        }
    }


    public String getCreateAccountTxt() {
        return new VerificationHelper(driver).getText(createAccountTxt);

    }

    public boolean assertLabelCountAndSizeAndPositions(int labels_Count, String firstLabel, String secondLabel) {
        int size = inputLabels.size();
        System.out.println("Size of labels: " + size);
        for (int i = 0; i < size; i++) {
            String labelsText = inputLabels.get(i).getText();
            System.out.println(labelsText);
            if (size == labels_Count || inputLabels.get(0).getText().trim().contains(firstLabel) || inputLabels.get(15).getText().trim().contains(secondLabel)) {
                return true;

            }
        }
        return false;
    }

    public void assertPolicyPrivacyLinkIsDisplayed() {
        Assert.assertTrue(agreeToPrivacyPolicyText.isDisplayed(), "Policy privacy is not displayed");
    }

    public String getIfYouAlreadyHaveAnAccountWithUs() {
        return new VerificationHelper(driver).getText(ifYouAlreadyHaveAnAccountWithUs);

    }

    public String getYourPersonalDetailsTxt() {
        return new VerificationHelper(driver).getText(yourPersonalDetailsTxt);

    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.click();
        firstNameTextBox.sendKeys(firstName);
        log.info("Entered first name : " + firstName);

    }

    public void enterLastName(String lastName) {
        lastNameTextBox.sendKeys(lastName);
        log.info("Entered last name : " + lastName);

    }

    public void enterEmailAddress() {
        String email = System.currentTimeMillis() + "@gmail.com";
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        log.info("Entered email : " + email);
    }

    public void enterEmail(String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        log.info("Entered email : " + email);
    }

    public void enterTelephoneNumber(String telephone) {
        telephoneTextBox.sendKeys(telephone);
        log.info("Entered telephone : " + telephone);

    }

    public void enterFaxNumber(String fax) {
        faxTextBox.sendKeys(fax);
        log.info("Entered fax : " + fax);

    }

    public void enterYourPersonalDetailsSection(String firstName, String lastName, String telephone, String fax) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress();
        enterTelephoneNumber(telephone);
        enterFaxNumber(fax);

    }

    public String getYourAddressText() {
        return new VerificationHelper(driver).getText(yourAddressText);

    }

    public void enterCompanyName(String companyName) {
        companyTextBox.sendKeys(companyName);
        log.info("Entered company name : " + companyName);

    }

    public void enterAddress1(String address1) {
        address1TextBox.sendKeys(address1);
        log.info("Entered address 1 : " + address1);

    }

    public void enterAddress2(String address2) {
        address2TextBox.sendKeys(address2);
        log.info("Entered address 2 : " + address2);
    }

    public RegisterPage enterAddressTwo(String address2) {
        this.basePage = PageFactory.initElements(driver,BasePage.class);
        this.basePage.sendKeys(address2Box, address2, WaitStrategy.VISIBLE);
        log.info("Entered address 2 : " + address2);
        return this;
    }

    public RegisterPage enterCity(String cityName) {
        this.basePage = PageFactory.initElements(driver,BasePage.class);
        this.basePage.sendKeys(cityBox, cityName, WaitStrategy.PRESENCE);
        log.info("Entered city : " + cityName);
        return this;
    }

    public void selectRegionOrState(String regionOrStateName) {
        new JavaScriptHelper(driver).scrollToElement(regionStateDropdownBtn);
        new DropDownHelper(driver).selectUsingVisibleText(regionStateDropdownBtn, regionOrStateName);
        log.info("Selected region or state : " + regionOrStateName);

    }

    public void enterPostalOrZipCode(String zipCode) {
        zipCodeTextBox.sendKeys(zipCode);
        log.info("Entered zip or postal code : " + zipCode);

    }

    public void selectCountry(String countryName) {
        new DropDownHelper(driver).selectUsingVisibleText(countryDropdownBtn, countryName);
        log.info("Selected country : " + countryName);
    }

    public void selectCountryName(String countryName) {

        this.basePage.selectDropDownByIndexOrTextOrValue(countryName,countryDropdownBtn);
        //basePage.selectDropDownByIndexOrTextOrValue((e)->e.selectByValue("3563"),countryDropdownBtn);
        //basePage.selectDropDownByIndexOrTextOrValue((e)->e.selectByIndex(3563),countryDropdownBtn);
        log.info("Selected country : " + countryName);

    }

    public void selectRegionOrStateByAnyMethod(String regionOrStateName) {
        this.basePage = PageFactory.initElements(driver,BasePage.class);
        this.basePage.selectDropDownByIndexOrTextOrValue(regionOrStateName,regionStateDropdownBtn);
        //basePage.selectDropDownByIndexOrTextOrValue((e)->e.selectByValue("3563"),regionStateDropdownBtn);
        //basePage.selectDropDownByIndexOrTextOrValue((e)->e.selectByIndex(3563),regionStateDropdownBtn);
        log.info("Selected Region Or State  : " + regionOrStateName);

    }

    public String getLoginDetailsSectionTxt() {
        return new VerificationHelper(driver).getText(loginDetailsSectionText);
    }

    public void enterLoginName() {
        loginNameTextBox.clear();
        loginNameTextBox.sendKeys(email);
        log.info("Entered login name : " + email);

    }

    public void inputLoginName(String loginname) {
        loginNameTextBox.clear();
        loginNameTextBox.sendKeys(loginname);
        log.info("Entered login name : " + loginname);

    }

    public void inputUniqueLoginName() {
        loginNameTextBox.clear();
        String loginname = System.currentTimeMillis() + "Gen";
        loginNameTextBox.sendKeys(loginname);
        log.info("Entered login name : " + loginname);
        System.out.println("Entered Login name:: " + loginname);

    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
        log.info("Entered password : " + password);

    }

    public void enterConfirmPassword(String passwordConfirm) {
        passwordConfirmTextBox.sendKeys(passwordConfirm);
        log.info("Entered password confirm : " + passwordConfirm);

    }

    public String getNewsletterTxt() {
        return new VerificationHelper(driver).getText(newsletterText);

    }

    public void tickOnSubscribeAsYes() {
        new JavaScriptHelper(driver).scrollToElement(subscribeYesRadioButton);
        subscribeYesRadioButton.click();
        log.info("Ticked on subscribe as yes");

    }

    public String getSubscribeYesRadioButtonLabel() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonLabel);

    }

    public boolean assertSubscribeYesIsSelected() {
        return new VerificationHelper(driver).isSelected(subscribeYesRadioButton);

    }

    public boolean assertSubscribeNoIsSelected() {
        return new VerificationHelper(driver).isSelected(subscribeNORadioButton);

    }

    public void clickOnSubscribeAsNo() {
        subscribeNORadioButton.click();
        log.info("Clicked on subscribe as no");

    }

    public void checkOnIAgreeToPrivacyPolicyRadioButton() {
        agreeToPrivacyPolicyButton.click();
        log.info("Checked on I agree to privacy policy radio button");

    }

    public boolean assertPrivacyPolicyIsSelected() {
        return new VerificationHelper(driver).isSelected(agreeToPrivacyPolicyButton);

    }

    public String getAgreeToPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicyText);

    }

    public SuccessPage clickOnContinueButtonInRegistrationPage() throws InterruptedException {
        continueBtn.click();
        log.info("Clicked on continue button in registration basePage");
        accountSuccessPage = new SuccessPage();
        return accountSuccessPage;
    }


    //===========Errors===============================//

    public String getFirstNameRedMessages() {
        return new VerificationHelper(driver).getText(firstNameRedMessages);

    }

    public String getLastNameRedMessages() {
        return new VerificationHelper(driver).getText(lastNameRedMessages);

    }

    public String getEmailRedMessages() {
        return new VerificationHelper(driver).getText(emailRedMessages);

    }

    public String getAddress1RedMessages() {
        return new VerificationHelper(driver).getText(address1RedMessages);

    }

    public String getCityRedMessages() {
        return new VerificationHelper(driver).getText(cityRedMessages);

    }

    public String getZipCodeRedMessages() {
        return new VerificationHelper(driver).getText(zipCodeRedMessages).trim();

    }

    public String getStateProvinceRedMessages() {
        return new VerificationHelper(driver).getText(StateProvinceRedMessages);

    }

    public String getLoginNameRedMessages() {
        return new VerificationHelper(driver).getText(loginNameRedMessages);

    }

    public String getPasswordRedMessages() {
        return new VerificationHelper(driver).getText(passwordRedMessages);

    }

    public String getAgreeToPrivacyPolicyRedMessages() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicyRedMessages);

    }

    public String getContinueBtnTxt() {
        return new VerificationHelper(driver).getText(continueBtn);

    }

    public void tapContinueButton() {
        continueBtn.click();
        log.info("Click on continue button in registration basePage");

    }

    public int getCountOfAllMandatoryRedIcons() {
        int size = mandatoryfields.size();
        log.info("Size of labels: " + size);
        System.out.println("Size of labels: " + size);
        return size;
    }

    public boolean assertForAlertErrorDangerTxt() {
        return new VerificationHelper(driver).isDisplayed(alertErrorDangerItemized);

    }


    public Boolean isSubscribeAsYesTicked() {
        return new VerificationHelper(driver).isSelected(subscribeYesRadioButton);

    }

    public boolean isPrivacyPolicyIsTicked() {
        return new VerificationHelper(driver).isSelected(agreeToPrivacyPolicyButton);

    }

    public String getSubscribeAsYes() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButton);

    }

    public String getContinueButtonTxt() {
        return new VerificationHelper(driver).getText(continueBtn);

    }
    public SuccessPage clickContinueButtonInRegisterPage() throws IOException {
        this.basePage = PageFactory.initElements(driver, BasePage.class);
        this.basePage.click(buttonContinue, WaitStrategy.CLICKABLE);
        log.info("Click on continue button in registration basePage");
        return new SuccessPage();
    }

    public SuccessPage navigateToAccountSuccessPage() {
        continueBtn.click();
        log.info("clicked on Continue button");
        return new SuccessPage();
    }

    public boolean assertCountrySelectedByIPGeoLocationIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(countryDropdownBtn);

    }

    public String getCountrySelectedByIPGeoLocationText() {
        return new VerificationHelper(driver).getText(countryDropdownBtn);

    }

    public String getSubscribeYesRadioButtonText() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonText);
    }

    public boolean assertAllAlertErrorDangerSummaryText() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait())).until(ExpectedConditions.visibilityOf(allAlertErrorDangerSummaryList));
        return new VerificationHelper(driver).isDisplayed(allAlertErrorDangerSummaryList);
    }

    public String getPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicyText);

    }

    public String getSubscribeYesOptionText() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonText);

    }

    public List<WebElement> getAsterisks() {
        return asterisks;

    }

    public void assertInputLabel(int i, String labelName) {
        Assert.assertEquals("Input label not matching", labelName, inputLabels.get(i).getText());

    }

    public void assertRadioButtonsLabel(int i, String labelName) {
        Assert.assertTrue(subscribeRadioButtonLabels.get(i).getText().contains(labelName), "Radio button label not matching");
    }

    public String getPersonalDetailsLabel() {
        return new VerificationHelper(driver).getText(yourPersonalDetailsTxt);

    }

    public void createRegistrationModel(
            String firstname,
            String lastName,
            String fax,
            String company_name,
            String address1,
            String address2,
            String cityName,
            String regionOrStateName,
            String zipOrPostalCode,
            String password,
            String confirmPassword) {
        firstNameTextBox.sendKeys(firstname);
        lastNameTextBox.sendKeys(lastName);
        faxTextBox.sendKeys(fax);
        companyTextBox.sendKeys(company_name);
        address1TextBox.sendKeys(address1);
        address2TextBox.sendKeys(address2);
        cityTextBox.sendKeys(cityName);
        selectRegionOrState(regionOrStateName);
        zipCodeTextBox.sendKeys(zipOrPostalCode);
        passwordTextBox.sendKeys(password);
        passwordConfirmTextBox.sendKeys(confirmPassword);

    }

    public void createRegistrationModel(RegistrationModel regModel) {
        firstNameTextBox.sendKeys(regModel.getFirstName());
        lastNameTextBox.sendKeys(regModel.getLastName());
        telephoneTextBox.sendKeys(regModel.getTelephone());
        faxTextBox.sendKeys(regModel.getFax());
        companyTextBox.sendKeys(regModel.getCompany());
        address1TextBox.sendKeys(regModel.getAddress1());
        address2TextBox.sendKeys(regModel.getAddress2());
        cityTextBox.sendKeys(regModel.getCity());
        selectRegionOrState(regModel.getRegionOrState());
        zipCodeTextBox.sendKeys(regModel.getZipCode());
        passwordTextBox.sendKeys(regModel.getPassword());
        passwordConfirmTextBox.sendKeys(regModel.getConfirmPassword());

    }


}