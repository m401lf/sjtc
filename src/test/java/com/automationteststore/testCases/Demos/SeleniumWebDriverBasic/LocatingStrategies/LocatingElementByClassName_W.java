package com.automationteststore.testCases.Demos.SeleniumWebDriverBasic.LocatingStrategies;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LocatingElementByClassName_W {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testRelativexpath() throws Exception {
        driver.get(baseUrl + "/whizTrial/");
        String name = driver.findElement(By.className("about-author")).getText();
        System.out.println(name);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}

