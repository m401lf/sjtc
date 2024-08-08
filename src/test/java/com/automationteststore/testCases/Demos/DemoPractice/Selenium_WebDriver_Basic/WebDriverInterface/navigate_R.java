package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class navigate_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testFrame() throws Exception {
        driver.get("http://localhost/whizTrial/");
        driver.get("https://www.google.co.in/");
        driver.get("https://www.bing.com/");

        Thread.sleep(2000);
        driver.navigate().to("https://www.google.co.in/");
        Assert.assertEquals(driver.getTitle(), "Google");

        Thread.sleep(2000);
        driver.navigate().to("http://localhost/whizTrial/");
        Assert.assertEquals(driver.getTitle(), "WhizTrial Registration");

        Thread.sleep(2000);
        driver.navigate().to("https://www.bing.com/");
        Assert.assertEquals(driver.getTitle(), "Bing");
        Thread.sleep(2000);

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
