package com.automationteststore.testCases.Demos.DemoPractice.Locators;

import com.automationteststore.testCases.Demos.DemoPractice.Generic_Methods.Generic_GetMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ElementListDemo {

    private WebDriver driver;
    private String baseUrl;
    private Generic_GetMethods gm;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        gm = new Generic_GetMethods(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");

        int size = elementList.size();
        System.out.println("Size of the element list is: " + size);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        //driver.quit();
    }
}
