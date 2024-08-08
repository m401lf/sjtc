package com.automationteststore.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/automationteststore/features",
        glue = "com/automationteststore/stepDefinitions",
        publish = true,
        monochrome = true,
        //dryRun = true,
        //tags = "@all",
        //tags = "@Login00001",
        //tags = "@RegistrationDataTableTransformer or @LoginDataTableTransformer",
        //tags = "@RegistrationDataTableTransformer",
        //tags = "@RegistrationWithComplexDataTableUsingMap",
        //tags = "@LoginDataTableTransformer",
        tags = "@RegistrationWithWaitStrategy",
        //tags = "@ForgottenLoginname",
        //tags = "@RecoveryForgottenPassword",
        //tags = "@Search_E2E",
        //tags = "@SearchUsingFilterE2e",
        //tags = "Homepage_CompleteOrder_E2E_1",
        //tags = "@Homepage_CompleteOrder_E2E_2",
        //tags = "@search001",
        //tags = "@Registration001",
        //tags = "@RegistrationDataTable",
        //tags = "@LoginDataTableTransformer",
        //tags = "@RegistrationWithPasswordNotStrongEnough",
        //tags = "@RegistrationWithPasswordTooShort",
        //tags = "@RegistrationWithPasswordTooLong",
        //tags = "@RegistrationWithPasswordNotMatching",
        //tags = "@RegistrationWithPhoneNumberNotValid",
        //tags = "@RegistrationWithPhoneNumberNotUnique",
        //tags = "@RegistrationWithInvalidData",
        //tags = "@RegistrationWithAssertions",
        //tags = "@RegistrationWithValidCredentials",
        //tags = "@Registration",
        //tags = "@2-SortBy-Name-A-Z",
        //name = "reg",
        //tags = "@Reg001",
        //tags =
        //name = "reg",
        plugin = {
                "pretty",
                "json:target/json_output/cucumber.json",
                "junit:target/junit_xml_output/cucumber.xml",
                "html:cucumberReport/cucumber.html",
                "html:target/html_output/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })

public class Runner extends AbstractTestNGCucumberTests {
/*  @Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/

}

