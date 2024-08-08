package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class click_R {

    WebDriver driver;

    String baseUrl = "https://www.google.com";

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Clear() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium Webdriver");
        Thread.sleep(3000);
        driver.findElement(By.name("btnG")).click(); // Click on the search button
        driver.findElement(By.linkText("Selenium WebDriver")).click(); // Click on the 'Selenium WebDriver link text'
        Thread.sleep(3000);
        //Assert.assertEquals(driver.getTitle(),"Selenium WebDriver");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}


