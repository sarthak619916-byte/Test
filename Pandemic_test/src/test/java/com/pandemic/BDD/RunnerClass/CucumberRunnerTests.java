package com.pandemic.BDD.RunnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/java/com/pandemic/BDD/features",
	    glue = {"com.pandemic.BDD.definations", "com.pandemic.BDD.hooks"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber.html",
	        "json:target/cucumber-reports/CucumberTestReport.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    monochrome = true
	)
	public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	}


