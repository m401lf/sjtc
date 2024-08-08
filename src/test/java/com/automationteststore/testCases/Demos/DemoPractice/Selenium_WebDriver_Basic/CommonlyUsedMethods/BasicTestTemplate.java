package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicTestTemplate {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test_01() throws Exception {
        driver.get(baseUrl);
        String ExpectedTitle = driver.getTitle();
        Assert.assertEquals(ExpectedTitle, "Google");
    }

    @Test
    public void test_02() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium Webdriver");
        driver.findElement(By.name("btnG")).click();
        driver.findElement(By.linkText("Selenium WebDriver")).click();
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");
    }
}
