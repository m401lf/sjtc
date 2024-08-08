package com.automationteststore.testCases.Demos.DemoPractice.WebTable_HTMLTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class GetMaxPriceFromDynamicWebTable {
    WebDriver driver;

    @Test
    public void enterText() throws InterruptedException, ParseException {

        driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.PAGE_LOAD_TIME));

        String row = "//*[@id='leftcontainer']/table/tbody/tr";

        int rowData = driver.findElements(By.xpath(row)).size();
        System.out.println(rowData);
        WebElement currentPrice = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));

        String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
        String secondPart = "]/td[4]";

        ArrayList<Integer> array = new ArrayList<Integer>();

        for (int i = 1; i < rowData; i++) {
            String finalPart = firstPart + i + secondPart;
            System.out.println(finalPart);
            String price = driver.findElement(By.xpath(finalPart)).getText();

            //Double dPrice = Double.parseDouble(price);
            //int intPrice = dPrice.intValue();

            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            Number num = numberFormat.parse(price);
            price = num.toString();
            System.out.println(price);
            Double m = Double.parseDouble(price);
            int intPrice = m.intValue();
            array.add(intPrice);
        }

        Collections.sort(array);
        System.out.println(array);
        System.out.println(array.get(0));
        System.out.println(array.get(array.size() - 1));
    }
}
