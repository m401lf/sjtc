package com.automationteststore.testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.AlertInterface;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class sendkeysalert_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //Creating a text box based prompt box alert using JavascriptExecutor and executeScript method
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.prompt('Enter your name');");
    }

    @Test
    public void sendkeySalertExample() throws Exception {
        //Entering a text to prompt text box or pop up
        Alert enter = driver.switchTo().alert();
        enter.sendKeys("Rajat");
        //Printing the alert text
        String alertText = enter.getText();
        System.out.println("Alert text is: " + alertText);
        Thread.sleep(3000);
        enter.accept();

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }


}

