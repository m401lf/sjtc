package com.automationteststore.testCases.Demos.SeleniumBasicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Video_21_IsDisaplayedCommand {

    @Test(enabled = true)
    public void f1() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/");

        // The purpose isDisplayed() command to get the confirmation of element is visible or not on the page
        boolean a = driver.findElement(By.id("textbox1")).isDisplayed();  //true
        System.out.println(a);


        boolean b = driver.findElement(By.id("hbutton")).isDisplayed();  //false
        System.out.println(b);

        Thread.sleep(2000);
        driver.quit();

    }

}
