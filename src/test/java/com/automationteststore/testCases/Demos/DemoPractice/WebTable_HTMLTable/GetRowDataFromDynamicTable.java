package com.automationteststore.testCases.Demos.DemoPractice.WebTable_HTMLTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.time.Duration;

public class GetRowDataFromDynamicTable {
    WebDriver driver;

    @Test
    public void enterText() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.PAGE_LOAD_TIME));

        String rowData = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[4]")).getText();
        System.out.println("data of row is : " + rowData);

        rowData = driver.findElement(By.xpath("//a[contains(text(),'Bank of India')]/parent::*/following-sibling::td[3]")).getText();

        System.out.println("data of row is : " + rowData);
    }
}
