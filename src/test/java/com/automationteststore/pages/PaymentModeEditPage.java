package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentModeEditPage {
    private final static Logger log = LogManager.getLogger(PaymentModeEditPage.class);
    BasePage basePage;
    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;
    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;

    public WebElement getTestGatewayTxt() {
        return testGatewayTxt;

    }

    public WebElement getCcNumberBox() {
        return ccNumberBox;

    }
}
