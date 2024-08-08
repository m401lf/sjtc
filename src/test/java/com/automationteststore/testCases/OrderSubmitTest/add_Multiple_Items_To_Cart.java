package com.automationteststore.testCases.OrderSubmitTest;


import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.IndexPage;
import pages.TopMenuNavigationPage;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class add_Multiple_Items_To_Cart extends BaseTest{
    TopMenuNavigationPage naviPage;
    IndexPage indexPage;
    String productName1 = "ABSOLUE EYE PRECIOUS CELLS";
    String productName2 = "TOTAL MOISTURE FACIAL CREAM";
    String productName3 = "ABSOLUTE ANTI-AGE SPOT REPLENISHING UNIFYING TREATMENTSPF 15";


    @Test(priority = 1)
    public void add_To_Cart() {
        naviPage = new TopMenuNavigationPage(driver);
        //naviPage = launchApplication();
        List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

        new JavaScriptHelper(driver).scrollToElement(products.get(0));
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait())).until(ExpectedConditions.visibilityOf(products.get(0)));
        products.stream()
                .filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName1))
                .findFirst().orElse(null).findElement(By.cssSelector("a.productcart")).click();
        products.stream()
                .filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName2))
                .findFirst().orElse(null).findElement(By.cssSelector("a.productcart")).click();
        products.stream()
                .filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName3))
                .findFirst().orElse(null).findElement(By.cssSelector("a.productcart")).click();


    }

}
