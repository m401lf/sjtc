package com.automationteststore.testCases.Demos.SeleniumBasicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Video_26_navigateCommand {

    @Test(enabled = true)
    public void f1() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("http://omayo.blogspot.com/");

        // Using navigate command we can open the url
        //The difference b/w navigate() and get() command is navigate() command store the history but get() command does not
        driver.navigate().to("http://omayo.blogspot.com/");

        Thread.sleep(2000);
        // The purpose navigate().back() command to move to back page
        driver.navigate().back();

        Thread.sleep(2000);
        // The purpose navigate().forward() command to move to forward page
        driver.navigate().forward();

        Thread.sleep(2000);
        // The purpose navigate().refresh() command to refresh page
        driver.navigate().refresh();

        Thread.sleep(2000);

        driver.quit();

    }

}
