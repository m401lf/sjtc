package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class quit_W {
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
        driver.get("http://localhost/whizTrial/");
        Assert.assertEquals(driver.getTitle(), "WhizTrial Registration");

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
