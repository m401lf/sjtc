package com.automationteststore.testCases.Demos.DemoPractice.cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.time.Duration;
import java.util.Set;

public class AddCookiesInSelenium {
    WebDriver driver;

    @Test
    public void enterText() throws ParseException {

        driver = new ChromeDriver();
        // navigate to site
        driver.get("https://www.flipkart.com/");
        // An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
        // or elements if they are not immediately available.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Cookie cookie = new Cookie("customeCookie", "12345");

        driver.manage().addCookie(cookie);

        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cook : cookies) {
            System.out.println(cook);
        }
    }
}
