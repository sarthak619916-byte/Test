package com.pandemic.BDD.utility;


	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;

	public class ScreenshotUtil {

	    public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String dest = "screenshots/" + screenshotName + ".png";

	        try {
	            Files.copy(src.toPath(), new File(dest).toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return dest;
	    }
	}