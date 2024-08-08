package com.automationteststore.testCases.Demos.DemoPractice.JavaScriptExecution;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class JavaScriptClick1 {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//	@Test
//	public void testJSClick1() throws Exception {
//		driver.get("https://www.letskodeit.com/practice");
//		Thread.sleep(3000);
//		
//		WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
//		js.executeScript("arguments[0].click();", checkBoxElement);
//	}

    @Test
    public void testJSClick2() throws Exception {
        driver.get("https://www.retailmenot.com/");
        driver.findElement(By.xpath("//div[text()='Log In / Sign up']")).click();
        Thread.sleep(3000);

        WebElement checkBoxElement = driver.findElement(By.id("subscribe"));
        System.out.println("Displayed: " + checkBoxElement.isDisplayed());
        System.out.println("Selected: " + checkBoxElement.isSelected());

        //checkBoxElement.click();
        js.executeScript("arguments[0].click();", checkBoxElement);
    }


    @AfterMethod
    public void tearDown() throws Exception {
    }
}