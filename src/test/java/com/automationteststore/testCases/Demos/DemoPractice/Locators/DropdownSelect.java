package com.automationteststore.testCases.Demos.DemoPractice.Locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownSelect {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testDropdown() throws Exception {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.id("carselect"));
        Select sel = new Select(element);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Honda by index");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select BMW by visible text");
        sel.selectByVisibleText("BMW");

        Thread.sleep(2000);
        System.out.println("Print the list of all options");
        List<WebElement> options = sel.getOptions();
        int size = options.size();

        for (int i = 0; i < size; i++) {
            String optionName = options.get(i).getText();
            System.out.println(optionName);
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
