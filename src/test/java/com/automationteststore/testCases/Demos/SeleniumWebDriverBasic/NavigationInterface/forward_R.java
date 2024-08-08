package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.NavigationInterface;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class forward_R {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium Project\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void test_back() throws Exception {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        String actual_title = driver.getTitle();
        String expect_title = "Log in to Facebook | Facebook";
        Assert.assertEquals(actual_title, expect_title);
    }

    @AfterMethod
    public void teardown() throws Exception {
        driver.quit();
    }
}
