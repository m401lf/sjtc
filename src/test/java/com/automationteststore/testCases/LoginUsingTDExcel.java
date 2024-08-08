package com.automationteststore.testCases;

import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.utils.ExcelUtil;

import java.io.IOException;


public class LoginUsingTDExcel {

    public static void main(String[] args) throws BiffException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/index.php?rt=account/login");
        ExcelUtil util = new ExcelUtil("C:\\data.xls");
        driver.findElement(By.xpath("//input[@id='loginFrm_loginname']")).sendKeys(ExcelUtil.ReadCell("UserName", 1));
        driver.findElement(By.xpath("//input[@id='loginFrm_password']")).sendKeys(ExcelUtil.ReadCell("Password", 1));
        System.out.println("Login name :: " + ExcelUtil.ReadCell("UserName", 1));
        System.out.println("Password :: " + ExcelUtil.ReadCell("Password", 1));
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.quit();

    }
}