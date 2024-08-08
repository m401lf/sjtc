package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.TimeOutsInterface;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class setScriptTimeout_W {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().window().maximize();
    }

    @Test
    public void testVerifytitle() throws Exception {

        long start = System.currentTimeMillis();
        driver.get("http://localhost/whizTrial/");
        Assert.assertEquals("WhizTrial Registration", driver.getTitle());


        long current = System.currentTimeMillis();
        long TimeDiff = current - start;

        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

        System.out.println("Elapsed time: " + TimeDiff);


    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(7000);
        driver.quit();
    }
}

