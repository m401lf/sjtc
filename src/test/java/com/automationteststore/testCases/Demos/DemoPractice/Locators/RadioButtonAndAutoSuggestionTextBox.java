package com.automationteststore.testCases.Demos.DemoPractice.Locators;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class RadioButtonAndAutoSuggestionTextBox {
    WebDriver driver;

    @Test
    public void enterText() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("http://my.monsterindia.com/create_account.html?");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // enter first Name
        driver.findElement(By.xpath("//*[@id='firstName_id']")).sendKeys("firstName");
        driver.findElement(By.xpath("//*[@id='lastName_id']")).sendKeys("lastName");

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test7676767@gmail.com");

        driver.findElement(By.id("passwd_id")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='email_msg']/a/img")).click();

        driver.findElement(By.xpath("//*[@id='passwd_id']")).sendKeys("password");

        driver.findElement(By.xpath("//*[@id='select2-chosen-1']")).click();

        driver.findElement(By.xpath("//*[@id='s2id_autogen1_search']")).sendKeys("Bang");

        driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();

        driver.findElement(By.xpath("//*[@id='expYrMonth']/div[2]")).click();

        driver.findElement(By.xpath("//*[@id='expYrMonth_popup']/div/div[4]//div[text()='3']/preceding-sibling::div/input")).click();

        driver.findElement(By.xpath("//*[@id='expYrMonth_popup']/div/div[5]//div[text()='5']/preceding-sibling::div/input")).click();

        driver.findElement(By.xpath("//*[@id='expYrMonth']/div[2]")).click();

        driver.findElement(By.xpath("//*[@id='skills']")).sendKeys("Jav");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Java OR C']")).click();


    }
}
