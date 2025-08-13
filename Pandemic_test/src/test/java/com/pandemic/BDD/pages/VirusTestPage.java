package com.pandemic.BDD.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class VirusTestPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By aboveYesRadio = By.id("aboveyes");
    private final By aboveNoRadio = By.id("aboveno");
    private final By belowYesRadio = By.id("belowyes");
    private final By belowNoRadio = By.id("belowno");
    private final By livingWithDropdown = By.id("livingwith");
    private final By contactYesRadio = By.id("contactyes");
    private final By contactNoRadio = By.id("contactno");
    private final By symptom1 = By.id("symptom1");
    private final By symptom2 = By.id("symptom2");
    private final By symptom3 = By.id("symptom3");
    private final By symptom4 = By.id("symptom4");
    private final By symptom5 = By.id("symptom5");
    private final By submitButton = By.xpath("//input[@value='Submit']");

    public VirusTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillForm(String[] data) {
        try {
            if (data[0].equalsIgnoreCase("Yes")) wait.until(ExpectedConditions.elementToBeClickable(aboveYesRadio)).click();
            else if (data[0].equalsIgnoreCase("No")) wait.until(ExpectedConditions.elementToBeClickable(aboveNoRadio)).click();

            if (data[1].equalsIgnoreCase("Yes")) wait.until(ExpectedConditions.elementToBeClickable( belowYesRadio)).click();
            else if (data[1].equalsIgnoreCase("No")) wait.until(ExpectedConditions.elementToBeClickable(belowNoRadio)).click();

            if (!data[2].isEmpty()) new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(livingWithDropdown))).selectByVisibleText(data[2]);

            if (data[3].equalsIgnoreCase("Yes")) wait.until(ExpectedConditions.elementToBeClickable(contactYesRadio)).click();
            else if (data[3].equalsIgnoreCase("No")) wait.until(ExpectedConditions.elementToBeClickable(contactNoRadio)).click();

            switch (data[4].toLowerCase()) {
                case "feeling tired or week":
                    wait.until(ExpectedConditions.elementToBeClickable(symptom1)).click(); break;
                case "persistent cough":
                    wait.until(ExpectedConditions.elementToBeClickable(symptom2)).click(); break;
                case "runny nose":
                    wait.until(ExpectedConditions.elementToBeClickable(symptom3)).click(); break;
                case "head ache":
                    wait.until(ExpectedConditions.elementToBeClickable(symptom4)).click(); break;
                case "loss of taste or smell":
                    wait.until(ExpectedConditions.elementToBeClickable(symptom5)).click(); break;
            }

            wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSubmitted() {
        return !driver.findElement(By.id("testresult")).getText().isEmpty();
    }

    public boolean hasValidationErrors() {
        return driver.findElements(By.cssSelector("label[style*='color:red']")).size() > 0;
    }
    public boolean checkMessage() {
    	String res=driver.findElement(By.id("testresult")).getText();
    	return res.contains("affected");
    }
}
