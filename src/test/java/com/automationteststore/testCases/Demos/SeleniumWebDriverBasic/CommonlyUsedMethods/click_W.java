package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class click_W {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","...\\chromedriver.exe");
        //driver = new ChromeDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testRelativexpath() throws Exception {
        driver.get(baseUrl + "/whizTrial/");  //  Launch the whizTrial website
        driver.findElement(By.linkText("Create New Account")).click();  // Click on the 'Create New Account' linkText
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "WhizTrial Registration"); // Verifying the Registration page

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}


