package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebDriverInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class windowHandle_W {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testSwitchwindow() throws Exception {
        driver.get("http://localhost/whizTrial/");
        driver.manage().window().maximize();
        driver.get("http://localhost/whizTrial/index.php");
        driver.findElement(By.id("Lid")).clear();
        driver.findElement(By.id("Lid")).sendKeys("gsahai");
        driver.findElement(By.id("Lpwd")).clear();
        driver.findElement(By.id("Lpwd")).sendKeys("pass123");
        driver.findElement(By.cssSelector("input#Lsub")).click();
        driver.findElement(By.xpath(".//*[@id='popup']")).click();
        Thread.sleep(3000);
        String mainwindow = driver.getWindowHandle();

        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='Nw']")).click();
        Thread.sleep(3000);
        driver.switchTo().window(mainwindow);
        driver.findElement(By.id("self")).click();
        Assert.assertEquals(driver.getTitle(), "Whiztrain");
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}

