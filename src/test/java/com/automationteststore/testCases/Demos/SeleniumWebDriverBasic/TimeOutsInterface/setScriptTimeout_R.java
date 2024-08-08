package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.TimeOutsInterface;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class setScriptTimeout_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testsetScriptTimeout() throws Exception {
        long start = System.currentTimeMillis();
        driver.get("https://www.google.co.in/");
        Assert.assertEquals("Google", driver.getTitle());
        long current = System.currentTimeMillis();
        long val = current - start;
        ((JavascriptExecutor) driver).executeAsyncScript(
                "window.setTimeout(arguments[arguments.length - 1], 1000);");
        System.out.println("Elapsed time: " + val);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();

    }
}
