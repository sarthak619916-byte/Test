package com.pandemic.BDD.definations;

import com.pandemic.BDD.pages.VirusTestPage;
import com.pandemic.BDD.utility.ExcelReader;
import com.pandemic.BDD.setup.DriverSetup;
import io.cucumber.java.en.*;
import org.testng.Assert;
import com.pandemic.BDD.utility.*;

public class virusTestDefination {
    VirusTestPage page;

    @Given("the user is on the Virus Test page")
    public void user_is_on_page() {
    	
        page = new VirusTestPage(DriverSetup.getDriver());
    }

    @When("the user submits the form with {string} data")
    public void submits_form(String scenarioType) {
        try {
            page.fillForm(ExcelReader.getData(scenarioType));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @When("the user submits the form with {string} data with contact with person as Yes")
    public void submit_form_with_contact(String scenarioType) {
    	try {
            page.fillForm(ExcelReader.getData(scenarioType));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("the form should be submitted successfully")
    public void assert_success() {
        Assert.assertTrue(page.isSubmitted());
    }

    @Then("the form should not be submitted")
    public void assert_failure() {
        Assert.assertFalse(page.isSubmitted());
    }

    @Then("the form should show validation errors")
    public void assert_validation_errors() {
        Assert.assertTrue(page.hasValidationErrors());
    }
    @And("Output should contain you have Chance")
    	public void check() {
    	Assert.assertTrue(page.checkMessage());
    }
    
}
