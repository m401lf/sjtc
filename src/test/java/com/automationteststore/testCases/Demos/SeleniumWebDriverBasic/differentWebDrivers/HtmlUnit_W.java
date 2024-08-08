package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.differentWebDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class HtmlUnit_W {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void test1() {

        driver.get("http://localhost/whizTrial/");
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "WhizTrial Registration");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

