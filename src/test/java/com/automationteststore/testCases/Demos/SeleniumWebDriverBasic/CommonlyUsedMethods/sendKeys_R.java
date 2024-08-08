package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class sendKeys_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void findElements() throws Exception {
        driver.get("https://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium Webdriver");
        Thread.sleep(3000);
        driver.findElement(By.name("btnG")).click(); // Click on the search button
        driver.findElement(By.linkText("Selenium WebDriver")).click(); // Click on the 'Selenium WebDriver link text'
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
