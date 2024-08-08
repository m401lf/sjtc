package testCases.Demos.DemoPractice.Selenium_WebDriver_Basic.WebElementInterface;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class findElementby_W {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testRelativexpath() throws Exception {
        driver.get(baseUrl + "/whizTrial/");
        driver.findElement(By.id("Lid")).sendKeys("gsahai");  // Enter the username in the 'Username' input field
        driver.findElement(By.id("Lpwd")).sendKeys("pass123");   //  Enter the password in the 'Password' input field
        driver.findElement(By.id("Lsub")).click();  // Click on the 'Login' button
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "WhizTrial Welcome"); // Verifying the welcome page

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }
}