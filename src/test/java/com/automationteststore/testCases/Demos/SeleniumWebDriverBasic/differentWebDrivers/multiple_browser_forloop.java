package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.differentWebDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class multiple_browser_forloop {
    WebDriver driver;


    public void open() {
        driver.get("https://www.google.co.in");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.ie.driver", "C:/work/Tech/Selenium/SeleniumDrivers/IEDriverServer.exe");


    }

    @Test
    public void test() {
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                driver = new FirefoxDriver();
                open();
            } else if (i == 1) {
                driver = new ChromeDriver();
                open();
            } else {
                driver = new InternetExplorerDriver();
                open();
            }
        }


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
