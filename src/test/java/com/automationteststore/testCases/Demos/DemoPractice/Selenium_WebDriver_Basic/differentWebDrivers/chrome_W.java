package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.differentWebDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class chrome_W {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/work/Tech/Selenium/SeleniumDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("http://localhost/whizTrial/");
        Assert.assertEquals(driver.getTitle(), "WhizTrial Registration");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
