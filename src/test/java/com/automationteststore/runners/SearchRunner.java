package com.automationteststore.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "com/automationteststore/stepDefinitions",
        publish = true,
        monochrome = true,
        //dryRun = true,
        //tags = "@all",
        //tags = "@Search_E2E",
        //tags = "@SearchUsingFilterE2e",
        //tags = "@search001",
        //tags = "",
        plugin = {
                "pretty",
                "json:target/json_output/cucumber.json",
                "junit:target/junit_xml_output/cucumber.xml",
                "html:cucumberReport/cucumber.html",
                "html:target/html_output/cucumber.html"
        })

public class SearchRunner extends AbstractTestNGCucumberTests {
/*  @Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/


}

