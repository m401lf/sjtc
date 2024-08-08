package com.automationteststore.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceOrderPage {

    private final static Logger log = LogManager.getLogger(InvoiceOrderPage.class);

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    private WebElement orderDetailsHeadingTxt;

    @FindBy(css = "a.btn.btn-default.mr10.mb20")
    private WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/div[4]/div/a[2]")
    private WebElement printBtn;

}
