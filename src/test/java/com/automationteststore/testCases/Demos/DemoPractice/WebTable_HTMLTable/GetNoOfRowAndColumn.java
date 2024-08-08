package com.automationteststore.testCases.Demos.DemoPractice.WebTable_HTMLTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.time.Duration;

public class GetNoOfRowAndColumn {
    WebDriver driver;

    @Test
    public void enterText() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.PAGE_LOAD_TIME));
        int rowsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
        System.out.println("number of rows are: " + rowsNumber);

        int colsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
        System.out.println("number of cols are: " + colsNumber);
    }
}
