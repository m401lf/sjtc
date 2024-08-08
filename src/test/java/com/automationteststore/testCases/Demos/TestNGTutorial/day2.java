package com.automationteststore.testCases.Demos.TestNGTutorial;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day2 {


    @Test(groups = {"Smoke"})
    public void ploan() {
        System.out.println("good");
    }

    @BeforeMethod
    public void prerequiste() {
        System.out.println("I will execute first");
    }
}
