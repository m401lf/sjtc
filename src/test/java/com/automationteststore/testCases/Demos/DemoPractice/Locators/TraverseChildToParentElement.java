package com.automationteststore.testCases.Demos.DemoPractice.Locators;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TraverseChildToParentElement {


    public static void main(String[] args) {

// TODO Auto-generated method stub


        WebDriver driver = new ChromeDriver();

// Sibling - Child to parent traverse

//header/div/button[1]/following-sibling::button[1]

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());


        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());


    }


}




