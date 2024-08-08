package com.automationteststore.testCases.Demos.DemoPractice.Locators;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByLinkText {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");

        driver.findElement(By.linkText("ACTIONS")).click();

        String data = "ACTIONS";

        //driver.findElement(By.linkText('"+testData.data+"')).click();


    }

}

