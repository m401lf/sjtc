package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.CommonlyUsedMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class timeouts_W {

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
        driver.get(baseUrl + "/whizTrial/");
        driver.findElement(By.id("Lid")).sendKeys("Roshan Singh");  // Enter the username in the 'Username' input field
        driver.findElement(By.id("Lpwd")).sendKeys("123456");   //  Enter the password in the 'Password' input field
        driver.findElement(By.id("Lsub")).click();  // Click on the 'Login' button
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "WhizTrial Welcome"); // Verifying the welcome page

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}