package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.NavigationInterface;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class navigate_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium Project\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void testFrame() throws Exception {
        driver.navigate().to("https://www.google.co.in/");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("india");
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "india - Google Search");

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
