package com.automationteststore.pages;


import com.automationteststore.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscribePage {
    private final static Logger log = LogManager.getLogger(SubscribePage.class);
    BasePage basePage;
    @FindBy(id = "appendedInputButton")
    private WebElement subscribeToNewsletterBox;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement subscribeButton;


    public WebElement getSubscribeToNewsletterBox() {
        return subscribeToNewsletterBox;

    }

    public WebElement getSubscribeButton() {
        return subscribeButton;

    }


}
