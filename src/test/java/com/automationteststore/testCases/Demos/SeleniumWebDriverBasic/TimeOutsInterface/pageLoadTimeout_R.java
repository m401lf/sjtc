package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.TimeOutsInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class pageLoadTimeout_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void testExplicitwait() throws Exception {

        driver.get("https://www.google.co.in/");
        Assert.assertEquals(driver.getTitle(), "Google");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}



