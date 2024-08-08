package com.automationteststore.testCases.Demos.TestNGTutorial;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
//rahulonlinetutor@gmail.com

public class day4 {

    @Parameters({"URL"})
    @Test
    public void WebloginHomeLoan(String uname) {
        //selenium
        System.out.println("webloginhomePersonalLoan");
        System.out.println(uname);

    }


    @Test(groups = {"Smoke"})
    public void MobileLoginHomeLoan() {
        //Appium
        System.out.println("MobileloginHome");
    }

    @Test
    public void LoginAPIHomeLoan() {
        //Rest API automation
        System.out.println("APIloginHome");
    }
}
