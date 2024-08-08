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

public class Combinations_XPath_W {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testCombinations() throws Exception {
        driver.get("http://localhost/whizTrial/");

        //Specific tag with specific attribute value
    /*driver.findElement(By.xpath("//input[@id='Lid']")).clear();
    driver.findElement(By.xpath("//input[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.xpath("//input[@id='Lpwd']")).sendKeys("pass123");
    driver.findElement(By.xpath("//input[@id='Lsub']")).click();*/


        //Any tag with specific attribute value
    /*driver.findElement(By.xpath("//input[@id='Lid']")).clear();
    driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.xpath("//input[@id='Lpwd']")).sendKeys("pass123");
    driver.findElement(By.xpath("//*[@value='Login']")).click();*/

        //Using 'and' operator
    /*driver.findElement(By.xpath("//input[@id='Lid']")).clear();
    driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.xpath("//input[@type='password'and @name='userauth']")).sendKeys("pass123");
    driver.findElement(By.xpath("//*[@value='Login']")).click();*/

        //Using 'or' operator
    /*driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.xpath("//input[@type='password'or @name='userauth']")).sendKeys("pass123");
    driver.findElement(By.xpath("//*[@value='Login']")).click();*/

        //Using 'starts-with' approach
    /*driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.xpath("//input[@type='password'or @name='userauth']")).sendKeys("pass123");
    driver.findElement(By.xpath("//input[starts-with(@name,'commit')]")).click();*/

        //Using 'contains' approach
    /*driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
    driver.findElement(By.xpath("//input[contains(@id,'Lpwd')]")).sendKeys("pass123");
    driver.findElement(By.xpath("//*[@value='Login']")).click();*/

        //Matching value of any attribute
        driver.findElement(By.xpath("//*[@id='Lid']")).sendKeys("gsahai");
        driver.findElement(By.xpath("//input[contains(@id,'Lpwd')]")).sendKeys("pass123");
        driver.findElement(By.xpath("//input[@*='Lsub']")).click();

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }

}
