package com.automationteststore.testCases.Demos.DemoPractice.WebTable_HTMLTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.time.Duration;

public class PrintAllDataFromDynamicWebTable {
    WebDriver driver;

    @Test
    public void enterText() throws InterruptedException, ParseException {

        driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String row = "//*[@id='leftcontainer']/table/tbody/tr";

        int rowData = driver.findElements(By.xpath(row)).size();
        System.out.println(rowData);

        String col = "//*[@id='leftcontainer']/table/tbody/tr[1]/td";

        int colData = driver.findElements(By.xpath(col)).size();
        System.out.println(colData);

        //*[@id='leftcontainer']/table/tbody/tr[2]/td[1]

        String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";
        for (int i = 1; i <= rowData; i++) {
            for (int j = 1; j <= colData; j++) {
                String finalPart = firstPart + i + secondPart + j + thirdPart;
                //System.out.println(finalPart);
                String text = driver.findElement(By.xpath(finalPart)).getText();
                System.out.print(text + " | ");
            }
            System.out.println();
        }
    }
}
