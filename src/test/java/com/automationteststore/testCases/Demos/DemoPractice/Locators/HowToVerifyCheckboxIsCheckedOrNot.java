package com.automationteststore.testCases.Demos.DemoPractice.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.text.ParseException;
import java.time.Duration;

public class HowToVerifyCheckboxIsCheckedOrNot {
    WebDriver driver;

    @Test
    public void enterText() throws InterruptedException, ParseException {

        // create chrome object
        driver = new ChromeDriver();
        // navigate to site
        driver.get("https://www.foundit.in/seeker/registration");
        // An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
        // or elements if they are not immediately available.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.PAGE_LOAD_TIME));
        // click on functions drop down
        driver.findElement(By.xpath("//*[@id='cat']/div[2]")).click();
        // check the Admin/Secretarial and Customer Service/ Call Centre/ BPO checkbox
        driver.findElement(By.xpath("//*[text()='Admin/Secretarial']/preceding-sibling::div")).click();
        driver.findElement(By.xpath("//*[text()='Customer Service/ Call Centre/ BPO']/preceding-sibling::div")).click();
        //driver.findElement(By.xpath("//*[text()='Human Resources']/preceding-sibling::div")).click();

        //org.openqa.selenium.InvalidSelectorException: invalid selector: Compound class names not permitted
        //driver.findElement(By.className("right clip_image closedropdown")).click();

        // to check whether check box is checked
        String check1 = driver.findElement(By.xpath("//*[text()='Customer Service/ Call Centre/ BPO']/preceding-sibling::input")).getAttribute("checked");
        System.out.println(check1);
        // to check whether check box is checked
        String check2 = driver.findElement(By.xpath("//*[text()='Admin/Secretarial']/preceding-sibling::input")).getAttribute("checked");
        System.out.println(check2);
        // to check whether check box is checked, here we will get null since this check box is not checked
        String check3 = driver.findElement(By.xpath("//*[text()='Human Resources']/preceding-sibling::input")).getAttribute("checked");
        System.out.println(check3);
        // close function drop down
        driver.findElement(By.xpath("//*[@class='right clip_image closedropdown']")).click();

        if (check1.contentEquals("true") && check2.contentEquals("true") && check3 == null) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false, "one of the checkbox data is not right");
        }
    }
}
