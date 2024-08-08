package testCases.Demos.SeleniumWebDriverBasic.WebElementInterface;


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

public class Clear_R {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","F:\\Selenium Project\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        baseUrl = "https://www.google.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Clear() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
        Thread.sleep(3000);
        driver.findElement(By.id("lst-ib")).clear(); // It will clear the text from the search box
        Thread.sleep(3000);
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium Webdriver");
        Thread.sleep(3000);
        driver.findElement(By.name("btnG")).click();
        driver.findElement(By.linkText("Selenium WebDriver")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}


