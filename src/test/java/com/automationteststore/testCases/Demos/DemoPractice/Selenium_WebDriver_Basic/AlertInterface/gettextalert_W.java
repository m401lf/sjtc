package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.AlertInterface;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class gettextalert_W {
    private WebDriver driver;
    private String baseUrl;


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void testFrame() throws Exception {
        driver.get(baseUrl + "/whizTrial/");
        driver.findElement(By.id("Lid")).clear();
        driver.findElement(By.id("Lid")).sendKeys("gsahai");
        driver.findElement(By.id("Lpwd")).clear();
        driver.findElement(By.id("Lpwd")).sendKeys("pass123");
        driver.findElement(By.id("Lsub")).click();
        driver.findElement(By.id("alert")).click();
        driver.findElement(By.xpath(".//*[@id='contt']/p[6]/button")).click();
        Thread.sleep(1000);
        Alert title = driver.switchTo().alert();
        Thread.sleep(4000);
        String Alerttitle = title.getText();
        Thread.sleep(4000);
        System.out.println(Alerttitle);

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }


}