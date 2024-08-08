package testCases.Demos.DemoPractice.Mouse_Actions.KeyPress;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class KeyPressDemo2 {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a");
        Thread.sleep(2000);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        //Thread.sleep(2000);
        String selectAll = Keys.chord(Keys.COMMAND, "a");
        driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}