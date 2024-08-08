package com.automationteststore.testCases.Demos.DemoPractice.Locators;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WorkingWithElementsList {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @Test
    public void testListOfElements() throws Exception {
        boolean isChecked = false;
        List<WebElement> radioButtons = driver.findElements(
                By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
        int size = radioButtons.size();
        System.out.println("Size of the list: " + size);
        for (int i = 0; i < size; i++) {
            isChecked = radioButtons.get(i).isSelected();

            if (!isChecked) {
                radioButtons.get(i).click();
                Thread.sleep(2000);
            }
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
