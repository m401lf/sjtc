package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.CommonlyUsedMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;


public class getTitle_W {
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
        String Title = driver.getTitle();          // Getting the title with the help List_Scream getTitle
        System.out.println("Title Of the webpage = " + Title);

        Assert.assertEquals("WhizTrial Registration", Title);

    }

    @Ignore
    @Test
    public void testRelativexpath_01() throws Exception {
        driver.get("http://localhost/whizTrial/");
        String Title = driver.getTitle();          // Getting the title with the help List_Scream getTitle
        System.out.println("Title Of the webpage = " + Title);

        Assert.assertEquals("WhizTrial Registration", Title);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}