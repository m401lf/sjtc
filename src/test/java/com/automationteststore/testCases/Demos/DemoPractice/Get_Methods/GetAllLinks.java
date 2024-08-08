package com.automationteststore.testCases.Demos.DemoPractice.Get_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GetAllLinks {
    WebDriver driver;

    @Test
    public void enterText() throws ParseException {

        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //List<WebElement> links = driver.findElements(By.xpath("//a"));
        List<WebElement> links = driver.findElements(By.xpath("//*"));
        System.out.println(links.size());
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < links.size(); i++) {

            System.out.println(links.get(i).getText());

            data.add(links.get(i).getAttribute("href"));

            System.out.println(links.get(i).getAttribute("href"));
        }

        System.out.println(data.size());

    }


}