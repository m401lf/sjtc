package com.automationteststore.testCases.verifyLinks.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.utils.LinkUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = driver;
    }

    // https://the-internet.herokuapp.com/broken_images

    @Test
    public void linkTest(){
        this.driver.get("https://www.google.com");

        System.out.println("Before :: " + LocalDateTime.now());

        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("href"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());

        System.out.println("After :: " + LocalDateTime.now());
    }

    @AfterMethod
    public void quitDriver(){
        this.driver.quit();

    }
}