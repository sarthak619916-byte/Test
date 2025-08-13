Feature: Virus Test Form Submission

  Scenario: Submission with valid data for Virus Test 
    Given the user is on the Virus Test page
    When the user submits the form with "Valid" data
    Then the form should be submitted successfully

  Scenario: Submission with Invalid data for Virus Test
    Given the user is on the Virus Test page
    When the user submits the form with "Invalid" data
    Then the form should not be submitted

  Scenario: Submission with Empty fields for Virus Test
    Given the user is on the Virus Test page
    When the user submits the form with "Empty" data
    Then the form should show validation errors

   Scenario: Output if contact with person is selected as Yes
    Given the user is on the Virus Test page
    When the user submits the form with "Valid" data with contact with person as Yes
    Then the form should be submitted successfully
    And Output should contain you have Chance