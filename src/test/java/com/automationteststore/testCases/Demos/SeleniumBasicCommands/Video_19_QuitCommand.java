package com.automationteststore.testCases.Demos.SeleniumBasicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Video_19_QuitCommand {

    @Test(enabled = true)
    public void f1() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/");

        driver.findElement(By.linkText("Open a popup window")).click();

        // The purpose quit() command to close the all the (parent and child) webPages which is opened by Selenium WebDriver
        //Note: Diff b/w close and Quit
        //Close - Will use to only close the current browser window
        //Quit - Will use to close the all the browser windows that are currently opend

        Thread.sleep(2000);
        driver.quit();

    }

}
