package com.pandemic.BDD.definations;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import com.pandemic.BDD.pages.*;
import com.pandemic.BDD.setup.DriverSetup;
import com.pandemic.BDD.utility.ExtentManager;
import com.pandemic.BDD.hooks.Hooks;
import com.aventstack.extentreports.*;


public class DistrictPassDefination {
	static public ExtentReports extent=ExtentManager.getInstance();
    DistrinctPassTestPage districtPage;

    @Given("User is on the E-Pass application page")
    public void user_is_on_epass_page() {
    	
        districtPage=new  DistrinctPassTestPage(DriverSetup.getDriver());
    }

    @When("User fills the form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_fills_the_form(String name, String email, String mobile1, String mobile2, String mobile3,
                                    String district, String gender, String aadhaar, String reason) {
    	
        districtPage.fillForm(name, email, mobile1, mobile2, mobile3, district, gender, aadhaar, reason);
        
    }
    @And("User submits the form")
    public void user_submits_form() {
    	
        districtPage.submitForm();
    }

    @Then("Proper form result should be displayed for \"success\"")
    public void form_should_be_submitted_successfully() {
        Assert.assertTrue(districtPage.isSubmittedSuccessfully());
    }
    @Then("Form should not be submitted")
    public void form_should_not_be_submitted_successfully() {
        Assert.assertFalse(districtPage.isSubmittedSuccessfully());
    }

    @Then("Proper form result should be displayed for \"error\"")
    public void error_messages_should_be_displayed_for_empty_fields() {
        Assert.assertTrue(districtPage.hasValidationErrors());
    }
    @And("table should be there as a result")
    public void check_table_is_there() {
    	Assert.assertTrue(districtPage.chekTable());
    }
   
}
