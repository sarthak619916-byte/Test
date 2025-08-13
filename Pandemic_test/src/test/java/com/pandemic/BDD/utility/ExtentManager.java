package com.pandemic.BDD.utility;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentManager {
	    private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	            spark.config().setTheme(Theme.STANDARD);
	            spark.config().setDocumentTitle("ExtentReport");
	            spark.config().setReportName("Automation Report for pandemic");

	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            extent.setSystemInfo("Tester", "Sarthak Sharma");
	            extent.setSystemInfo("Environment", "QA");
	        }
	        return extent;
	    }
	}

