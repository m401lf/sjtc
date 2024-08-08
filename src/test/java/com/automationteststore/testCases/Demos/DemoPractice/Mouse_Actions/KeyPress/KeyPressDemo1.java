package testCases.Demos.DemoPractice.Mouse_Actions.KeyPress;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class KeyPressDemo1 {
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
        driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
        Thread.sleep(2000);
        driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
        //driver.findElement(By.id("user_password")).sendKeys("123123");
        //Thread.sleep(2000);
        //driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        // driver.quit();
    }
}