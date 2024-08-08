package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.differentWebDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class chrome_R {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("https://www.google.co.in");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
