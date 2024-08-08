package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class quit_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testRelativexpath() throws Exception {
        driver.get("https://google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
