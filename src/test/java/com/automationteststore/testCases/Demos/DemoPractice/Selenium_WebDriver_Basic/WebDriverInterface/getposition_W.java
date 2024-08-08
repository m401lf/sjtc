package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.fail;

public class getposition_W {
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get("http://localhost/whizTrial/index.php");
        driver.manage().window().getPosition().getX();
        driver.manage().window().getPosition().getY();
        System.out.println("X:" + driver.manage().window().getPosition().getX());
        System.out.println("Y:" + driver.manage().window().getPosition().getY());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

