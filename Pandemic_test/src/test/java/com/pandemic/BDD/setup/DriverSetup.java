package com.pandemic.BDD.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverSetup {
    private static WebDriver driver;

    public static void initDriver(String urlKey) {
        try {
            String browser = ConfigReader.getProperty("browser");
            String url = ConfigReader.getProperty(urlKey);

            if (browser.equalsIgnoreCase("chrome")) {
               
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}