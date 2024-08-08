package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.LocatingStrategies;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Combinations_CSS_Selector_W {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testCsstagandclass() throws Exception {
        driver.get(baseUrl + "/whizTrial/");

        //Tag with attribute value
    /*driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input[name='userauth']")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();*/

        //id
    /*driver.findElement(By.cssSelector("#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input[name='userauth']")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();*/

        //Tag and id
    /*driver.findElement(By.cssSelector("input#Lid")).clear();
    driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input#Lpwd")).clear();
    driver.findElement(By.cssSelector("input#Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();*/

        //Tag and attribute class
    /*driver.findElement(By.cssSelector("input#Lid")).clear();
    driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
    driver.findElement(By.cssSelector("input#Lpwd")).clear();
    driver.findElement(By.cssSelector("input#Lpwd")).sendKeys("pass123");
    driver.findElement(By.id("Lsub")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("a.link")).click();
    Thread.sleep(3000);*/

        //Class attribute
        driver.findElement(By.cssSelector("input#Lid")).sendKeys("gsahai");
        driver.findElement(By.cssSelector("input#Lpwd")).sendKeys("pass123");
        driver.findElement(By.id("Lsub")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".link")).click();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}

