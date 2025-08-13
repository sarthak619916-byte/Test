package com.pandemic.BDD.hooks;
import com.pandemic.BDD.setup.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.pandemic.BDD.utility.*;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hooks{
	static public ExtentReports extent=ExtentManager.getInstance();
	ExtentTest test;
@Before
 public void setup(Scenario scenario) {
	String urlKey="url1";
	if(scenario.getSourceTagNames().contains("@AnotherPage")) {
		//Thread.sleep(3000);
		urlKey="url2";
		//System.out.println("hooks");
	}
    DriverSetup.initDriver(urlKey);
    test=extent.createTest(scenario.getName());
}



@After
public void tearDown(Scenario scenario) {
  
    if (scenario.isFailed()) {
        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverSetup.getDriver(), scenario.getName().replaceAll(" ", "_"));
        scenario.attach(new File(screenshotPath).toURI().toString(), "image/png", "Screenshot");
    
        test.fail("Failed: " + scenario.getName()).addScreenCaptureFromPath("../screenshots/"+scenario.getName().replaceAll(" ", "_")+".png");
    } else {
        test.pass("Passed");
    }
    extent.flush(); 
   DriverSetup.quitDriver();
    }
}

	

