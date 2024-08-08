package testCases.Demos.SeleniumWebDriverBasic.TimeOutsInterface;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class implicitwait_R {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testExplicitwait() throws Exception {
        driver.get("https://www.google.co.in/");

        driver.findElement(By.id("lst-iib")).sendKeys("Selenium Webdriver");

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
