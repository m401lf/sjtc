package com.automationteststore.testCases.Demos.DemoPractice.Excel_Data_Driven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class UsingExcel {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Constants.URL);
        driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
        // Click login button
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        // Tell the code about the location of Excel file
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider = "loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        // Enter username
        driver.findElement(By.id("user_email")).sendKeys(username);
        // Enter password
        driver.findElement(By.id("user_password")).sendKeys(password);
        // Click Login button
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);

        // Find if error messages exist
        boolean result = driver.findElements(By.xpath("//form[@id='new_user']//div[3]")).size() != 0;
        Assert.assertTrue(result);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //driver.quit();
    }
}