package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class get_R {
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
        driver.get("https://www.google.com");
        //Assert.assertEquals(driver.getTitle(),"Google");

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}



















































































