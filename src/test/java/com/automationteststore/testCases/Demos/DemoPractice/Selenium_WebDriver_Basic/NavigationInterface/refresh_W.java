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


public class refresh_W {
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
        driver.get("http://localhost/whizTrial/index.php");
        driver.findElement(By.id("Lid")).clear();
        driver.findElement(By.id("Lid")).sendKeys("gsahai");
        driver.findElement(By.id("Lpwd")).clear();
        driver.findElement(By.id("Lpwd")).sendKeys("pass123");
        driver.navigate().refresh();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        String actual_url = driver.getCurrentUrl();
        String expect_url = "http://localhost/whizTrial/regtration.php";
        Assert.assertEquals(actual_url, expect_url);
    }

    @AfterMethod
    public void teardown() throws Exception {
        driver.quit();
    }
}
