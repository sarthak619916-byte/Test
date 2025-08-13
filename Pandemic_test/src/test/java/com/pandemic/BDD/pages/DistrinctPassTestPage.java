package com.pandemic.BDD.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.logging.*;
public class DistrinctPassTestPage {
	
Logger logger=Logger.getLogger(DistrinctPassTestPage.class.getName());
	

	    WebDriver driver;
	    WebDriverWait wait;

	    public DistrinctPassTestPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	   
	    By nameField = By.id("name");
	    By emailField = By.id("email");
	    By mobileField1 = By.id("mobile1");
	    By mobileField2 = By.id("mobile2");
	    By mobileField3 = By.id("mobile3");
	    By districtDropdown = By.id("district");
	    By genderMale = By.id("Gender_0");
	    By genderFemale = By.id("Gender_1");
	    By genderOther = By.id("Gender_2");
	    By aadhaarField = By.id("aadhaar");
	    By reasonDropdown = By.id("reason");
	    By submitBtn = By.id("submitDistrict");
	    By successMessage = By.id("districtView");
	    By errorMessages = By.cssSelector("label[style*='color:red']");

	    public void fillForm(String name, String email, String mobile1, String mobile2, String mobile3,
                String district, String gender, String aadhaar, String reason) {
	    	logger.info("Started filling form");
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
	            driver.findElement(emailField).sendKeys(email);
	            driver.findElement(mobileField1).sendKeys(mobile1);
	            driver.findElement(mobileField2).sendKeys(mobile2);
	            driver.findElement(mobileField3).sendKeys(mobile3);
	            new Select(driver.findElement(districtDropdown)).selectByVisibleText(district); 
	            driver.findElement(genderMale).click(); // Select Male
	            driver.findElement(aadhaarField).sendKeys(aadhaar);
	            new Select(driver.findElement(reasonDropdown)).selectByVisibleText(reason); 
	           logger.fine("form is filled");
	        }
	        catch (Exception e) {
	            logger.severe("Error filling valid details: " + e.getMessage());
	            
	        }
	    }

	    public void fillEmptyDetails() {
	    	logger.info("no data is passed");
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).clear();
	            driver.findElement(emailField).clear();
	            driver.findElement(mobileField1).clear();
	            driver.findElement(mobileField2).clear();
	            driver.findElement(mobileField3).clear();
	            driver.findElement(aadhaarField).clear();
	        } catch (Exception e) {
	            System.out.println("Error clearing fields: " + e.getMessage());
	        }
	    }

	    public void fillInvalidDetails() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys("!@#123");
	            driver.findElement(emailField).sendKeys("invalid-email");
	            driver.findElement(mobileField1).sendKeys("abc");
	            driver.findElement(mobileField2).sendKeys("xyz");
	            driver.findElement(mobileField3).sendKeys("jgjg");
	            new Select(driver.findElement(districtDropdown)).selectByVisibleText("Chennai");
	            driver.findElement(genderOther).click();
	            driver.findElement(aadhaarField).sendKeys("123");
	            new Select(driver.findElement(reasonDropdown)).selectByVisibleText("Interview");
	        } catch (Exception e) {
	            System.out.println("Error filling invalid details: " + e.getMessage());
	        }
	    }

	    public void submitForm() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	        } catch (Exception e) {
	            System.out.println("Error clicking submit: " + e.getMessage());
	        }
	    }

	    public boolean isSubmittedSuccessfully() {
	        try {
	            return !wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText().isEmpty();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public boolean hasValidationErrors() {
	        try {
	            return driver.findElements(errorMessages).size() > 0;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    public boolean chekTable() {
	    	return driver.findElement(By.tagName("table")).isDisplayed();
	    }
	}


