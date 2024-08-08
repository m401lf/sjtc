package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.NavigationInterface;


import org.openqa.selenium.By;
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


public class refresh_R {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void test_back() throws Exception {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Forgotten your password?")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        String actual_title = driver.getTitle();
        String expect_title = "Forgotten Password | Can't Log In | Facebook";
        Assert.assertEquals(actual_title, expect_title);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void teardown() throws Exception {
        driver.quit();
    }
}
